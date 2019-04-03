package com.example.fx

/**
 * 泛型
 * */
class Bean1 <T : Comparable<String>>(t : T){
    var data = t;
}