package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FBlud.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FBlud#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FBlud extends Fragment {
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
     * @return A new instance of fragment FBlud.
     */
    // TODO: Rename and change types and number of parameters
    public static FBlud newInstance(Long param3,String param1, String param2) {
        FBlud fragment = new FBlud();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        id=param3;
        return fragment;
    }

    public FBlud() {
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
    static Long id;
    Context ctx;
    DB db;
    Cursor cursor;
    SimpleCursorAdapter scAdapter;
    BludAnwer blud;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_fblud, container, false);
        final      View v=inflater.inflate(R.layout.fragment_fblud, container, false);
        db = new DB(ctx);
        db.open();
        //Log.d("m__z", String.valueOf(id));
        cursor = db.getCook(id);
        //Log.d("m__z", String.valueOf(cursor.getCount()));
        //cursor.moveToFirst();
        getActivity().startManagingCursor(cursor);
        String[] from = new String[] { DB.UID2, DB.TITLE2 };
        int[] to = new int[] { R.id.id_list_Text, R.id.title_list_Text };
        ListView lvData= (ListView) v.findViewById(R.id.lvData);
        scAdapter = new SimpleCursorAdapter(ctx, R.layout.item, cursor, from, to);
        //    lvData = (ListView) findViewById(R.id.lvData);
        lvData.setAdapter(scAdapter);
        getActivity().stopManagingCursor(cursor);
        db.close();



        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //
              /*  final long id_=id;
                mInterstitialAd = new InterstitialAd(getActivity());
                mInterstitialAd.setAdUnitId("ca-app-pub-6759905339207162/8696362939");
                final AdRequest adRequest = new AdRequest.Builder()
                        //.addTestDevice("0123456789ABCDF")
                        .build();

                // �������� adView � �����������.
                mInterstitialAd.loadAd(adRequest);
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        //   requestNewInterstitial();
                        // beginPlayingGame();
                        //  ftrans.commit();
                        blud.BludFinish(id_);
                    }
                });
*/
                blud.BludFinish(id);
            }
        });
      /*  if (BuildConfig.PAID) {} else
        {   Toast.makeText(ctx, getString(R.string.show), Toast.LENGTH_LONG).show();

      /*      final View coordinatorLayoutView = v.findViewById(R.id.snackbarPosition);
            final View.OnClickListener clickListener = new View.OnClickListener() {
                public void onClick(View v) {
                    // ...
                }
            };
            Snackbar
                    .make(coordinatorLayoutView, R.string.show, Snackbar.LENGTH_LONG)
                    .setAction("", clickListener)
                    .show();
*/      //  }
        CoordinatorLayout coordinatorLayoutView = (CoordinatorLayout) v.findViewById(R.id.snackbarPosition);
        //  Snackbar snackBar = new Snackbar(getActivity(), getActivity().findViewById(R.id.snackbarPosition));
    //    Snackbar.make(coordinatorLayoutView, R.string.show, Snackbar.LENGTH_LONG)
      //          .show();
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
            blud = (BludAnwer) activity;
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
