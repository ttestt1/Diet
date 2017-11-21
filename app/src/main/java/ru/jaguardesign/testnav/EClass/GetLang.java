package ru.jaguardesign.testnav.EClass;

import android.content.Context;

/**
 * Created by x on 15.08.2017.
 */
public class GetLang {
    private Context ctx;
    public GetLang(Context c)
    {
        ctx=c;
    }
    public String get()
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
            /*mt.execute("http://kshp-company.ru/z_diet/1_.php?&la=en&act=get_table_food");*/ } return la;

       // return "en";
    }
}
