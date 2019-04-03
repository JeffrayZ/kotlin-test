package com.example.kotlindemo

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.example.base.BaseActivity
import com.example.interface_jk.Callback

class Main2Activity : BaseActivity() {
    var name = "大哥好";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        /**
         * 匿名内部类
         * */
        object : Callback{
            override fun onFail() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSuccess() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        add(3)

        /**
         * 方法支持默认参数
         * */
        toast(text = "弹个吐司")
        toast(this, "弹个吐司")
        toast(this, "弹个吐司", Toast.LENGTH_LONG)


    }

    fun add(vararg array: Int) : Int {
        var count = 2
        array.forEach {
            count += it
            println("循环里面"+count)
        }
        println("循环外面"+count)
        return count
    }

    inner class MyTask{
        var name = null;
        var value = null;

        /**
         * 内部类访问外部类同名变量
         * */
        fun show(){
            println(name + "---" + this@Main2Activity.name)
        }
    }

    /**
     * !! 判断是否为空，空报异常
     *
     * ? 判断是否为空，空不报错
     * */

    fun toast(context : Context = this, text : String, time : Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, text, time).show()
    }


}
