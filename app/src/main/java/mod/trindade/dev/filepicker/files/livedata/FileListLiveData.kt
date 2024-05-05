package mod.trindade.dev.filepicker.files.livedata

import android.os.AsyncTask
import android.util.Log
import mod.trindade.dev.filepicker.files.extensions.newDirectoryStream
import mod.trindade.dev.filepicker.files.models.FileModel
import mod.trindade.dev.filepicker.files.models.loadFileModel
import mod.trindade.dev.filepicker.files.utils.CloseableLiveData
import mod.trindade.dev.filepicker.files.utils.DirectoryObserver
import mod.trindade.dev.filepicker.files.utils.Failure
import mod.trindade.dev.filepicker.files.utils.Loading
import mod.trindade.dev.filepicker.files.utils.Stateful
import mod.trindade.dev.filepicker.files.utils.Success
import java.io.IOException
import java.nio.file.DirectoryIteratorException
import java.nio.file.Path
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

class FileListLiveData(private val path: Path) : CloseableLiveData<Stateful<List<FileModel>>>() {
    private var future: Future<Unit>? = null

    private val observer: DirectoryObserver

    @Volatile
    private var isChangedWhileInactive = false

    init {
        loadValue()
        observer = DirectoryObserver(path) { onChangeObserved() }

    }

    fun loadValue() {
        future?.cancel(true)
        value = Loading(value?.value)
        future = (AsyncTask.THREAD_POOL_EXECUTOR as ExecutorService).submit<Unit> {
            val value = try {
                path.newDirectoryStream().use { directoryStream ->
                    val fileList = mutableListOf<FileModel>()
                    for (path in directoryStream) {
                        try {
                            fileList.add(path.loadFileModel())
                        } catch (e: DirectoryIteratorException) {
                            e.printStackTrace()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                    Success(fileList as List<FileModel>)
                }
            } catch (e: Exception) {
                Failure(value, e)

            }
            postValue(value as Stateful<List<FileModel>>?)
        }
    }

    private fun onChangeObserved() {
        if (hasActiveObservers()) {
            loadValue()
        } else {
            isChangedWhileInactive = true
        }
    }

    override fun onActive() {
        if (isChangedWhileInactive) {
            loadValue()
            isChangedWhileInactive = false
        }
    }

    override fun close() {
        observer.close()
        future?.cancel(true)
    }
}