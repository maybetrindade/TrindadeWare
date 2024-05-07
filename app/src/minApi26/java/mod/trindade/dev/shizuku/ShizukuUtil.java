package mod.trindade.dev.shizuku;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context; 

import androidx.appcompat.app.AppCompatActivity;

import rikka.shizuku.Shizuku;
import rikka.shizuku.ShizukuBinderWrapper;
import rikka.shizuku.ShizukuSystemProperties;
import rikka.shizuku.demo.databinding.MainActivityBinding;
import rikka.shizuku.demo.service.UserService;
import rikka.shizuku.demo.util.ApplicationUtils;
import rikka.shizuku.demo.util.IIntentSenderAdaptor;
import rikka.shizuku.demo.util.IntentSenderUtils;
import rikka.shizuku.demo.util.PackageInstallerUtils;
import rikka.shizuku.demo.util.ShizukuSystemServerApi;

public class ShizukuUtil {

    public final Shizuku.OnBinderReceivedListener BINDER_RECEIVED_LISTENER = () -> {
        if (Shizuku.isPreV11()) {
            binding.text1.setText("Shizuku pre-v11 is not supported");
        } else {
            binding.text1.setText("Binder received");
        }
    };
    public final Shizuku.OnBinderDeadListener BINDER_DEAD_LISTENER = () -> binding.text1.setText("Binder dead");
    public final Shizuku.OnRequestPermissionResultListener REQUEST_PERMISSION_RESULT_LISTENER = this::onRequestPermissionsResult;
    
    
    public static void setBinders () {
        Shizuku.addBinderReceivedListenerSticky(BINDER_RECEIVED_LISTENER);
        Shizuku.addBinderDeadListener(BINDER_DEAD_LISTENER);
        Shizuku.addRequestPermissionResultListener(REQUEST_PERMISSION_RESULT_LISTENER);
    }
    
    public static void bindUserService() {
        StringBuilder res = new StringBuilder();
        try {
            if (Shizuku.getVersion() < 10) {
                res.append("requires Shizuku API 10");
            } else {
                Shizuku.bindUserService(userServiceArgs, userServiceConnection);
            }
        } catch (Throwable tr) {
            tr.printStackTrace();
            res.append(tr.toString());
        }
        
    }

    public static Shizuku.OnRequestPermissionResultListener onRequestPermissionResultListener =
            (requestCode, grantResult) -> {
                onRequestPermissionsResult(requestCode, grantResult);
            };

    public static void addRequest () {
        Shizuku.addRequestPermissionResultListener(onRequestPermissionResultListener);
    }

    public static void onRequestPermissionsResult (int requestCode, int grantResult) {
        boolean granted = grantResult == PackageManager.PERMISSION_GRANTED;
    }

    public static void removeRequest () {
        Shizuku.removeRequestPermissionResultListener(onRequestPermissionResultListener);
    }

    public static boolean checkPermission (int code) {
        if (Shizuku.isPreV11()) {
            return false;
        }
        if (Shizuku.checkSelfPermission () == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else if (Shizuku.shouldShowRequestPermissionRationale()) {
            return false;
        } else {
            Shizuku.requestPermission(code);
            return false;
        }
    }
    
    public static void goDemo (Context ctx) {
        Intent in = new Intent(ctx, DemoActivity.class);
        ctx.startActivity();
    }    
    
    public static void getUsers() {
        String res;
        try {
            res = ShizukuSystemServerApi.UserManager_getUsers(true, true, true).toString();
        } catch (Throwable tr) {
            tr.printStackTrace();
            res = tr.getMessage();
        }
    }
    
    public static void installApks() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setType("application/vnd.android.package-archive");

        startActivityForResult(intent, REQUEST_CODE_PICK_APKS);
    }
    
