package mod.trindade.dev.filepicker.files.filelist

import android.os.Parcel
import android.os.Parcelable
import mod.trindade.dev.filepicker.files.extensions.readParcelableListCompat
import mod.trindade.dev.filepicker.files.extensions.writeParcelableListCompat
import mod.trindade.dev.filepicker.files.models.FileModel
import mod.trindade.dev.filepicker.files.utils.LinkedMapSet

class FileItemSet() : LinkedMapSet<String, FileModel>(FileModel::path), Parcelable {
    constructor(parcel: Parcel) : this() {
        addAll(parcel.readParcelableListCompat())
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelableListCompat(toList(), flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<FileItemSet> {
        override fun createFromParcel(parcel: Parcel): FileItemSet = FileItemSet(parcel)

        override fun newArray(size: Int): Array<FileItemSet?> = arrayOfNulls(size)
    }
}

fun fileItemSetOf(vararg files: FileModel) = FileItemSet().apply { addAll(files) }