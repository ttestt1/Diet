package ru.jaguardesign.testnav.UI;

import android.content.Context;
import android.database.Cursor;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.R;

/**
 * Created by x on 06.02.2017.
 */
public class Calc {

    private Context ctx;
    private int gr;
    private String tit;
    public  Calc(Context c,
                 String t   , int g)
    {
        this.ctx=c;
        this.gr=g;
        this.tit=t;

    }
    public String Raschet()
    {
        DB db=new DB(ctx);
        db.open();
        Cursor c=db.Searchfoodt(tit);
        //db.close();
        String s="";
        if (c!=null)
            if ( c.moveToFirst())
            {
                int be=c.getInt(c.getColumnIndex(DB.BELKI))*gr/100;
                int gi=c.getInt(c.getColumnIndex(DB.GIRY))*gr/100;
                int ug=c.getInt(c.getColumnIndex(DB.UGLEVODY))*gr/100;
                int ka=c.getInt(c.getColumnIndex(DB.KAL))*gr/100;
                s=ctx.getString(R.string.calc_a)+"\n"
                        +ctx.getString(R.string.calc_b)+String.valueOf(be)
                        +"\n"+ctx.getString(R.string.calc_g)+String.valueOf(gi)
                +"\n"+ctx.getString(R.string.calc_u)+String.valueOf(ug)
                +"\n"+ctx.getString(R.string.calc_k)+String.valueOf(ka);
            }

        return s;
    }
}
