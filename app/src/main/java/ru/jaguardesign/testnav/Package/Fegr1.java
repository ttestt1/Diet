package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Calendar;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fegr1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fegr1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fegr1 extends Fragment {
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
     * @return A new instance of fragment Fegr1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fegr1 newInstance(String param1, String param2) {
        Fegr1 fragment = new Fegr1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fegr1() {
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
    private EditText e;
    private EditText et;
    Context ctx;
    DB db;
    //Cursor cursor;
    Button button;
    Cursor cursor;
    SimpleCursorAdapter scAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_fegr1, container, false);
        View v=inflater.inflate(R.layout.fragment_fegr, container, false);
        et=(EditText)v.findViewById(R.id.editText6);
        e=(EditText)v.findViewById(R.id.editText7);
        button=(Button)v.findViewById(R.id.button6);

        db = new DB(ctx);
        db.open();
        cursor = db.GetGr();
        getActivity().startManagingCursor(cursor);
        String[] from = new String[]{DB.UID10, DB.VES10, DB.DATE10};
        int[] to = new int[]{R.id.id_list_Text, R.id.title_list_Text, R.id.textView17};
        ListView lvData = (ListView) v.findViewById(R.id.lvData3);
        scAdapter = new SimpleCursorAdapter(ctx, R.layout.item_gr, cursor, from, to);
        lvData.setAdapter(scAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (et.getText().toString().equals("")) {
                } else {
                    db.NewGr(et.getText().toString(),e.getText().toString());
                    scAdapter.getCursor().requery();
                    scAdapter.notifyDataSetChanged();
                }
            }});
        registerForContextMenu(lvData);
        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DatePickerDialog mDatePicker;


                    Calendar mcurrentTime = Calendar.getInstance();
                    int year = mcurrentTime.get(Calendar.YEAR);
                    int month = mcurrentTime.get(Calendar.MONTH);
                    int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);
                    mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            String day1; String month1;
                            month=month+1;
                            if(day < 10)
                                day1=0+String.valueOf(day); else day1=String.valueOf(day);
                            if(month < 10)
                                month1=0+String.valueOf(month); else month1=String.valueOf(month);

                            et.setText(year + "-" + month1 + "-" + day1);
                        }
                    }, year, month, day);//Yes 24 hour time
                    mDatePicker.setTitle(getString(R.string.p_t));
                    mDatePicker.show();//  Toast.makeText(getApplicationContext(), "got the focus", Toast.LENGTH_LONG).show();
                }
            }
        });
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
        //    mListener = (OnFragmentInteractionListener) activity;
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
