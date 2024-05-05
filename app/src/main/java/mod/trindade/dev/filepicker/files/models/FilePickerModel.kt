package mod.trindade.dev.filepicker.files.models

import android.os.Parcelable
import mod.trindade.dev.filepicker.files.filepicker.FilePickerCallbacks
import kotlinx.parcelize.Parcelize

/**
 * Represents the configuration and callbacks for a file picker.
 *
 * @param pickOptions Options for file picking.
 */
@Parcelize
data class FilePickerModel(
    val pickOptions: PickOptions,
) : Parcelable
