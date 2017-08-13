package ru.jaguardesign.testnav.UI;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.Result;

/**
 * Created by x on 26.05.2017.
 */
public class Raschet_M { public static BGU_M bgu_m;
    public static float weight;
    public static int sushka;
    public static int days;
    public static int male;
    public static int days_t;//кол во дней тренировок 0 - 3, 1 -5
    public static int tel_;//телосложение 0- худой, 1 - нормальный, 2- толстый
    private static float bel_koff;//коффициент по белкам
    private static float kkal_koff;//коффициент по кка
    private static int ro ;//коффициент по кка
    private static int tal ;//коффициент по кка
    private static int le ;//коффициент по кка
    private static double prog;
    private static double p;

    public Raschet_M(int le1, int tal1, int ro1, int m, float w)
    {
        weight=w;
        // sushka=s;
     //   days=d;
        male=m;
        // days_t=dayst;
        // tel_=tel;
        bel_koff=0;
        kkal_koff=0;
        ro=ro1;
        tal=tal1;
        le=le1;
        sushka=1;
    }
    private void N()
    {

        //prog=4.15*tal;
        if (male==1)
            prog=(4.15 * tal - 0.082 * weight - 98.42 ) / weight;//- See more at: http://ggym.ru/calc/cl.php#sthash.2XlE7GjZ.dpuf
        else
            prog=(4.15 * tal - 0.082 * weight - 76.76 ) / weight;
        //prog=prog
        double v=weight*(100-prog)/100;
        p=370+21.6*v;
        Log.d ("m__",String.valueOf(p));
        Log.d ("m__",String.valueOf(prog));
    }
    private void Nn()
    {

        //prog=4.15*tal;
        if (male==1)
            p= (9.99 * weight) + (6.25*ro)-(4.92*le) + 5;// prog=(4.15 * tal - 0.082 * weight - 98.42 ) / weight;//- See more at: http://ggym.ru/calc/cl.php#sthash.2XlE7GjZ.dpuf
        else
            //  prog=(4.15 * tal - 0.082 * weight - 76.76 ) / weight;
            p=(9.99 * weight) + (6.25*ro)-(4.92*le) -161;
        //prog=prog
        //double v=weight*(100-prog)/100;
        //p=370+21.6*v;
        Log.d ("m__",String.valueOf(p));
        Log.d ("m__",String.valueOf(prog));
    }
    public BGU_M Run ()
    { bgu_m=new BGU_M();N();
        ArrayList res=new ArrayList<Result>();
        float total_kkal_day=35*weight;
        float  ib_bel_day=0;
        float  ib_gir_day=0;
        float  ib_ugl_day=0;
        float total_bel_day=0.0018f*weight; float total_ug_day=0;
        float total_gir_day=0.001f*weight;
        float temp_kkal=0;
        float ug_kkal=0;

        N();
        //DB db = new DB(ctx);
        //db.open();
        bgu_m.vo=(int)Math.round(0.0375*weight);
    //    if (male==0) if (sushka==1) {total_bel_day=0.0015f*weight;total_kkal_day=27*weight;} else {total_bel_day=0.0015f*weight;total_kkal_day=29*weight;}
//        else if (sushka==1) {total_bel_day=0.0018f*weight;total_kkal_day=30f*weight;} else {total_bel_day=0.0018f*weight;total_kkal_day=35*weight;}
        if (male==0) if (sushka==1) {total_bel_day=(0.0012f+bel_koff)*weight;total_kkal_day=(25+kkal_koff)*weight;} else {total_bel_day=(0.0012f+bel_koff)*weight;total_kkal_day=(29+kkal_koff)*weight;}
        else if (sushka==1) {total_bel_day=(0.0014f+bel_koff)*weight;total_kkal_day=(30f+kkal_koff)*weight;} else {total_bel_day=(0.0014f+bel_koff)*weight;total_kkal_day=(35+kkal_koff)*weight;}
        total_kkal_day=(float)p-390;

        total_ug_day=(total_kkal_day-(total_bel_day*4000+total_gir_day*9000))/4000;
        Log.d("m__",String.valueOf(total_ug_day));bgu_m.kkal=Math.round(total_kkal_day);
        bgu_m.belki=Math.round(total_bel_day*1000);bgu_m.gir=Math.round(total_gir_day*1000);bgu_m.uglevodi=Math.round(total_ug_day*1000);
       // tot
        return bgu_m;
    }
}
