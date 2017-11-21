package ru.jaguardesign.testnav.EClass;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.EIPresenter.IMainPresenter;

/**
 * Created by x on 13.08.2017.
 */
public class GetFood { private IMainPresenter imp;
    private final String LOG_TAG="m__"; private String act="";
    private Context ctx;
    public GetFood()
    {

    }
    public void getf(IMainPresenter im,Context c,String s)
    { imp=im; act=s;
        Gethttp gethttp=new Gethttp(1);
        ctx=c;String la="";//sPref=spr; tokenid=s;
        String la1=ctx.getResources().getConfiguration().locale.getLanguage();
        GetLang getlang=new GetLang(ctx);
        la=getlang.get();
        gethttp.getApi().gettable(la,s).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Данные успешно пришли, но надо проверить response.body() на null
                //  images.addAll(response.body());
                if (response.body() != null) {
                    DB db=new DB(ctx);db.open();
                    if (act.equals("get_e_food")) try
                    {
                        JSONArray array=new JSONArray(response.body());
                        db.upRecFood1(array);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (act.equals("get_cook")) try
                    {
                        JSONArray array=new JSONArray(response.body());
                        db.upRecCook(array);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (act.equals("get_table_food")) try
                    {
                        JSONArray array=new JSONArray(response.body());
                        db.upRecFood(array);
                        imp.Response();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // Log.d(LOG_TAG, "z");
                    db.close();
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
    private void t()
    { String la;
        if (ctx.getResources().getConfiguration().locale.getLanguage().equals("ru")) {la="";
            //mt.execute("http://kshp-company.ru/z_diet/1_.php?act=get_table_food");
        } else if (ctx.getResources().getConfiguration().locale.getLanguage().equals("zh")) {la="cn";
            //mt.execute("http://kshp-company.ru/z_diet/1_.php?la=cn&act=get_table_food");
        } else if (ctx.getResources().getConfiguration().locale.getLanguage().equals("fr")) { la="fr";
            //  mt.execute("http://kshp-company.ru/z_diet/1_.php?la=fr&act=get_table_food");
        } else if (ctx.getResources().getConfiguration().locale.getLanguage().equals("ar")) { la="r";
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?la=r&act=get_table_food");*/ }
        else
        if (ctx.getResources().getConfiguration().locale.getLanguage().equals("it")) { la="it";
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?la=it&act=get_table_food");*/ }
        else
        if (ctx.getResources().getConfiguration().locale.getLanguage().equals("de")) { la="de";
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?la=de&act=get_table_food");*/ }
        else
        if (ctx.getResources().getConfiguration().locale.getLanguage().equals("ko")) { la="ko";
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?la=ko&act=get_table_food");*/ }
        else
        if (ctx.getResources().getConfiguration().locale.getLanguage().equals("ja")) { la="ja";
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?la=ja&act=get_table_food");*/ }
        else
        if (ctx.getResources().getConfiguration().locale.getLanguage().equals("es")) { la="es";
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?la=es&act=get_table_food");*/ }
        else
        if (ctx.getResources().getConfiguration().locale.getLanguage().equals("pt")) { la="po";
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?la=po&act=get_table_food");*/ }
        else
        { la="en";
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?&la=en&act=get_table_food");*/ }
    }
}
