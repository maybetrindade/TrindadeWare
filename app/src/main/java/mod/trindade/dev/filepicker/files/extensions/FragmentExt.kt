package mod.trindade.dev.filepicker.files.extensions

import androidx.annotation.PluralsRes
import androidx.fragment.app.Fragment
import mod.trindade.dev.filepicker.files.filepicker.style.FilePickerStyle

fun Fragment.getQuantityString(@PluralsRes id: Int, quantity: Int): String =
    requireContext().getQuantityString(id, quantity)

fun Fragment.getQuantityString(
    @PluralsRes id: Int,
    quantity: Int,
    vararg formatArgs: Any?
): String = requireContext().getQuantityString(id, quantity, *formatArgs)


fun Fragment.initializeTheme(filePickerStyle: FilePickerStyle){
    filePickerStyle.appTheme?.let {
        requireActivity().setTheme(it)
    }
}