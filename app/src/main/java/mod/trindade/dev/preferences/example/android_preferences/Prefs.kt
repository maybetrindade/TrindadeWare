package mod.trindade.dev.preferences.android_preferences

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class Prefs : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var sharedPreferences: SharedPreferences
    
    //onCreate pattern  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }
    //This is optional, it's here because I was doing tests. 
    override fun onDestroy() {
        super.onDestroy()
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }
    
    //here you define the listeners and more, as if it were onCreate  
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.app_preferences, rootKey) // Correção do nome do arquivo XML
        val darkThemeSwitch: Preference? = findPreference("dark_theme")
        darkThemeSwitch?.setOnPreferenceChangeListener { _, newValue ->
            val isChecked = newValue as Boolean
            true
        }
    }
    
    //unused, example only! 
    private fun setThemePreference(isDarkMode: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("dark_mode", isDarkMode)
        editor.apply()
    }

    private fun getThemePreference(): Boolean {
        return sharedPreferences.getBoolean("dark_mode", false)
    } 
    
    //Example listener when  state for preference
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == "dark_mode") {
            val isDarkMode = sharedPreferences?.getBoolean("dark_mode", false) ?: false
            requireActivity().recreate()
        }
    } 
}