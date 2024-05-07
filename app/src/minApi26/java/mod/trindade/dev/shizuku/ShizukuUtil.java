package mod.trindade.dev.shizuku;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import rikka.shizuku.Shizuku;
import rikka.shizuku.demo.DemoActivity;

public class ShizukuUtil {

    public static Shizuku.OnRequestPermissionResultListener onRequestPermissionResultListener =
            (requestCode, grantResult) -> {
                onRequestPermissionsResult(requestCode, grantResult);
            };

    public static void addRequest(AppCompatActivity activity) {
        Shizuku.addRequestPermissionResultListener(onRequestPermissionResultListener);
    }

    public static void onRequestPermissionsResult(int requestCode, int grantResult) {
        boolean granted = grantResult == PackageManager.PERMISSION_GRANTED;
    }

    public static void removeRequest() {
        Shizuku.removeRequestPermissionResultListener(onRequestPermissionResultListener);
    }

    public static boolean checkPermission(int code) {
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
    
    public static void goDemo (Context ctx) {
        Intent in = new Intent(ctx, DemoActivity.class);
        ctx.startActivity();
    }    
}