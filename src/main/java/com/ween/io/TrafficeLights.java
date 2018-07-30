package com.ween.io;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * Created by wen on 2018/3/23
 */
enum Signal{
    RED,GREEN,YELLOW
}
public class TrafficeLights {
    Signal color= Signal.RED;
    public  void change(){
        switch (color){
            case RED:
                color=Signal.GREEN;
                break;
            case YELLOW:
                color=Signal.RED;
                break;
            case GREEN:
                color=Signal.YELLOW;
                break;
        }
    }
}
