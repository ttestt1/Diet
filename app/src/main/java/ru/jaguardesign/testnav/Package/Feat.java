package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.R;
import ru.jaguardesign.testnav.UI.Calc;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Feat.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Feat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Feat extends Fragment {
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
     * @return A new instance of fragment Feat.
     */
    // TODO: Rename and change types and number of parameters
    public static Feat newInstance(String param1, String param2) {
        Feat fragment = new Feat();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Feat() {
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
    View vz;
    private SearchView searchView;
    private Context ctx;
    private DB db;
    CursorAdapter scAdapter;
    Cursor cu;
    Button bu;
    Button bu1;
    EditText ed;
    EditText ed1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_feat, container, false);
        View v =inflater.inflate(R.layout.fragment_feat, container, false);
        searchView=(SearchView)v.findViewById(R.id.searchView);
        String[] from = new String[]{DB.UID10, DB.VES10, DB.DATE10};
        int[] to = new int[]{R.id.id_list_Text, R.id.title_list_Text, R.id.textView17};
        ListView lvData = (ListView) v.findViewById(R.id.lvData3);
        //scAdapter = new SimpleCursorAdapter(ctx, R.layout.item_gr, cursor, from, to);
        db=new DB(ctx);
        db.open();
        cu=db.Searchfood("");
        scAdapter = new CursorAdapter(ctx,cu) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                //return null;
                //return
                return LayoutInflater.from(context).inflate(R.layout.item_e, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView tv=(TextView)view.findViewById(R.id.title_list_Text);
                String s=cursor.getString(cursor.getColumnIndex(DB.TITLE));
                tv.setText(s);
            }
        };
        searchView.setSuggestionsAdapter(scAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // if (searchView.isExpanded() && TextUtils.isEmpty(newText)) {
                //   search("");
                //}
                if (newText.length() > 1) {
                    cu = db.Searchfood(newText.substring(1));
                    if (cu!=null)
                        scAdapter.swapCursor(cu);
                }
                return true;
            }

            public void search(String query) {
                // reset loader, swap cursor, etc.
            }

        });
        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {
                /*if (submit != null) {
                    return submit.onSuggestionSelect(position);
                } else {
                    return false;
                }*/
                return false;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                cu.moveToPosition(position);
                String s = cu.getString(cu.getColumnIndex(DB.TITLE));
                searchView.setQuery(s, false);
                return false;
            }
        });
        //searchView.res
        bu=(Button)v.findViewById(R.id.button8);
        ed=(EditText)v.findViewById(R.id.editText22);
        vz=v;
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //itemresponse.ItemFinish(id);
                int g=0;
                if (ed.getText().toString().equals("")) {} else g=Integer.valueOf( ed.getText().toString());
                Calc calc=new Calc(ctx,
                        searchView.getQuery().toString()        ,   g                  );
                String s=calc.Raschet();
                //   Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
                if (s.equals(""))
                {
                    Toast.makeText(ctx, getString(R.string.feat_e) + "", Toast.LENGTH_LONG).show();
                } else
                    Dialog(s);
            }
        });
        ed1=(EditText)v.findViewById(R.id.editText6);
        ed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
                            String day1;
                            String month1;
                            month = month + 1;
                            if (day < 10)
                                day1 = 0 + String.valueOf(day);
                            else day1 = String.valueOf(day);
                            if (month < 10)
                                month1 = 0 + String.valueOf(month);
                            else month1 = String.valueOf(month);

                            ed1.setText(year + "-" + month1 + "-" + day1);
                        }
                    }, year, month, day);//Yes 24 hour time
                    mDatePicker.setTitle(getString(R.string.p_t));
                    mDatePicker.show();//  Toast.makeText(getApplicationContext(), "got the focus", Toast.LENGTH_LONG).show();
                }
            }
        });
        bu1=(Button)v.findViewById(R.id.button9);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //itemresponse.ItemFinish(id);

                // Calc calc = new Calc(ctx,
                //         searchView.getQuery().toString(), Integer.valueOf(ed.getText().toString()));
                //String s = calc.Raschet();
                Cursor c=db.CheckDne();
                int count=c.getCount();
                int flag=0;
                //if (BuildConfig.PAID) flag=1;
                if (count<9) flag=1;
                if (flag==1) {
                    boolean s=db.newdn(ed1.getText().toString(),Integer.valueOf(ed.getText().toString()),searchView.getQuery().toString());
                    if (ed1.getText().toString().equals("")) s=false;
                    //   Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
                    if (!s) {
                        Toast.makeText(ctx,getString(R.string.feat_e)+ "", Toast.LENGTH_LONG).show();
                    }else {CoordinatorLayout coordinatorLayoutView = (CoordinatorLayout) vz.findViewById(R.id.snackbarPosition);
                        //  Snackbar snackBar = new Snackbar(getActivity(), getActivity().findViewById(R.id.snackbarPosition));
                        Snackbar.make(coordinatorLayoutView, R.string.feat_s, Snackbar.LENGTH_LONG)
                                .show();}
                }
                else //не платная версия
                {
                    CoordinatorLayout coordinatorLayoutView = (CoordinatorLayout) vz.findViewById(R.id.snackbarPosition);
                    //  Snackbar snackBar = new Snackbar(getActivity(), getActivity().findViewById(R.id.snackbarPosition));
                    Snackbar.make(coordinatorLayoutView, R.string.feat_b, Snackbar.LENGTH_LONG)
                            .show();}}
        });
        return v;}

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
    private void Dialog (String me)
    {
        new AlertDialog.Builder(getActivity()).setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(getString(R.string.calc_t))
                .setMessage(me)
                .setPositiveButton(getString(R.string.d_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

}
