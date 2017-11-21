package ru.jaguardesign.testnav.EPresener;

import android.content.Context;
import android.widget.Toast;

import ru.jaguardesign.testnav.EIPresenter.IFEditP;
import ru.jaguardesign.testnav.R;

/**
 * Created by x on 15.08.2017.
 */
public class EditFPre implements IFEditP { private int w; private int d; private int le;private int tal;private int ro;private Context ctx;
    public EditFPre(Context c)
    {
        ctx=c;
    }
    @Override
    public boolean Check(int w1, int d1, int tal1, int ro1, int le1) {
        w=w1;d=d1;tal=tal1;ro=ro1;le=le1;
        if (Check1(le)) if (CheckTal(tal)) if (CheckRost(ro)) if(CheckDay(d)) if (CheckWeight(w)) return true;
        return false;
    }

    @Override
    public boolean CheckWeight(int w) {
        //noinspection RedundantIfStatement
        if (w < 40 || w > 120) { return false;
            } return true;
        //return false;
    }

    @Override
    public boolean Check1(int le) { if (le < 18 || le > 120)
        return false; else return true;
    }

    @Override
    public boolean CheckDay(int d) {if (d < 1 || d > 5)
        return false; else return true;
    }

    @Override
    public boolean CheckTal(int ta) { if (ta < 40 || ta > 155)
        return false; else return true;
    }

    @Override
    public boolean CheckRost(int ro) {if (ro < 140 || ro > 210)
        return false; else return  true;
    }
}
