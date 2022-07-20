package com.poonam.dua.widgets.profile

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.poonam.dua.R


class InfoView : RelativeLayout {
    var contextV: Context?=null
    var attrs: AttributeSet? = null
    var styleAttr = 0
    var textQuestion: TextView? = null
    var textAnswer: TextView? = null


    //SwitchMaterial switchState;
    constructor(context: Context) : super(context) {
        this.contextV = context
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.contextV = context
        this.attrs = attrs
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.contextV = context
        this.attrs = attrs
        styleAttr = defStyleAttr
        initView()
    }

    private fun initView() {
        inflate(context, R.layout.item_info, this)
        val arr = context.obtainStyledAttributes(
            attrs, R.styleable.SettingsView,
            styleAttr, 0
        )
        textQuestion = findViewById(R.id.question)
        textAnswer = findViewById(R.id.answer)
        //textInfo = findViewById(R.id.text_info);
        // switchState = findViewById(R.id.switch_state);

        setAttrsToView(arr)
        arr.recycle()
    }

    fun setAttrsToView(arr: TypedArray) {
        textQuestion!!.text = arr.getText(R.styleable.InfoView_info_question)
        textAnswer!!.text = arr.getText(R.styleable.InfoView_info_answer)

    }

}