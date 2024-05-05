package mod.trindade.dev.filepicker.files.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.trindade.ware.R
import mod.trindade.dev.filepicker.files.extensions.getColorByAttr
import mod.trindade.dev.filepicker.files.extensions.shortAnimTime
import mod.trindade.dev.filepicker.files.filepicker.style.FileItemStyle
import mod.trindade.dev.filepicker.files.utils.asColor
import mod.trindade.dev.filepicker.files.utils.withModulatedAlpha

object CheckableItemBackground {

    @SuppressLint("RestrictedApi")
    fun create(context: Context, fileItemStyle: FileItemStyle): Drawable {
        val typedValue = TypedValue()
        val resolved = context.theme.resolveAttribute(
            com.google.android.material.R.attr.colorOnSecondary, typedValue, true
        )
        val colorOnSecondary = if (resolved) typedValue.data else 0


        return AnimatedStateListDrawableCompat().apply {
            val shortAnimTime = context.shortAnimTime
            setEnterFadeDuration(shortAnimTime)
            setExitFadeDuration(shortAnimTime)
            val primaryColor =
                context.getColorByAttr(com.google.android.material.R.attr.colorPrimaryContainer)
            val checkedColor = primaryColor.asColor().withModulatedAlpha(fileItemStyle.fileSelectedOpacity).value

            val backgroundSelected =
                DrawableCompat.wrap(ContextCompat.getDrawable(context, R.drawable.bg_card_normal)!!)
            val background =
                DrawableCompat.wrap(ContextCompat.getDrawable(context, R.drawable.bg_card_normal)!!)

            DrawableCompat.setTint(backgroundSelected, checkedColor)
            DrawableCompat.setTint(background, colorOnSecondary)

            addState(intArrayOf(android.R.attr.state_checked), backgroundSelected)
            addState(intArrayOf(), background)

        }
    }

}

