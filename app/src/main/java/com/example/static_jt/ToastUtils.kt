package com.example.static_jt

import android.widget.Toast

object ToastUtils {
    var sToast : Toast? = null

    fun show() {
        sToast!!.show()
    }
}