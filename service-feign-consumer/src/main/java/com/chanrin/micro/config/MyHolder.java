package com.chanrin.micro.config;

public class MyHolder {
    private static ThreadLocal<String> name=new ThreadLocal<>();

    public  static void setName(String names){
        name.set(names);
    }

    public  static String getName(){
        return name.get();
    }


}
