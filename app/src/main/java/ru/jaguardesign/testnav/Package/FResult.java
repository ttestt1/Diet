package ru.jaguardesign.testnav.Package;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ru.jaguardesign.testnav.DB;
import ru.jaguardesign.testnav.ItemAdapter;
import ru.jaguardesign.testnav.R;
import ru.jaguardesign.testnav.ResAnwer;
import ru.jaguardesign.testnav.Result;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FResult.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FResult#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FResult extends Fragment {
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
     * @return A new instance of fragment FResult.
     */
    // TODO: Rename and change types and number of parameters
    public static FResult newInstance(ArrayList<Result> r,String param1, String param2) {
        FResult fragment = new FResult();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        res=r;
        return fragment;
    }

    public FResult() {
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
    ListView lvMain;
  //  ResAnwer response;
    private FloatingActionButton fab;
    private DB db;
    private FloatingActionButton fab1;
    Context ctx;
    public ItemAdapter ia;
    static  private ArrayList<Result> res;
    ResAnwer response;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fresult, container, false);
        // Inflate the layout for this fragment
        db=new DB(ctx);
        final  View v=inflater.inflate(R.layout.fragment_fresult, container, false);
        ia = new ItemAdapter(ctx, res);
        lvMain = (ListView) v.findViewById(R.id.lvDat);
        lvMain.setAdapter(ia);
        lvMain.requestFocus();
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                //Here you can get the position and access your
                //TicketList Object
                // Log.d("m__",String.valueOf(pos));
                Long id=res.get(pos).id;
                //  Log.d("m__",String.valueOf(id));
                response.ResFinish(id);
            }
        });
        //int position = lvMain.getFirstVisiblePosition();
        //lvMain.setSelectionFromTop(position,0);
        //  lvMain.setSelection(0);
        //InputMethodManager mgr = (InputMethodManager) mGap.getSystemService(Context.INPUT_METHOD_SERVICE);
        //mgr.hideSoftInputFromWindow(mAppView.getWindowToken(), 0);
        //InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        //ctx.getSystemService()
        fab = (FloatingActionButton)v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.open();
                db.updateRes(res);
                db.close();
                CoordinatorLayout coordinatorLayoutView = (CoordinatorLayout) v.findViewById(R.id.snackbarPosition);
                // CoordinatorLayout coordinatorLayoutView = (CoordinatorLayout) v.findViewById(R.id.snackbarPosition);
                // Snackbar snackBar = new Snackbar(getActivity(), getActivity().findViewById(R.id.snackbarPosition));
                Snackbar.make(coordinatorLayoutView, R.string.save_m, Snackbar.LENGTH_LONG)
                        .show();
                Log.d("m__", "up");
            }
        });
    /*    fab1 = (FloatingActionButton)v.findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/html");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>This is the text shared.</p>"));
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });*/
        registerForContextMenu(lvMain);
        CoordinatorLayout coordinatorLayoutView = (CoordinatorLayout) v.findViewById(R.id.snackbarPosition);
        //  Snackbar snackBar = new Snackbar(getActivity(), getActivity().findViewById(R.id.snackbarPosition));
        Snackbar.make(coordinatorLayoutView, R.string.f_r, Snackbar.LENGTH_LONG)
                .show();
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
         //   mListener = (OnFragmentInteractionListener) activity;
            response = (ResAnwer) activity;
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
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        int id_item = (int) info.id;
        menu.add(0, id_item, 0, getString(R.string.f_c));

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
                Log.d("m__",String.valueOf(mid));
                Result it=res.get(mid);
                Log.d("m__",String.valueOf(it.id));
                db.open();
               Cursor c_= db.re(it.id);
re (mid,c_);

           //     scAdapter.getCursor().requery();
             //   scAdapter.notifyDataSetChanged();


                break;
        }

        return super.onContextItemSelected(item);
    }
    private void re(int id,Cursor c)
    {
        int ib=0;
        int iu=0;
        int ig=0;
        int ik=0;
        if (c!=null)
            if (c.moveToFirst())
            {
                Cursor cur_bel=  db.getBel();
                Cursor cur_gir =db.getGir();
                Cursor cur_ugl=db.getUgl();
                // Cursor cur_kkal=db.getKkal();
                Cursor cur_kl=db.getKl();
                cur_bel.moveToFirst();
                cur_gir.moveToFirst();
                cur_ugl.moveToFirst();
                cur_kl.moveToFirst();
                ib=c.getInt(c.getColumnIndex(DB.IB));
                ig=c.getInt(c.getColumnIndex(DB.IG));
                ik=c.getInt(c.getColumnIndex(DB.IK));
                iu=c.getInt(c.getColumnIndex(DB.IU));

                Log.d("m__",String.valueOf(ib)+String.valueOf(iu)+String.valueOf(ik)+String.valueOf(ig));
                Result it=res.get(id);
                float oves=it.ves;//г вес продукта текущего
                float obel=(oves*it.belk)/100;//вес его белков в г
                float obug=(oves*it.uglevody)/100;//углеводов
                float ogir=(oves*it.giry)/100;//жиров
                float okkal=(oves*it.kkal)/100;//его ккал
                float nves=0;




                Cursor   cur=null;
                if (ib==1)
                {
                    // nves=(obel/cur_bel.getFloat(cur_bel.getColumnIndex(DB.BELKI)))/10;//в кг вес нового продукта
                    //   cur=  db.getBel();
                    cur=  cur_bel;
                    nves=(okkal/cur_bel.getFloat(cur_bel.getColumnIndex(DB.KAL)))/10;//в кг вес нового продукта
                }
                if (ig==1)
                {

                    cur=  cur_gir; //db.getGir();
                    nves=(okkal/cur_gir.getFloat(cur_gir.getColumnIndex(DB.KAL)))/10;//в кг вес нового продукта
                }
                if (ik==1)
                {

                    cur=  cur_kl; //db.getGir();
                    nves=(okkal/cur_kl.getFloat(cur_kl.getColumnIndex(DB.KAL)))/10;//в кг вес нового продукта
                }
                if (iu==1)
                {

                    cur=  cur_ugl; //db.getGir();
                    nves=(okkal/cur.getFloat(cur.getColumnIndex(DB.KAL)))/10;//в кг вес нового продукта
                }
                float nkkal=cur.getLong(cur.getColumnIndex(DB.KAL));
                float ngir=cur.getLong(cur_bel.getColumnIndex(DB.GIRY));
                float nug=cur.getLong(cur.getColumnIndex(DB.UGLEVODY));
                float nbe=cur.getLong(cur.getColumnIndex(DB.BELKI));
                Log.d("m__",String.valueOf(nves));
                String t=cur.getString(cur.getColumnIndex(DB.TITLE));
                Result res1=new Result(tr(it.title)+"- "+t,nves,nkkal,nug,nbe,ngir);
                //куыюшв=
                res1.id=cur.getLong(cur.getColumnIndex(DB.UID));
                res.remove(id);
                res.add(id,res1);
                ia.notifyDataSetChanged();
    }
    }
    String tr(String s)
    {
        String z[]=s.split("-");
        return z[0];
    }
}
