package mod.trindade.dev.filepicker.files.utils

import androidx.lifecycle.LiveData
import java.io.Closeable

abstract class CloseableLiveData<T> : LiveData<T>, Closeable {

    constructor()

    abstract override fun close()
}