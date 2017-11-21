package ru.jaguardesign.testnav.EInterface;

/**
 * Created by x on 23.01.2017.
 */

import dagger.Subcomponent;
import ru.jaguardesign.testnav.MainActivity;
import ru.jaguardesign.testnav.EClassM.TempM;
//import ru.jaguardesign.testnav.Esco.UserScoupe;


@Subcomponent( modules = {TempM.class})
//@UserScoupe
public interface TesComponent {
   // void  inject ();
    //String mys;
   void inject(MainActivity mainActivity);
}
