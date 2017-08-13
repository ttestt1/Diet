package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.MainActivity;
import ru.jaguardesign.testnav.R;
import ru.jaguardesign.testnav.UI.FgraAnwer;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fgra.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fgra#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fgra extends Fragment {
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
     * @return A new instance of fragment Fgra.
     */
    // TODO: Rename and change types and number of parameters
    public static Fgra newInstance(String param1, String param2) {
        Fgra fragment = new Fgra();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fgra() {
        // Required empty public constructor
    }
    FloatingActionButton fab;
    Context ctx;
    DB db;
    Cursor cursor;
    FloatingActionButton fab1;
    FgraAnwer rm;
    private AdView adView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ctx=getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_fgra, container, false);
        View v=inflater.inflate(R.layout.fragment_fgra, container, false);
        fab1 = (FloatingActionButton)v.findViewById(R.id.fab2);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rm.GraEdit();
            }
        });
        LineChart lineChart = (LineChart) v.findViewById(R.id.linegraph);
        ArrayList<Entry> entries = new ArrayList<>();
        db=new DB(ctx);
        db.open();
        Cursor c=db.GetGr();
        ArrayList<String> labels = new ArrayList<String>();
        LineDataSet dataset = new LineDataSet(entries, getString(R.string.evz));
        if (c.moveToFirst()) {
            int i=0;
            do {
                entries.add(new Entry(c.getInt(c.getColumnIndex(DB.VES10)), i));
                labels.add(c.getString(c.getColumnIndex(DB.DATE10)));
                i++;

            } while (c.moveToNext());
            LineData data = new LineData(labels, dataset);
            lineChart.setData(data); // set the data and list of lables into chart
            lineChart.setDescription(getString(R.string.ev_v));
            dataset.setDrawFilled(true); // to fill the below area of line in graph
            dataset.setColors(ColorTemplate.COLORFUL_COLORS); // to change the color scheme
        }
      //  boolean q= BuildConfig.PAID;
//        if (q) {LinearLayout layout = (LinearLayout) v.findViewById(R.id.mob1); layout.setMinimumHeight(0);

  //          layout.removeAllViews();
    //    } else {
            MainActivity.mInterstitialAd.loadAd(MainActivity.adRequest);
            if (MainActivity.mInterstitialAd.isLoaded()){
                MainActivity.mInterstitialAd.show(); Log.d("zz", "zz");}
            else Log.d("zz","za");

            adView = new AdView(getActivity());

            adView.setAdUnitId("ca-app-pub-6759905339207162/8696362939");
            adView.setAdSize(AdSize.BANNER);

            LinearLayout layout = (LinearLayout) v.findViewById(R.id.mob1);

            // ���������� � �������� ���������� adView.
            layout.addView(adView);

            // ������������� ������ �������.
            final AdRequest adRequest = new AdRequest.Builder()
                    //.addTestDevice("0123456789ABCDF")
                    .build();

            // �������� adView � �����������.
            adView.loadAd(adRequest);
            adView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    // adView.loadAd(adRequest.build());
                }
            });


       // }
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
          //  mListener = (OnFragmentInteractionListener) activity;
            rm=(FgraAnwer)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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

}
