package ru.jaguardesign.testnav.EClassM;

import dagger.Module;
import dagger.Provides;

/**
 * Created by x on 23.01.2017.
 */
@Module
public class NetworkUtils {


        @Provides
        NetworkUtils provideNetworkUtils() {
        return new NetworkUtils();
        }


}
