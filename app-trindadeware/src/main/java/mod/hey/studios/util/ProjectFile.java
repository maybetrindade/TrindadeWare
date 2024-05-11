package mod.hey.studios.util;

import android.graphics.Color;

import a.a.a.lC;
import a.a.a.yB;

public class ProjectFile {

    public static int getColor(String sc_id, String color) {
        return yB.a(lC.b(sc_id), color, getDefaultColor(color));
        /*
        Old in-progress by Mike?
        HashMap<String, Object> hashMap = lC.b(sc_id);

        return 0;//yB.a(hashMap, color, getDefaultColor(color));
        */
    }

	/*
	 // comment by Jbk0
	 // the smali files say something completely different lol

	 package a.a.a;
	 import java.util.Map;

	 public class yB {
	 public static int a(Map<String, Object> paramMap, String paramString, int paramInt) {

	 return 0;

	 }
	 }
	*/

    private static int getDefaultColor(String color) {
        switch (color) {
            case "color_primary_dark":
                return Color.parseColor("#FF2196F3");

            case "color_control_highlight":
                return Color.parseColor("#992196F3");

            case "color_control_normal":
                return Color.parseColor("#FF2196F3");

            default:
                return Color.parseColor("#2196F3");
        }
    }
}