package com.poonam.dua.widgets.btn


import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
 import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

abstract class BaseButton : AppCompatButton {
    protected var mContext: Context
    protected var mAttrs: AttributeSet?
    protected var mDefStyleAttr: Int? = 0

    constructor(context: Context) : super(context) {
        mContext = context
        mAttrs = null
        this.initButton()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        mAttrs = attrs
        this.initButton()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        mAttrs = attrs
        mDefStyleAttr = defStyleAttr
        this.initButton()
    }

    protected abstract fun initButton()
    protected fun setButtonBackground(drawable: Drawable) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.background = drawable
        } else {
            this.setBackgroundDrawable(drawable)
        }

    }

}