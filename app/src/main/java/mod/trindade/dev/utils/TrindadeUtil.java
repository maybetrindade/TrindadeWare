package mod.trindade.dev.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class TrindadeUtil {

    public static void openUrl(Context context, String url) {
        Activity activity = unwrap(context);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
    }

    private static Activity unwrap(Context context) {
        while (!(context instanceof Activity) && context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }
}