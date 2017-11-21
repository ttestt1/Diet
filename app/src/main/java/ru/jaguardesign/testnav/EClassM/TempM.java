package ru.jaguardesign.testnav.EClassM;

import dagger.Module;
import dagger.Provides;

/**
 * Created by x on 23.01.2017.
 */
@Module
public class TempM {
    private String test;

//@Inject
    public TempM ()
    {
        test="zz";
    }

    @Provides
    public String provideTest ()
    {
        return test;
    }
}
