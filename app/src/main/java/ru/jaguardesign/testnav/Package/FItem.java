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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.ItemAnwer;
import ru.jaguardesign.testnav.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FItem.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FItem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FItem extends Fragment {
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
     * @return A new instance of fragment FItem.
     */
    // TODO: Rename and change types and number of parameters
    public static FItem newInstance(Long param3,String param1, String param2) {
        FItem fragment = new FItem();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        id=param3;
        return fragment;
    }

    public FItem() {
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
    Context ctx;
    static Long id;
    ItemAnwer itemresponse;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_fitem, container, false);
        DB db = new DB(ctx);
        db.open();
        Log.d("m__z", String.valueOf(id));
        Cursor cur=db.getidData(id);
        cur.moveToFirst();

        final   View v= inflater.inflate(R.layout.fragment_fitem, container, false);
        //((TextView) v.findViewById(R.id.textView12)).setText( String.valueOf(p.ves));
        ((TextView) v.findViewById(R.id.textView5)).setText( cur.getString(cur.getColumnIndex(db.BELKI)));
        ((TextView) v.findViewById(R.id.textView6)).setText(cur.getString(cur.getColumnIndex(db.GIRY)));
        ((TextView) v.findViewById(R.id.textView8)).setText(cur.getString(cur.getColumnIndex(db.UGLEVODY)));
        ((TextView) v.findViewById(R.id.title_list_Text)).setText(cur.getString(cur.getColumnIndex(db.TITLE)));
        ((TextView) v.findViewById(R.id.textView10)).setText(cur.getString(cur.getColumnIndex(db.KAL)));
        ((TextView) v.findViewById(R.id.textView15)).setText(cur.getString(cur.getColumnIndex(db.O)));
        CheckBox ch=(CheckBox)v.findViewById(R.id.checkBox3);ch.setSaveEnabled(false);
        ch.setChecked(false);
        ch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                     /*   if (BuildConfig.PAID)   {     DB db1=new DB(ctx); db1.open();
                            if (isChecked) db1.SetC(id.intValue(),1); else db1.SetC(id.intValue(),0);
                            db1.close();} else {
                            Toast.makeText(ctx, getString(R.string.item2), Toast.LENGTH_LONG).show();
                            final View coordinatorLayoutView = v.findViewById(R.id.snackbarPosition);
        /*    final View coordinatorLayoutView = v.findViewById(R.id.snackbarPosition);
            final View.OnClickListener clickListener = new View.OnClickListener() {
                public void onClick(View v) {
                    // ...
                }
            };
            Snackbar
                    .make(coordinatorLayoutView, R.string.item2, Snackbar.LENGTH_LONG)
                    .setAction("", clickListener)
                    .show();
        */}
                   // }
                }
        );
        if (cur.getString(cur.getColumnIndex(db.C)).equals("1"))  ch.setChecked(true);else((CheckBox) v.findViewById(R.id.checkBox3)).setChecked(false);

        // Log.d("m__z", cur.getString(cur.getColumnIndex(db.C))+"z");
        Button b= (Button) v.findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemresponse.ItemFinish(id);
            }
        });

        // Log.d("m__", cur.getString(cur.getColumnIndex(db.DES)));
        db.close();
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
            itemresponse = (ItemAnwer) activity;//    mListener = (OnFragmentInteractionListener) activity;
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
