package mod.trindade.dev.filepicker.files.utils

import mod.trindade.dev.filepicker.files.provider.AppProvider

object SystemServices {
     val appClassLoader = AppProvider::class.java.classLoader
}