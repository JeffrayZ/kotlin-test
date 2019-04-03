package com.example.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 在 Kotlin 中被继承类必须被 open 关键字修饰
 * */
open class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}