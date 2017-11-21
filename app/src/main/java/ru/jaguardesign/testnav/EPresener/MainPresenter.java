package ru.jaguardesign.testnav.EPresener;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;

import ru.jaguardesign.testnav.AsyncResponse;
import ru.jaguardesign.testnav.EClass.GetFood;
import ru.jaguardesign.testnav.EIPresenter.IMainPresenter;

/**
 * Created by x on 13.08.2017.
 */
public class MainPresenter implements IMainPresenter { private AsyncResponse ac;
    private GetFood getFood;
    private Context ctx;
    private boolean checki=false;
    public MainPresenter(AsyncResponse a,Context c)
    { ac=a;
        ctx=c;
    }
    private boolean CheckI ()
    {
        ConnectivityManager conMgr = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;
    }
    @Override
    public void Load() {
        if (CheckI())
        {
           GetFood getf=new GetFood();
            getf.getf(this, ctx,"get_table_food");
          //  getf.getf(ctx,"get_e_food");
          //  getf.getf(ctx,"get_cook");
        }
    }

    @Override
    public void Load1() {
        if (CheckI()) {
            GetFood getf = new GetFood();GetFood get = new GetFood();
            //getf.getf(ctx,"get_table_food");
            getf.getf(this,ctx, "get_e_food");
            get.getf(this,ctx, "get_cook");
        }
    }

    @Override
    public void Response() {
        ac.processFinish(new JSONArray());
    }
}
