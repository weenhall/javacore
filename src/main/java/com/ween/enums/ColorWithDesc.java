package com.ween.enums;

/**
 * Created by wen on 2018/3/23
 */
public enum ColorWithDesc {
    RED("红色",1),
    GREEN("绿色",2),
    BLANK("白色",3),
    YELLOW("黄色",4);

    private String name;
    private int index;

    private ColorWithDesc(String name,int index){
        this.name=name;
        this.index=index;
    }
}
