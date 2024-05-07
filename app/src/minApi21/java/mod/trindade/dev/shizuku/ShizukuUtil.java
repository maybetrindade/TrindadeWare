package mod.trindade.dev.shizuku;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context; 

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import mod.SketchwareUtil; 

public class ShizukuUtil {

    public static void setBinders () {}
    
    public static void bindUserService() {}

    public static void addRequest () {}

    public static void onRequestPermissionsResult (int requestCode, int grantResult) {}

    public static void removeRequest () {}

    public static boolean checkPermission (int code) { return false; }
    
    public static void goDemo (Context ctx) { SketchwareUtil.toastError("Only for minApi26"); }    
    
    public static void getUsers() {}
    
    public static void installApks() {}
    
    public static void doInstallApks(List<Uri> uris) {}
    
    public static void unbindUserService() {}

    public static void peekUserService() {}
}