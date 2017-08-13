package ru.jaguardesign.testnav;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by x on 20.09.2016.
 */
public class Tohtml1 {
    private Cursor cu;
    private DB db;
    private Context ctx;
    public Tohtml1(Context c, Cursor cursor, DB d) {
ctx=c;
        cu=cursor;
        db=d;
    }
    public String thm() {
        String te = "<table border=1>";
        cu.moveToFirst();
        do {
        te = te + "<tr><td>"+cu.getString(cu.getColumnIndex(db.TITLE7))+ctx.getString(R.string.riw)+" </td><td>"+cu.getString(cu.getColumnIndex(db.O27))+" </td></tr>";
    } while (cu.moveToNext());
        te=te+"</table>";
        return te;
    }
    public String te() {
        String te = ctx.getString(R.string.d_prom)+"\n";
        if (cu!=null) {
            cu.moveToFirst();
            do {
                te = te + cu.getString(cu.getColumnIndex(db.TITLE7)) + ", " + ctx.getString(R.string.riw) + " " + cu.getString(cu.getColumnIndex(db.O27)) + "; \n";
            } while (cu.moveToNext());
        }
        te=te+"";
        return te;
    }
}
