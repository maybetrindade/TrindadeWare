package mod.trindade.dev.filepicker; 

import android.os.Bundle; 
import com.sketchware.remod.R; 
import com.github.angads25.filepicker.view.FilePickerDialog;

public class TFilePickerDialog extends FilePickerDialog {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);   
      getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
   }
}