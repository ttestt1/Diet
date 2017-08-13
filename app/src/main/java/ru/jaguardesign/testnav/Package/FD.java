package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.google.android.gms.ads.AdView;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.MainActivity;
import ru.jaguardesign.testnav.R;
import ru.jaguardesign.testnav.Tohtml1;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FD.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FD#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FD extends Fragment {
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
     * @return A new instance of fragment FD.
     */
    // TODO: Rename and change types and number of parameters
    public static FD newInstance(String param1, String param2) {
        FD fragment = new FD();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FD() {
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
    DB db;
    Cursor cursor;
    SimpleCursorAdapter scAdapter;
    //  D_dapter scAdapter;
    //  private OnFragmentInteractionListener mListener;
    Context ctx;
    public AdView adView;
    private Tohtml1 ht;
    FloatingActionButton fab1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_fd, container, false);
        View v = inflater.inflate(R.layout.fragment_fd, container, false);
        CoordinatorLayout coordinatorLayoutView = (CoordinatorLayout) v.findViewById(R.id.snackbarPosition);
        db = new DB(ctx);
        db.open();
        cursor = db.getAllDataRes();
        fab1 = (FloatingActionButton)v.findViewById(R.id.fab1);
        if (cursor.getCount()==0)
        {
               Snackbar.make(coordinatorLayoutView, R.string.a_snak, Snackbar.LENGTH_LONG)
                      .show();
            fab1.setVisibility(View.INVISIBLE);
        }
        getActivity().startManagingCursor(cursor);
        String[] from = new String[]{DB.UID7, DB.TITLE7, DB.O27, DB.O7};
        int[] to = new int[]{R.id.id_list_Text, R.id.title_list_Text, R.id.textView12, R.id.checkBox4};
        ListView lvData = (ListView) v.findViewById(R.id.lvData);
        scAdapter = new SimpleCursorAdapter(ctx, R.layout.d_item, cursor, from, to);
        //  scAdapter = new D_dapter(ctx, R.layout.d_item, cursor, from, to);
        scAdapter.setViewBinder(new android.support.v4.widget.SimpleCursorAdapter.ViewBinder() {

            public boolean setViewValue(final View aView, Cursor aCursor, int aColumnIndex) {
                final int id = aView.getId();
                final Cursor cu = aCursor;
                if (aColumnIndex == aCursor.getColumnIndex(DB.O7)) {

                    CheckBox ch = (CheckBox) aView;
                    ch.setTag(aCursor.getInt(aCursor.getColumnIndex(DB.UID7)));

                    //ch.setText(R.string.d_eat);
                    ch.setText("");
                    ch.setTextSize(0.1f);
                    if (aCursor.getInt(aColumnIndex) == 1)
                        ch.setChecked(true);// else
                    else ch.setChecked(false);
                    //textView.setText("Create date: " + MyFormatterHelper.formatDate(getApplicationContext(), createDate));
                    //return true;
                }

                if (aView instanceof CheckBox) {
                    //  ((CheckBox) aView).setChecked(myBoolean == 1);
                    ((CheckBox) aView)
                            .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    int c = 0;
                                    if (isChecked) c = 1;
                                    int iid = (Integer) aView.getTag();
                                    db.SetC7(iid, c);
                                    // Log.d("M1", String.valueOf(c));
                                    //   Log.d("M1",String.valueOf(id)+"z");
                                }
                            });

                }
                return false;
            }
        });

        lvData.setAdapter(scAdapter);
        scAdapter.swapCursor(cursor);
        ht=new Tohtml1(ctx,cursor,db);
       // boolean q= BuildConfig.PAID;

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);

                // sharingIntent.setType("text/html");
                sharingIntent.setType("text/plain");
                //sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(ht.te()));
                //sharingIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(ht.te()));
                sharingIntent.putExtra(Intent.EXTRA_TEXT, ht.te());
                startActivity(Intent.createChooser(sharingIntent, ctx.getString(R.string.d_sh)));
            }
        });
       // if (q) {//LinearLayout layout = (LinearLayout) v.findViewById(R.id.mob); layout.setMinimumHeight(0);

            //layout.removeAllViews();
      //  } else {
            MainActivity.mInterstitialAd.loadAd(MainActivity.adRequest);
            if (MainActivity.mInterstitialAd.isLoaded()){
                MainActivity.mInterstitialAd.show(); Log.d("zz", "zz");}
            else Log.d("zz","za");

      //  }
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
      /*  try {
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
