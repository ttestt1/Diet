package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.MainActivity;
import ru.jaguardesign.testnav.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FBlu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FBlu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FBlu extends Fragment {
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
     * @return A new instance of fragment Fblu.
     */
    // TODO: Rename and change types and number of parameters
    public static FBlu newInstance(Long param3, String param1, String param2) {
        FBlu fragment = new FBlu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        id=param3;
        return fragment;
    }

    public FBlu() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ctx=getActivity().getApplicationContext();
    }
    public AdView adView;
Context ctx;
  static   Long id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_fblu, container, false);
        View v=inflater.inflate(R.layout.fragment_fblu, container, false);
        DB db = new DB(ctx);
        db.open();
        // Log.d("m__z", String.valueOf(id));
        Cursor cur=db.getIdCook(id);
        cur.moveToFirst();
        ((TextView) v.findViewById(R.id.title_list_Text)).setText(cur.getString(cur.getColumnIndex(db.TITLE2)));
        ((TextView) v.findViewById(R.id.textView15)).setText(cur.getString(cur.getColumnIndex(db.DESCP2)));
        db.close();
    //    boolean q=BuildConfig.PAID;
       /* if (q) {LinearLayout layout = (LinearLayout) v.findViewById(R.id.mob); layout.setMinimumHeight(0);

            layout.removeAllViews();
        } else {
         /*   MainActivity.mInterstitialAd = new InterstitialAd(getActivity());
            MainActivity.mInterstitialAd.setAdUnitId("ca-app-pub-6759905339207162/5119906937");
            final AdRequest adRequest = new AdRequest.Builder()
                    //.addTestDevice("0123456789ABCDF")
                    .build();

            // �������� adView � �����������.
            MainActivity.mInterstitialAd.loadAd(adRequest);
          /*  if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

*/
            MainActivity.mInterstitialAd.loadAd(MainActivity.adRequest);
            if (MainActivity.mInterstitialAd.isLoaded()){
                MainActivity.mInterstitialAd.show(); Log.d("zz", "zz");}
            else Log.d("zz","za");
            //mInterstitialAd.show();

            adView = new AdView(getActivity());
            //  Log.d("zx", "z");
            adView.setAdUnitId("ca-app-pub-6759905339207162/8696362939");
            adView.setAdSize(AdSize.BANNER);
            LinearLayout layout = (LinearLayout) v.findViewById(R.id.mob);

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
        /*try {
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

}
