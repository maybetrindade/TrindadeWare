package mod.trindade.dev.example;

import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import com.trindade.preferences.databinding.ActivityMainPrefs;

import mod.trindade.dev.theme.ThemedActivity; 

public class MainActivity extends ThemedActivity {

    private ActivityMainPrefs binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPrefs.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.cardSimplePreferences.setOnClickListener(view -> {
            startActivity(new Intent(this, PreferencesActivity.class));
        });
    }
}