package mod.trindade.dev.filepicker.files.filelist

import mod.trindade.dev.filepicker.files.models.FileModel

interface FileListener {

    fun clearSelectedFiles()

    fun selectFile(file: FileModel, selected: Boolean)

    fun selectFiles(files: FileItemSet, selected: Boolean)

    fun openFile(file: FileModel)

}