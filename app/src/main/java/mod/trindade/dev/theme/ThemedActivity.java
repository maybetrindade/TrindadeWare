package mod.trindade.dev.theme;

import androidx.appcompat.app.AppCompatActivity; 
import androidx.activity.EdgeToEdge;

import android.os.Bundle;
import android.view.View;

import mod.trindade.dev.theme.AppTheme;

public class ThemedActivity extends AppCompatActivity {

    AppTheme appThemeHelper;

    @Override
    protected void onCreate(Bundle saved) {
        super.onCreate(saved);
        setTheme();
        phoneBars();
    }
    
    public void setTheme(){
        appThemeHelper = new AppTheme(this);      
        setTheme(appThemeHelper.getTheme());
    }
    
    public void phoneBars(){
        EdgeToEdge.enable(this);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }    
}
