package ru.jaguardesign.testnav.EClass;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.jaguardesign.testnav.EIntarface.NewApi;

/**
 * Created by x on 19.01.2017.
 */
public class Gethttp {
    private Retrofit retrofit;
    private static NewApi xAp;
    public  Gethttp(int con)
    {
        if (con==1)
        retrofit = new Retrofit.Builder()
                .baseUrl("http://kshp-company.ru/") //Базовая часть адреса
               // .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .addConverterFactory(new ToStringConverterFactory()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        else
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://kshp-company.ru/") //Базовая часть адреса
                             .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                    //.addConverterFactory(new ToStringConverterFactory()) //Конвертер, необходимый для преобразования JSON'а в объекты
                    .build();

        xAp = retrofit.create(NewApi.class); //Создаем объект, при помощи которого будем выполнять запросы
    }
    public  NewApi getApi() {
        return xAp;
    }
}
