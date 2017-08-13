package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.R;
import ru.jaguardesign.testnav.UI.BGU_M;
import ru.jaguardesign.testnav.UI.Raschet_M;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FMore.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FMore#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FMore extends Fragment {TextView tvb;TextView tvb1; ProgressBar pgbb;TextView tvg;TextView tvg1; ProgressBar pgbg;TextView tvu;TextView tvu1; ProgressBar pgbu;TextView tvk;TextView tvk1; ProgressBar pgbk; EditText ed;
  BGU_M bgu_m;  // EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    RadioButton ch;
    Button bu;
    static String date;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Context ctx;
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
     * @return A new instance of fragment FMore.
     */
    // TODO: Rename and change types and number of parameters
    public static FMore newInstance(String param,String param1, String param2) {
        date=param;
        FMore fragment = new FMore();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FMore() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_fmore, container, false);

        tvb=(TextView)v.findViewById(R.id.textView37);
        tvb1=(TextView)v.findViewById(R.id.textView38);
        pgbb=(ProgressBar)v.findViewById(R.id.progressBar3);
        tvb.setText("0");
        tvb1.setText("-0");tvb1.setTextColor(Color.parseColor("#D43449"));
        tvg=(TextView)v.findViewById(R.id.textView33);
        tvg1=(TextView)v.findViewById(R.id.textView34);
        pgbg=(ProgressBar)v.findViewById(R.id.progressBar2);
        tvg.setText("0");
        tvg1.setText("+0");tvg1.setTextColor(Color.parseColor("#56D13B"));
        tvu=(TextView)v.findViewById(R.id.textView41);
        tvu1=(TextView)v.findViewById(R.id.textView42);
        pgbu=(ProgressBar)v.findViewById(R.id.progressBar4);
        tvu.setText("0");
        tvu1.setText("+0");tvu1.setTextColor(Color.parseColor("#56D13B"));
        tvk=(TextView)v.findViewById(R.id.textView45);
        tvk1=(TextView)v.findViewById(R.id.textView46);
        pgbk=(ProgressBar)v.findViewById(R.id.progressBar5);
        tvk.setText("0");
        tvk1.setText("+0");tvk1.setTextColor(Color.parseColor("#56D13B"));
        ed=(EditText)v.findViewById(R.id.editText8);//вес
        ed2=(EditText)v.findViewById(R.id.editText3);//возраст
        ed3=(EditText)v.findViewById(R.id.editText5);//талия
        ed4=(EditText)v.findViewById(R.id.editText7);//рост
        ed5=(EditText)v.findViewById(R.id.editText9);//кол во дней
        ch=(RadioButton)v.findViewById(R.id.radioButton);
        bu=(Button)v.findViewById(R.id.button);
        bu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.d(LOG_TAG, "Button click in Fragment2");
                int s;
                int m;
                int d;
                int w;
                int tal;
                int ro;
                int le;
                if (ch.isChecked()) m = 1;
                else m = 0;
                // d=Integer.valueOf(ed5.getText().toString());
                // w=Integer.valueOf(ed.getText().toString());
                // tal=Integer.valueOf(ed3.getText().toString());
                // ro=Integer.valueOf(ed4.getText().toString());
                //vo=Integer.valueOf(ed2.getText().toString());

                w = 0;
                d = 0;
                tal=0;
                ro=0;
                le=0;
                if (ed.getText().toString().trim().length() != 0)
                    w = Integer.valueOf(ed.getText().toString());
                if (ed5.getText().toString().trim().length() != 0)
                    d = Integer.valueOf(ed5.getText().toString());
                if (ed3.getText().toString().trim().length() != 0)
                    tal = Integer.valueOf(ed3.getText().toString());
                if (ed4.getText().toString().trim().length() != 0)
                    ro = Integer.valueOf(ed4.getText().toString());
                if (ed2.getText().toString().trim().length() != 0)
                    le = Integer.valueOf(ed2.getText().toString());
                Context ctx;
                ctx = getActivity().getApplicationContext();
                InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ed.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(ed2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(ed3.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(ed4.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(ed5.getWindowToken(), 0);
                int z = 1;
                /*if (w < 40 || w > 120) {
                    z = 0;
                    ed.setText("80");
                    Toast toast = Toast.makeText(ctx, getString(R.string.tw),
                            Toast.LENGTH_SHORT);
                    // toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
                if (d < 1 || d > 5) {
                    z = 0;
                    ed5.setText("2");
                    Toast toast = Toast.makeText(ctx, getString(R.string.td),
                            Toast.LENGTH_SHORT);
                    // toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }*/
                z=Check(w,d,tal,ro,le);
                if (z == 0) {
                    int zz = 0;
                } else { Raschet_M raschet_m=new Raschet_M(le, tal,ro, m,w);//bgu_m=new BGU_M();
                bgu_m=raschet_m.Run();
                    sh();
                  //  editresponse.EditFinish(le, tal, ro, w, d, m);
                }
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
    private int Check (int w, int d,int tal, int ro, int le)
    {
        Context   ctx=getActivity().getApplicationContext();
        int z=1;
        if (w < 40 || w > 120) {
            z = 0;
            ed.setText("80");
            Toast toast = Toast.makeText(ctx, getString(R.string.tw),
                    Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            toast.show();
        }
        if (d < 1 || d > 5) {
            z = 0;
            ed5.setText("2");
            Toast toast = Toast.makeText(ctx, getString(R.string.td),
                    Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            toast.show();
        }
        if (tal < 40 || tal > 155) {
            z = 0;
            ed3.setText("50");
            Toast toast = Toast.makeText(ctx, getString(R.string.tz),
                    Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            toast.show();
        }
        if (ro < 140 || ro > 210) {
            z = 0;
            ed4.setText("170");
            Toast toast = Toast.makeText(ctx, getString(R.string.ro),
                    Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            toast.show();
        }
        if (le < 18 || le > 120) {
            z = 0;
            ed2.setText("25");
            Toast toast = Toast.makeText(ctx, getString(R.string.le),
                    Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
            toast.show();
        }
        return z;
    }
    private void sh()
    {
      DB  db=new DB(ctx);
        db.open();
      Cursor  cu=db.Dne(date);
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
        Log.d("m__",String.valueOf(be));
        tvb.setText(String.valueOf(be));
        if ((be-bgu_m.belki)<0) { tvb1.setTextColor(Color.parseColor("#D43449"));
            tvb1.setText(String.valueOf(be-bgu_m.belki));
        } else {
            tvb1.setTextColor(Color.parseColor("#56D13B"));
            tvb1.setText("+"+String.valueOf(be-bgu_m.belki));
        }
        pgbb.setProgress(Math.round(100 * be / bgu_m.belki));

        tvg.setText(String.valueOf(gi));
        if ((gi-bgu_m.gir)<0) { tvg1.setTextColor(Color.parseColor("#D43449"));
            tvg1.setText(String.valueOf(gi-bgu_m.gir));
        } else {
            tvg1.setTextColor(Color.parseColor("#56D13B"));
            tvg1.setText("+"+String.valueOf(ug-bgu_m.uglevodi));
        }
        pgbg.setProgress(Math.round(100*gi/bgu_m.gir));

        tvu.setText(String.valueOf(ug));
        if ((ug-bgu_m.uglevodi)<0) { tvu1.setTextColor(Color.parseColor("#D43449"));
            tvu1.setText(String.valueOf(ug-bgu_m.uglevodi));
        } else {
            tvu1.setTextColor(Color.parseColor("#56D13B"));
            tvu1.setText("+"+String.valueOf(ug-bgu_m.uglevodi));
        }
        pgbu.setProgress(Math.round(100*ug/bgu_m.uglevodi));

        tvk.setText(String.valueOf(kal));
        if ((kal-bgu_m.kkal)<0) { tvk1.setTextColor(Color.parseColor("#D43449"));
            tvk1.setText(String.valueOf(kal-bgu_m.kkal));
        } else {
            tvk1.setTextColor(Color.parseColor("#56D13B"));
            tvk1.setText("+"+String.valueOf(kal-bgu_m.kkal));
        }
        pgbk.setProgress(Math.round(100*kal/bgu_m.kkal));
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

}
