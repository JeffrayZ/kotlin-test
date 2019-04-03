package com.example.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.provider.Contacts
import com.example.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.util.concurrent.ThreadPoolExecutor

/**
 * 静态常量
 * */
const val text = "六的不行";
/**
 * 继承要这么写
 * */
class MainActivity : BaseActivity() {

    /**
     * 重载
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_go.setOnClickListener {
            /**
                对象:
                Java 的写法
                    MainActivity.this
                Kotlin 的写法
                    this@MainActivity

                类:
                Java 的写法
                    MainActivity.class
                Kotlin 的写法
                    MainActivity::class.java

                 变量：
                 var intent

                 常量：
                 val text = "大家好";
             * */
            var intent = Intent(this@MainActivity,Main2Activity::class.java);
            startActivity(intent)
        }

        test1();
        test2("888");
        var i = test3(666);
        println(i);

        var pp = "大家好";
        var ppt = 5656;
        /**
         * 判断类型
         * */
        if(pp is String){
            println("pp是字符串");
        }
        if(ppt is Int){
            println("ppt是整型");
        }

        /**
         * 转换符
         * */
        var number = 100
        println("商品数量有${number}");
        println("商品数量有$number");


        /**
         * Kotlin 对字符串比较的写法进行优化了，其他类型对象对比还是要用 equals 方法
         * */
        var s1 = "text"
        var s2 = "text"
        if (s1 == s2) {
            println("相等");
        }

        /**
         * 数组
         * */
        val array1 = intArrayOf(1, 2, 3)
        val array2 = floatArrayOf(1f, 2f, 3f)
        val array3 = arrayListOf("1", "2", "3")

        /**
         * 循环
         * */
        var array = arrayListOf("1", "2", "3")
        for (i in array.indices) {
            println(array[i])
        }

        /**
         * 下标循环
         * */
        array = arrayListOf("5", "7", "9")
        for (i in IntRange(0, array.size - 1)) {
            println("下标:::" + i + "值:::" + array[i])
        }

        /**
         * 输出内容
         * */
        array = arrayListOf("4", "5", "6")
        for (text in array) {
            println(text)
        }

        /**
         * switch case 判断
         * */
        var count = 1
        when (count) {
            0 -> {
                println(count)
            }
            in 1..2 -> {
                println(count)
            }
            else -> {
                println(count)
            }
        }


        /**
         * 测试协程
         * */
//        test4()

//        test5()

//        test6()

        test7()
    }

    fun test1(){
        println("这是一个返回空的方法");
    }

    fun test2(log : String){
        println("这是一个返回空的方法,参数是：" + log);
    }

    fun test3(log : Int) : Int{
        println("这是一个返回int的方法,参数是：" + log);
        return 777;
    }

    /**
     * runBlocking 运行在主线程，过程中 App 出现过无响应提示，由此可见 runBlocking 和它的名称一样，真的会阻塞当前的线程，
     * 只有等 runBlocking 里面的代码执行完了才会执行 runBlocking 外面的代码
     * */
    fun test4(){
        println("测试是否为主线程" + (Thread.currentThread() == Looper.getMainLooper().thread))
        println("测试开始")
        runBlocking {
            println("测试是否为主线程" + (Thread.currentThread() == Looper.getMainLooper().thread))
            println("测试延迟开始")
            delay(20000) // 因为 Activity 最长响应时间为 15 秒
            println("测试延迟结束")
        }
        println("测试结束")
    }

    /**
     *  launch 没有执行顺序这个概念
     * */
    fun test5(){
        println("测试是否为主线程" + (Thread.currentThread() == Looper.getMainLooper().thread))
        println("测试开始")
        GlobalScope.launch {
            println("测试是否为主线程" + (Thread.currentThread() == Looper.getMainLooper().thread))
            println("测试延迟开始")
            delay(20000)
            println("测试延迟结束")
        }
        println("测试结束")
    }

    fun test6(){
        println("测试是否为主线程" + (Thread.currentThread() == Looper.getMainLooper().thread))
        println("测试开始")
        GlobalScope.async {
            println("测试是否为主线程" + (Thread.currentThread() == Looper.getMainLooper().thread))
            println("测试延迟开始")
            delay(20000)
            println("测试延迟结束")
        }
        println("测试结束")
    }

    /**
     * async 和 launch 还是有区别的，async 可以有返回值，通过它的 await 方法进行获取，需要注意的是这个方法只能在协程的操作符中才能调用
     * */
    fun test7(){
        println("测试是否为主线程" + (Thread.currentThread() == Looper.getMainLooper().thread))

        println("测试开始")
        val async = GlobalScope.async {
            println("测试是否为主线程" + (Thread.currentThread() == Looper.getMainLooper().thread))
            println("测试延迟开始")
            delay(20000)
            println("测试延迟结束")
            return@async "666666"
        }
        println("测试结束")

        runBlocking {
            println("测试返回值：" + async.await())
        }
    }
}
