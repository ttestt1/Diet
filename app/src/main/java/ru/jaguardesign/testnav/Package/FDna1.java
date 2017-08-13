package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ru.jaguardesign.testnav.R;
import ru.jaguardesign.testnav.UI.DnaAnwer;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FDna1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FDna1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FDna1 extends Fragment {
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
     * @return A new instance of fragment FDna1.
     */
    // TODO: Rename and change types and number of parameters
    public static FDna1 newInstance(String param1, String param2) {
        FDna1 fragment = new FDna1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FDna1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private CalendarView calendarView;
    DnaAnwer rm;
    private String md;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_fdna1, container, false);
        View v=inflater.inflate(R.layout.fragment_fdna1, container, false);
        calendarView=(CalendarView)v.findViewById(R.id.calendarView);
        md=dat();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                int d = dayOfMonth;
                String month1;
                String dayOfMonth1;
                if (month < 9) month1 = "0" + String.valueOf(month + 1);
                else month1 = String.valueOf(month + 1);
                if (dayOfMonth < 10) dayOfMonth1 = "0" + String.valueOf(dayOfMonth);
                else dayOfMonth1 = String.valueOf(dayOfMonth);
                String curDate = String.valueOf(year) + "-" + month1 + "-" + String.valueOf(dayOfMonth1);
                Log.d("m__", curDate);
                if (!md.equals(curDate))

                {
                    rm.DnaEdit(curDate);
                    md = curDate;
                    Log.d("m__", "a");
                }
            }
        });
        calendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calendarView.get;
                long mcurrentTime = calendarView.getDate();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                // Create a calendar object that will convert the date and time value in milliseconds to date.
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(mcurrentTime);
                String s = formatter.format(calendar.getTime());
                //int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                //int minute = mcurrentTime.get(Calendar.MINUTE);
                Log.d("m__", s);
                rm.DnaEdit(s);
            }
        });
        Button bu=(Button)v.findViewById(R.id.button10);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rm.DnaEdit(md);
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
            rm=(DnaAnwer)activity;
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
    private String dat()
    {
        long mcurrentTime = calendarView.getDate();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mcurrentTime);
        String s = formatter.format(calendar.getTime());
        return s;
    }
}