    public void doInstallApks(List<Uri> uris) {
        PackageInstaller packageInstaller;
        PackageInstaller.Session session = null;
        ContentResolver cr = getContentResolver();
        StringBuilder res = new StringBuilder();
        String installerPackageName;
        String installerAttributionTag = null;
        int userId;
        boolean isRoot;

        try {
            IPackageInstaller _packageInstaller = ShizukuSystemServerApi.PackageManager_getPackageInstaller();
            isRoot = Shizuku.getUid() == 0;

            // the reason for use "com.android.shell" as installer package under adb is that getMySessions will check installer package's owner
            installerPackageName = isRoot ? getPackageName() : "com.android.shell";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                installerAttributionTag = getAttributionTag();
            }
            userId = isRoot ? Process.myUserHandle().hashCode() : 0;
            packageInstaller = PackageInstallerUtils.createPackageInstaller(_packageInstaller, installerPackageName, installerAttributionTag, userId);
            int sessionId;
            res.append("createSession: ");

            PackageInstaller.SessionParams params = new PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL);
            int installFlags = PackageInstallerUtils.getInstallFlags(params);
            installFlags |= 0x00000004/*PackageManager.INSTALL_ALLOW_TEST*/ | 0x00000002/*PackageManager.INSTALL_REPLACE_EXISTING*/;
            PackageInstallerUtils.setInstallFlags(params, installFlags);

            sessionId = packageInstaller.createSession(params);
            res.append(sessionId).append('\n');

            res.append('\n').append("write: ");

            IPackageInstallerSession _session = IPackageInstallerSession.Stub.asInterface(new ShizukuBinderWrapper(_packageInstaller.openSession(sessionId).asBinder()));
            session = PackageInstallerUtils.createSession(_session);

            int i = 0;
            for (Uri uri : uris) {
                String name = i + ".apk";

                InputStream is = cr.openInputStream(uri);
                OutputStream os = session.openWrite(name, 0, -1);

                byte[] buf = new byte[8192];
                int len;
                try {
                    while ((len = is.read(buf)) > 0) {
                        os.write(buf, 0, len);
                        os.flush();
                        session.fsync(os);
                    }
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                i++;

                Thread.sleep(1000);
            }

            res.append('\n').append("commit: ");

            Intent[] results = new Intent[]{null};
            CountDownLatch countDownLatch = new CountDownLatch(1);
            IntentSender intentSender = IntentSenderUtils.newInstance(new IIntentSenderAdaptor() {
                @Override
                public void send(Intent intent) {
                    results[0] = intent;
                    countDownLatch.countDown();
                }
            });
            session.commit(intentSender);

            countDownLatch.await();
            Intent result = results[0];
            int status = result.getIntExtra(PackageInstaller.EXTRA_STATUS, PackageInstaller.STATUS_FAILURE);
            String message = result.getStringExtra(PackageInstaller.EXTRA_STATUS_MESSAGE);
            res.append('\n').append("status: ").append(status).append(" (").append(message).append(")");

        } catch (Throwable tr) {
            tr.printStackTrace();
            res.append(tr);
        } finally {
            if (session != null) {
                try {
                    session.close();

                } catch (Throwable tr) {
                    res.append(tr);
                }
            }
        }
    }
    public static void unbindUserService() {
        StringBuilder res = new StringBuilder();
        try {
            if (Shizuku.getVersion() < 10) {
                res.append("requires Shizuku API 10");
            } else {
                Shizuku.unbindUserService(userServiceArgs, userServiceConnection, true);
            }
        } catch (Throwable tr) {
            tr.printStackTrace();
            res.append(tr.toString());
        }
    }

    public static void peekUserService() {
        StringBuilder res = new StringBuilder();
        try {
            if (Shizuku.getVersion() < 12) {
                res.append("requires Shizuku API 12");
            } else {
                int serviceVersion = Shizuku.peekUserService(userServiceArgs, userServiceConnection);
                if (serviceVersion != -1) {
                    res.append("Service is running, version ").append(serviceVersion);
                } else {
                    res.append("Service is not running");
                }
            }
        } catch (Throwable tr) {
            tr.printStackTrace();
            res.append(tr.toString());
        }
    }   
}