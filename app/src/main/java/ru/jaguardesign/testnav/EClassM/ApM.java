package ru.jaguardesign.testnav.EClassM;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by x on 23.01.2017.
 */
@Module
public class ApM {
    private Context acontext;

    public ApM(@NonNull Context context)
    {
        acontext=context;
    }
    @Provides
    @Singleton
    Context provideC ()
    {
        return acontext;
    }
}
