package ru.jaguardesign.testnav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by x on 22.05.2016.
 */

public class ItemAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Result> objects;

   public ItemAdapter(Context context, ArrayList<Result> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.result_item, parent, false);
        }

        Result p = getProduct(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка

        ((TextView) view.findViewById(R.id.textView12)).setText( String.valueOf(p.ves));
        ((TextView) view.findViewById(R.id.textView5)).setText( String.valueOf(p.belk));
        ((TextView) view.findViewById(R.id.textView6)).setText( String.valueOf(p.giry));
        ((TextView) view.findViewById(R.id.textView8)).setText( String.valueOf(p.uglevody));
        ((TextView) view.findViewById(R.id.title_list_Text)).setText(p.title);
        ((TextView) view.findViewById(R.id.textView10)).setText(String.valueOf(p.kkal));
      //  ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.image);

     //   CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
        // присваиваем чекбоксу обработчик
       // cbBuy.setOnCheckedChangeListener(myCheckChangList);
        // пишем позицию
        //cbBuy.setTag(position);
        // заполняем данными из товаров: в корзине или нет
     //   cbBuy.setChecked(p.box);
        return view;
    }

    // товар по позиции
    Result getProduct(int position) {
        return ((Result) getItem(position));
    }



}