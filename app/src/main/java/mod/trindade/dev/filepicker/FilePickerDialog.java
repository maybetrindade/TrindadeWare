package mod.trindade.dev.filepicker; 

import android.os.Bundle; 
import com.sketchware.remod.R; 

public class FilePickerDialog extends com.github.angads25.filepicker.view.FilePickerDialog {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);   
      getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
   }
}