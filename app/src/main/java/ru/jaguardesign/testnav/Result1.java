package ru.jaguardesign.testnav;

/**
 * Created by x on 18.05.2016.
 */
public class Result1 {
    public String title;
    public float belk;
    public float giry;
    public float uglevody;
    public float kkal;
    public float ves;//в кг
    public Long id;

    Result1(Long i,String t, float v, float k, float u, float b, float g)
    {
        id=i;
title=t;
        ves=Math.round(v*1000);
        belk=b;
        giry=g;
        uglevody=u;
        kkal=k;
     //   Log.d("m__", String.valueOf(kkal));
    }
}
