package ru.jaguardesign.testnav.EClass;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.jaguardesign.testnav.R;
//import ru.jaguardesign.krok1.R;

/**
 * Created by x on 25.04.2017.
 */
public class GetAu {
    private final String LOG_TAG="m__";
    private Context ctx;
    private String tokenid;
    private SharedPreferences sPref;
    public GetAu()
    {

    }
    public void Getf(Context c,SharedPreferences spr,String s)
    { ctx=c;sPref=spr; tokenid=s;
        Gethttp gethttp=new Gethttp(1);
        Log.d(LOG_TAG,tokenid);
                 gethttp.getApi().getfauth(tokenid, "get_f_au").enqueue(new Callback<String>() {
                     @Override
                     public void onResponse(Call<String> call, Response<String> response) {
                         //Данные успешно пришли, но надо проверить response.body() на null
                         //  images.addAll(response.body());
//                String tit=images.get(0).url;
                         String pass=sPref.getString(ctx.getString(R.string.pass_),"");
                         if (response.body() != null) {
                             if (!response.body().equals("f")) // прошел токен
                             if (pass.equals(""))//пустой пароль в настройках
                             { Log.d(LOG_TAG,"o:"+response.body());
                             if (response.body().equals("ok")) //вставилась новая зап
                             {
                                 SharedPreferences.Editor ed = sPref.edit();
                                 ed.clear();
                                 ed.putString(ctx.getString(R.string.pass_), tokenid);
                                 ed.commit();
                                 //sPref = getPreferences(MODE_PRIVATE);
                             }
                             else //сменился пароль
                             {
                                // Log.d(LOG_TAG,"new pass:"+response.body());
                                 SharedPreferences.Editor ed = sPref.edit();
                                 ed.clear();
                                 ed.putString(ctx.getString(R.string.pass_), response.body());
                                 ed.commit();
                             }
                             }
                             // Log.d(LOG_TAG, "z");
                             Log.d(LOG_TAG, response.body());

                         }
                     }

                     @Override
                     public void onFailure(Call<String> call, Throwable t) {
                         //Произошла ошибка
                         Log.d(LOG_TAG, "z");
                     }

                 });
    }
}
