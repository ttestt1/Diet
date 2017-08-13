package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.R;
import ru.jaguardesign.testnav.UI.DneAnwer;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FDne1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FDne1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FDne1 extends Fragment {
    DneAnwer dneanwer;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FDne1.
     */
    // TODO: Rename and change types and number of parameters
    public static FDne1 newInstance(String param3,String param1, String param2) {
        FDne1 fragment = new FDne1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        date=param3;
        return fragment;
    }

    public FDne1() {
        // Required empty public constructor
    }
    private static String date;
    Context ctx;
    DB db;
    Cursor cu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ctx=getActivity().getApplicationContext();
    }
    private TextView tv;
    SimpleCursorAdapter scAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_fdne1, container, false);
        View v=inflater.inflate(R.layout.fragment_fdne1, container, false);
       FloatingActionButton fab = (FloatingActionButton)v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   fab.clearAnimation();

                //        Animation animation = AnimationUtils.loadAnimation(ctx, R.anim.fab);
                //      fab.startAnimation(animation);

                dneanwer.DneEdit(date);

            }
        });
        db=new DB(ctx);
        db.open();
        cu=db.Dne(date);
        int kal=0;
        int vv=cu.getCount();
        int be=0;
        int gi=0;
        int ug=0;
        if (cu!=null)
            if (cu.moveToFirst())
                do //  while (cu.moveToNext())
                {
                    Cursor cu1=db.getidData(Long.parseLong(cu.getString(cu.getColumnIndex(DB.UIDF11))));
                    int kalt=0;
                    int bet=0;
                    int git=0;
                    int ugt=0;
                    if (cu1!= null)
                        if (cu1.moveToFirst()) {
                            kalt = cu.getInt(cu.getColumnIndex(DB.VES11))*cu1.getInt(cu1.getColumnIndex(DB.KAL))/100;
                            bet = cu.getInt(cu.getColumnIndex(DB.VES11))*cu1.getInt(cu1.getColumnIndex(DB.BELKI))/100;
                            git = cu.getInt(cu.getColumnIndex(DB.VES11))*cu1.getInt(cu1.getColumnIndex(DB.GIRY))/100;
                            ugt = cu.getInt(cu.getColumnIndex(DB.VES11))*cu1.getInt(cu1.getColumnIndex(DB.UGLEVODY))/100;
                        }
                    kal=kal+kalt;
                    be=be+bet;
                    gi=gi+git;
                    ug=ug+ugt;
                    Log.d("m__", "zz");
                }while (cu.moveToNext());
        Log.d("m__",String.valueOf(kal));
        // ArrayList<Entry> entries = new ArrayList<>();
        PieChart lineChart = (PieChart) v.findViewById(R.id.linegraph);
        ArrayList<Entry> entries = new ArrayList<>();


        //entries.add(new Entry(kal, 0));
        entries.add(new Entry(gi, 1));
        entries.add(new Entry(ug, 1));
        entries.add(new Entry(be, 1));
        ArrayList<String> labels = new ArrayList<String>();
        int colors[] ={Color.rgb(84, 139, 221), Color.rgb(251, 249, 146),Color.rgb(151, 212, 153), Color.rgb(183, 144, 189),Color.rgb(226, 148, 188),Color.rgb(208, 189, 121),Color.rgb(185, 147, 134),Color.rgb(206, 139, 130)};
        //labels.add("Каллории");
        labels.add(getString(R.string.fdn_g));//labels.add("Жиры");
        labels.add(getString(R.string.fdn_u));//labels.add("Углеводы");
        labels.add(getString(R.string.fdn_b));//labels.add("Белки");
        PieDataSet dataset = new PieDataSet(entries, "");
        dataset.setColors(colors);
        dataset.setSliceSpace(3f);
        PieData data = new PieData(labels, dataset);
        lineChart.setData(data); // set the data and list of lables into chart
        lineChart.setDescription(getString(R.string.fdn_o));
        tv=(TextView)v.findViewById(R.id.textView28);
        tv.setText(getString(R.string.fdn_k) + kal);
        //cu.moveToFirst();
        String[] from = new String[]{DB.UID11, DB.TITLE11, DB.VES11};
        int[] to = new int[]{R.id.id_list_Text, R.id.title_list_Text, R.id.textView17};
        ListView lvData = (ListView) v.findViewById(R.id.lvData4);
        scAdapter = new SimpleCursorAdapter(ctx, R.layout.item_gr1, cu, from, to);
        lvData.setAdapter(scAdapter);
        registerForContextMenu(lvData);
        if (kal==0)
        {
            CoordinatorLayout coordinatorLayoutView = (CoordinatorLayout) v.findViewById(R.id.snackbarPosition);
            //  Snackbar snackBar = new Snackbar(getActivity(), getActivity().findViewById(R.id.snackbarPosition));
            Snackbar.make(coordinatorLayoutView, R.string.fdn_n, Snackbar.LENGTH_LONG)
                    .show();
        }
        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) { dneanwer=(DneAnwer) activity;
        super.onAttach(activity);
     /*   try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        int id_item = (int) info.id;
        menu.add(0, id_item, 0, getString(R.string.zgr_del));

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int mid = item.getItemId();
        int gmid = item.getGroupId();

        switch (gmid) {
            case 0:
                //Cursor c=db.gIdBu(mid);
                //c.moveToFirst();
                //String act=c.getString(c.getColumnIndex(DB.TIME8));
                //String tim=c.getString(c.)
                // cancelB(act,act);
                db.delm(mid);


                scAdapter.getCursor().requery();
                scAdapter.notifyDataSetChanged();


                break;
        }

        return super.onContextItemSelected(item);
    }
}
