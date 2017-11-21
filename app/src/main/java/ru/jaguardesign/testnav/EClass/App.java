package ru.jaguardesign.testnav.EClass;

import android.app.Application;

import ru.jaguardesign.testnav.EClassM.ApM;
import ru.jaguardesign.testnav.EClassM.TempM;
import ru.jaguardesign.testnav.EInterface.AppComponent;
import ru.jaguardesign.testnav.EInterface.DaggerAppComponent;
//import ru.jaguardesign.testnav.EInterface.DaggerAppComponent;
import ru.jaguardesign.testnav.EInterface.TesComponent;

//import ru.jaguardesign.nw1.ZInterface.DaggerTesComponent;
//import ru.jaguardesign.nw1.ZInterface.DaggerTesComponent;

/**
 * Created by x on 23.01.2017.
 */
public class App extends Application {
    private static AppComponent appc;
    public static AppComponent getComponent(){
        return appc;
    }
    private static TesComponent testc;
    public static TesComponent getTes() {
        // .tempM(new TempM("zz"))
        //.networkUtils(new NetworkUtils())
        return  appc.plusTesComponent(new TempM());
        //.build();}
    }
    @Override
    public void onCreate() {
        super.onCreate();
        appc=buildComponent();
    }
    protected AppComponent buildComponent()
    {
        return DaggerAppComponent.builder()
                .apM(new ApM(this))
               // .networkUtils(new NetworkUtils())
                .build();
    }
}
