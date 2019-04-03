package com.example

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * 构造方法这么写
 * */
class MyView : View{
    constructor(context : Context) : this(context, null)

    constructor(context : Context, attrs : AttributeSet?) : this(context, attrs, 0)

    constructor(context : Context, attrs : AttributeSet?, defStyleAttr : Int) : super(context, attrs, defStyleAttr)
}