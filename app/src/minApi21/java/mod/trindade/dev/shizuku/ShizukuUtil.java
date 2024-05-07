package mod.trindade.dev.shizuku;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mod.SketchwareUtil;

public class ShizukuUtil {

    public static void addRequest(AppCompatActivity activity) {
        //No support for minApi21
    }

    public static void onRequestPermissionsResult(int requestCode, int grantResult) {
        //No support for minApi21
    }

    public static void removeRequest() {
        //No support for minApi21
    }

    public static boolean checkPermission(int code) {
        //No support for minApi21
        return false;
    }
    
    public static void goDemo (Context ctx) {
        SketchwareUtil.toastError("not available in minApi21");
    }    
}