package ru.jaguardesign.testnav.EPresener;

import android.content.Context;
import android.database.Cursor;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.EIPresenter.IFMainP;

/**
 * Created by x on 15.08.2017.
 */
public class MainFPre implements IFMainP{ private DB db; private Cursor cursor;
    private Context ctx;
    public MainFPre(Context c)
    {
        ctx=c;
    }

    @Override
    public Cursor GetLis() {
        db = new DB(ctx);
        db.open();
        cursor = db.getAllDataFood();
        db.close(); return cursor;

    }

    @Override
    public void GetList() {

    }
}
