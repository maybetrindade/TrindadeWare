package mod.trindade.dev.preferences.android_preferences

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

import com.trindade.ware.R
import mod.trindade.dev.preferences.android_preferences.Prefs
import mod.trindade.dev.theme.ThemedActivity; 

public class SettingsAct : ThemedActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_preference, Prefs())
            .commit()
    }
}