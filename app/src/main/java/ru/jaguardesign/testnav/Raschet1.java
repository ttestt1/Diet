package ru.jaguardesign.testnav;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by x on 08.04.2016.
 */
public class Raschet1 {
    public static Context ctx;
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
    Raschet1(int le1, int tal1, int ro1, int m, int d, float w, Context c)
    {
        ctx=c;
        weight=w;
       // sushka=s;
        days=d;
        male=m;
       // days_t=dayst;
       // tel_=tel;
        bel_koff=0;
        kkal_koff=0;
        ro=ro1;
        tal=tal1;
        le=le1;
sushka=1;
        Log.d("m__x", String.valueOf(days_t));
        Log.d("m__x", String.valueOf(tel_));
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
    public  ArrayList<Result1> Run ()
    {
N();
        ArrayList res=new ArrayList<Result1>();
         float total_kkal_day=35*weight;
        float  ib_bel_day=0;
        float  ib_gir_day=0;
        float  ib_ugl_day=0;
        float total_bel_day=0.0018f*weight;
        float total_gir_day=0.0002f*weight;
        float temp_kkal=0;
        float ug_kkal=0;
        DB db = new DB(ctx);
        db.open();int i=0;
        N();
//if (male==0) if (sushka==1) {total_bel_day=0.0015f*weight;total_kkal_day=27*weight;} else {total_bel_day=0.0015f*weight;total_kkal_day=29*weight;}
        //      else if (sushka==1) {total_bel_day=0.0018f*weight;total_kkal_day=30f*weight;} else {total_bel_day=0.0018f*weight;total_kkal_day=35*weight;}
//        total_kkal_day=total_kkal_day+kkal_koff;
        //      total_bel_day=total_bel_day+bel_koff;
        if (male==0) if (sushka==1) {total_bel_day=(0.0012f+bel_koff)*weight;total_kkal_day=(25+kkal_koff)*weight;} else {total_bel_day=(0.0012f+bel_koff)*weight;total_kkal_day=(29+kkal_koff)*weight;}
        else if (sushka==1) {total_bel_day=(0.0014f+bel_koff)*weight;total_kkal_day=(30f+kkal_koff)*weight;} else {total_bel_day=(0.0014f+bel_koff)*weight;total_kkal_day=(35+kkal_koff)*weight;}
        total_kkal_day=(float)p-390;
        Log.d("m__", String.valueOf(kkal_koff));
        Log.d("m__", String.valueOf(bel_koff));
        Log.d("m__x", String.valueOf(total_kkal_day));
        Log.d("m__x", String.valueOf(total_bel_day));
        //Log.d("m__", "z"+String.valueOf(total_kkal_day));
        while (i<days) {
            Cursor cur_bel=  db.getBel();
            Cursor cur_gir =db.getGir();
            Cursor cur_ugl=db.getUgl();
            // Cursor cur_kkal=db.getKkal();
            Cursor cur_kl=db.getKl();
            cur_bel.moveToFirst();
            cur_gir.moveToFirst();
            cur_ugl.moveToFirst();
            cur_kl.moveToFirst();
            //   cur_kkal.moveToFirst();
            //     Result re=new Result();
            ib_bel_day=(100*total_bel_day/cur_bel.getFloat(cur_bel.getColumnIndex(db.BELKI))); //сколько в кг закупить источника белка на день
            temp_kkal=(10*ib_bel_day*cur_bel.getFloat(cur_bel.getColumnIndex(db.KAL)));//сколько ккал в источниках белка
            Log.d("m__", cur_bel.getString(cur_bel.getColumnIndex(db.TITLE)));
            Log.d("m__", String.valueOf(cur_bel.getString(cur_bel.getColumnIndex(db.KAL))));
            Log.d("m__", String.valueOf(ib_bel_day));
            Log.d("m__", String.valueOf(temp_kkal));
            ib_gir_day=(100*total_gir_day/cur_gir.getFloat(cur_bel.getColumnIndex(db.GIRY))); //сколько в кг закупить источника жира на день
            Log.d("m__", cur_gir.getString(cur_gir.getColumnIndex(db.TITLE)));
            Log.d("m__", String.valueOf(ib_gir_day));
            temp_kkal=temp_kkal+(10*ib_gir_day*cur_bel.getFloat(cur_gir.getColumnIndex(db.KAL)));//сколько ккал в источниках жира+ белка
            Log.d("m__", String.valueOf(temp_kkal));
            if (temp_kkal<total_kkal_day)
            {
                ug_kkal=total_kkal_day-temp_kkal;
                Log.d("m__", String.valueOf(ug_kkal));
                ib_ugl_day=0.1f*ug_kkal/cur_ugl.getFloat(cur_ugl.getColumnIndex(db.KAL));   //кг углеводов
                Log.d("m__", cur_ugl.getString(cur_ugl.getColumnIndex(db.TITLE)));
                Log.d("m__", String.valueOf(ib_ugl_day));
            }


            Result res_temp=new Result(Integer.toString(i+1)+" "+ctx.getResources().getString(R.string.day)+" - "+cur_bel.getString(cur_bel.getColumnIndex(db.TITLE)),ib_bel_day,cur_bel.getFloat(cur_bel.getColumnIndex(db.KAL)),
                    cur_bel.getFloat(cur_bel.getColumnIndex(db.UGLEVODY)),cur_bel.getFloat(cur_bel.getColumnIndex(db.BELKI)),cur_bel.getFloat(cur_bel.getColumnIndex(db.GIRY))       );
            res_temp.id=cur_bel.getLong(cur_bel.getColumnIndex(db.UID));
            res.add(res_temp);
            res_temp=new Result(Integer.toString(i+1)+" "+ctx.getResources().getString(R.string.day)+" - "+cur_gir.getString(cur_gir.getColumnIndex(db.TITLE)),ib_gir_day,cur_gir.getFloat(cur_gir.getColumnIndex(db.KAL)),
                    cur_gir.getFloat(cur_gir.getColumnIndex(db.UGLEVODY)),cur_gir.getFloat(cur_gir.getColumnIndex(db.BELKI)),cur_gir.getFloat(cur_gir.getColumnIndex(db.GIRY))       );
            res_temp.id=cur_gir.getLong(cur_gir.getColumnIndex(db.UID));
            res.add(res_temp);
            if (ib_ugl_day!=0)
            {
                res_temp=new Result(Integer.toString(i+1)+" "+ctx.getResources().getString(R.string.day)+" - "+cur_ugl.getString(cur_ugl.getColumnIndex(db.TITLE)),ib_ugl_day,cur_ugl.getFloat(cur_ugl.getColumnIndex(db.KAL)),
                        cur_ugl.getFloat(cur_ugl.getColumnIndex(db.UGLEVODY)),cur_ugl.getFloat(cur_ugl.getColumnIndex(db.BELKI)),cur_ugl.getFloat(cur_ugl.getColumnIndex(db.GIRY))       );
                res_temp.id=cur_ugl.getLong(cur_ugl.getColumnIndex(db.UID));
                res.add(res_temp);
            }
            Random r = new Random();

            float ib_kl_day = (r.nextInt(1500))/10+100;
            ib_kl_day=ib_kl_day/1000;
            res_temp=new Result(Integer.toString(i+1)+" "+ctx.getResources().getString(R.string.day)+" - "+cur_kl.getString(cur_kl.getColumnIndex(db.TITLE)),ib_kl_day,cur_kl.getFloat(cur_kl.getColumnIndex(db.KAL)),
                    cur_kl.getFloat(cur_kl.getColumnIndex(db.UGLEVODY)),cur_kl.getFloat(cur_kl.getColumnIndex(db.BELKI)),cur_kl.getFloat(cur_kl.getColumnIndex(db.GIRY))       );
            res_temp.id=cur_kl.getLong(cur_kl.getColumnIndex(db.UID));
            res.add(res_temp);


            cur_kl=db.getKl(); cur_kl.moveToFirst();            ib_kl_day = (r.nextInt(1000))/10+150;
            ib_kl_day=ib_kl_day/1000;
            res_temp=new Result(Integer.toString(i+1)+" "+ctx.getResources().getString(R.string.day)+" - "+cur_kl.getString(cur_kl.getColumnIndex(db.TITLE)),ib_kl_day,cur_kl.getFloat(cur_kl.getColumnIndex(db.KAL)),
                    cur_kl.getFloat(cur_kl.getColumnIndex(db.UGLEVODY)),cur_kl.getFloat(cur_kl.getColumnIndex(db.BELKI)),cur_kl.getFloat(cur_kl.getColumnIndex(db.GIRY))       );
            res_temp.id=cur_kl.getLong(cur_kl.getColumnIndex(db.UID));
            res.add(res_temp);


            i++;} db.close();
        return res;
        //33 ккал на кг
        //2 г белка на кг
        //Integer.toString(i+1)+" "+ctx.getResources().getString(R.string.day)+" - "+
        //  ctx.getResources().getString(R.string.wa)

    }
    private void Na()
    {
        if (days_t==0) {
            bel_koff = bel_koff - 0.0001f;
            kkal_koff=kkal_koff - 2f;
        }
        if (days_t==1) {
            //bel_koff = bel_koff - 0.0001f;
            kkal_koff=kkal_koff + 1f;
        }
        if (tel_==0)
        {
            kkal_koff=kkal_koff + 1f;
        }
        else if (tel_==1)
        {
            kkal_koff=kkal_koff + 0f;
        }
        else kkal_koff=kkal_koff - 1f;
    }
    //эпизодические занятия или минимум физической активностиБУМ * 1.2 легкие тренировки (1-3 раза в неделю)БУМ * 1.275 средние тренировки (3-5 раз в неделю)БУМ * 1.55 серьезные тренировки (6-7 раз в неделю)БУМ * 1.725 тяжелая физическая работа
    //или тренировки 2 раза в деньБУМ * 1.9 - See more at: http://ggym.ru/calc/cl.php#sthash.2XlE7GjZ.dpuf
}
