package mod.trindade.dev.shizuku;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.PackageManager;
import rikka.shizuku.Shizuku;

public class ShizukuUtil extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final Shizuku.OnRequestPermissionResultListener REQUEST_PERMISSION_RESULT_LISTENER =
            this::onRequestPermissionsResult;
    }
    
    // put on "onCreate" event
    public static void addRequest () {
        Shizuku.addRequestPermissionResultListener(REQUEST_PERMISSION_RESULT_LISTENER);
    }
    
    public static void onRequestPermissionsResult(int requestCode, int grantResult) {
        boolean granted = grantResult == PackageManager.PERMISSION_GRANTED;
    }
    
    // put on "onDestroy" event
    public static void removeRequest () {
        Shizuku.removeRequestPermissionResultListener(REQUEST_PERMISSION_RESULT_LISTENER);
    }
    
    // 
    public static boolean checkPermission (int code) {
        if (Shizuku.isPreV11()) {
            return false;
        } 
        if (Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else if (Shizuku.shouldShowRequestPermissionRationale()) {
            return false;
        } else {
            Shizuku.requestPermission(code);
            return false;
        }
    }
}
