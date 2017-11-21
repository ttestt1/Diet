package ru.jaguardesign.testnav.EInterface;

import javax.inject.Singleton;

import dagger.Component;
import ru.jaguardesign.testnav.EClassM.ApM;
import ru.jaguardesign.testnav.EClassM.NetworkUtils;
import ru.jaguardesign.testnav.EClassM.TempM;

/**
 * Created by x on 23.01.2017.
 */
@Component(modules = {ApM.class, NetworkUtils.class})
@Singleton
public interface AppComponent {
   // void inject(MainActivity mainActivity);
    //void inj (TesComponent tesComponent);
    TesComponent plusTesComponent(TempM tempM);
}
