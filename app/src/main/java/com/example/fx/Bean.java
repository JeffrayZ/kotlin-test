package com.example.fx;

public class Bean <T extends String>{
    T data;
    public Bean(T t){
        this.data = t;
    }
}
