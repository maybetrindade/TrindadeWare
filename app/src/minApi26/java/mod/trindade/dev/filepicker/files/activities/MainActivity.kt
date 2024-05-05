package mod.trindade.dev.filepicker.files.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.trindade.ware.R
import mod.trindade.dev.filepicker.files.filelist.FileItemSet
import mod.trindade.dev.filepicker.files.filelist.FileListener
import mod.trindade.dev.filepicker.files.filepicker.FilePickerCallbacks
import mod.trindade.dev.filepicker.files.fragments.FileListFragment
import mod.trindade.dev.filepicker.files.models.FileModel

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_filep)

        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
    }
}