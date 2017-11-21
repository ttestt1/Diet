package ru.jaguardesign.testnav;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import org.json.JSONArray;

import java.util.ArrayList;

import ru.jaguardesign.testnav.EIPresenter.IMainPresenter;
import ru.jaguardesign.testnav.EPresener.MainPresenter;
import ru.jaguardesign.testnav.Package.BludAnwer;
import ru.jaguardesign.testnav.Package.FAbout1;
import ru.jaguardesign.testnav.Package.FBlu;
import ru.jaguardesign.testnav.Package.FBlud;
import ru.jaguardesign.testnav.Package.FD;
import ru.jaguardesign.testnav.Package.FDna1;
import ru.jaguardesign.testnav.Package.FDne1;
import ru.jaguardesign.testnav.Package.FEdit;
import ru.jaguardesign.testnav.Package.FItem;
import ru.jaguardesign.testnav.Package.FMain;
import ru.jaguardesign.testnav.Package.FMore;
import ru.jaguardesign.testnav.Package.FResult;
import ru.jaguardesign.testnav.Package.Feat;
import ru.jaguardesign.testnav.Package.Fegr;
import ru.jaguardesign.testnav.Package.Fegr1;
import ru.jaguardesign.testnav.Package.Fgra;
import ru.jaguardesign.testnav.Package.Fgra1;
import ru.jaguardesign.testnav.UI.DnaAnwer;
import ru.jaguardesign.testnav.UI.DneAnwer;
import ru.jaguardesign.testnav.UI.FgraAnwer;

public class MainActivity extends AppCompatActivity
        implements DneAnwer, NavigationView.OnNavigationItemSelectedListener,
AsyncResponse,MainAnwer,ItemAnwer,EditResponse,BludAnwer, ResAnwer
,FgraAnwer, DnaAnwer{
    IMainPresenter imainp;
ProgressDialog ringProgressDialog;
    Context ctx;
    SharedPreferences sPref;
    private static final String URL="http://kshp-company.ru/z_body/1_.php?act=get_table_food";
    FMore fmore; FMain fmain;
    FItem fitem;
    FEdit fedit;
    //FEdit fedit;
    FBlud fblud;
    FBlu fblu;
    FResult fresult;
    FD fd;
    FAbout1 fabout1;
    Fgra1 fgra;
    Fegr1 fegr;
    Feat feat;
    FDne1 fdne1;
    FDna1 fdna1;
    static  public InterstitialAd mInterstitialAd;
    public static AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
imainp=(IMainPresenter) new MainPresenter(this,this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        drawer.openDrawer(Gravity.LEFT);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ctx=this;
        launchRingDialog(); fmore=new FMore();
        fmain=new FMain();
        fitem=new FItem();
        fedit=new FEdit();
        fblu=new FBlu();
        fblud=new FBlud();
        fresult=new FResult();
        fd=new FD();
        fabout1=new FAbout1();
        fgra=new Fgra1();
        fegr=new Fegr1();
        feat=new Feat();
        fdne1=new FDne1();
        fdna1=new FDna1();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6759905339207162/5119906937");
        adRequest = new AdRequest.Builder()
                //.addTestDevice("0123456789ABCDF")
                .build();
        mInterstitialAd.setAdListener(new AdListener() {

            public void onAdLoaded () {
                mInterstitialAd.show();
            }



            @Override
            public void onAdClosed() {
                //   requestNewInterstitial();
                // beginPlayingGame();
                //  ftrans.commit();
                //  blud.BludFinish(id_);
            }
        });
    }

  /*  @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
 FragmentTransaction ftrans=getFragmentManager().beginTransaction();
        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }

         else if (id == R.id.nav_manage) {



        }
        else if (id == R.id.nav_list) {
            //   Intent intent = new Intent(ctx, MainActivity.class);
            //  intent.putExtra("id", id);
            // startActivity(intent);
            // ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, fmain);

            ftrans.addToBackStack(null);
        } else if (id == R.id.nav_edit) {
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            // ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, fedit);

            ftrans.addToBackStack(null);
        }
        else if (id == R.id.nav_o) {
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            // ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, fd);

            ftrans.addToBackStack(null);
        }
        else if (id == R.id.nav_about) {
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            // ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, fabout1);

            ftrans.addToBackStack(null);
        }
        else if (id == R.id.nav_gr) {
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            // ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, fgra);

            ftrans.addToBackStack(null);
        }
        else if (id == R.id.nav_kal) {
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            // ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, feat);

            ftrans.addToBackStack(null);
        }
        else if (id == R.id.nav_dna) {
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            // ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, fdna1);

            ftrans.addToBackStack(null);
        }
        ftrans.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void launchRingDialog() {

        //ringProgressDialog = ProgressDialog.show(MainActivity.this, "Please wait ...", "Downloading Image ...", true);
        ringProgressDialog = ProgressDialog.show(MainActivity.this, getString(R.string.wait), getString(R.string.wai), true);
        ringProgressDialog.setCancelable(true); imainp.Load();
        DB db = new DB(this);
        db.open();
        Cursor c=db.getS();
        c.moveToFirst();

        int sync=0;
        // sync=c.getInt(c.getColumnIndex(db.SY));
        db.close();

        if (sync==0) {
 //imainp.Load();
        /*    Load mt = new Load(this,this);
            if (getResources().getConfiguration().locale.getLanguage().equals("ru")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("zh")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=cn&act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("fr")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=fr&act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("ar")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=r&act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("it")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=it&act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("de")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=de&act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=ko&act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("ja")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=ja&act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("es")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=es&act=get_table_food"); }
            else
            if (getResources().getConfiguration().locale.getLanguage().equals("pt")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=po&act=get_table_food"); }
            else
            {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?&la=en&act=get_table_food"); }*/
            //mt.execute("http://kshp-company.ru/z_diet/1_.php?act=get_table_food");
           // mt.execute(URL);
        }
        else {
            ringProgressDialog.dismiss();
           // showlist();
        }
        Log.d("la", getResources().getConfiguration().locale.getLanguage());

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 0 ){
                getFragmentManager().popBackStack();
            } else {
              /*  int launch=0;
                sPref = getPreferences(MODE_PRIVATE);
                launch = sPref.getInt(SHARED_LAUNCHES, 0);
                // Log.d("m__",)
                // etText.setText(savedText);
                if (launch>2) {
                    SharedPreferences.Editor ed = sPref.edit();
                    launch=launch-100;
                    String r=sPref.getString(SHARED_RE, "");
                    Log.d("m__",r);
                    ed.putInt(SHARED_LAUNCHES, launch);
                    ed.commit();
                    Dialog();} else {
                    SharedPreferences.Editor ed = sPref.edit();
                    launch++;
                    ed.putInt(SHARED_LAUNCHES, launch);
                    ed.commit();*/
                Log.d("m__","x");
                    super.onBackPressed();
                System.exit(0);
                }
            }

            //   super.onBackPressed();
        }

   // }
    @Override
    public void processFinish(JSONArray output) { imainp.Load1();
        Log.d("m__", "1");
        //this.Mainresult = output;
        if (!Check()) {
            DB db = new DB(this);
            db.open();
          //  db.upRecFood(output);
            db.close();
            Load1 mt = new Load1(this);
            Load2 mt1 = new Load2(this);
          //  Load4 mt4 = new Load4(this);
            if (getResources().getConfiguration().locale.getLanguage().equals("ru")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?act=get_cook");
             //   mt4.execute("http://kshp-company.ru/z_body/1_.php?act=get_spo");
            } else if (getResources().getConfiguration().locale.getLanguage().equals("fr")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=fr&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=fr&act=get_cook");
              //  mt4.execute("http://kshp-company.ru/z_body/1_.php?la=fr&act=get_spo");
            }
            else if (getResources().getConfiguration().locale.getLanguage().equals("it")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=it&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=it&act=get_cook");
                // mt4.execute("http://kshp-company.ru/z_body/1_.php?la=de&act=get_spo");
            }
            else if (getResources().getConfiguration().locale.getLanguage().equals("zh")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=cn&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=cn&act=get_cook");
              //  mt4.execute("http://kshp-company.ru/z_body/1_.php?la=cn&act=get_spo");
            }
            else if (getResources().getConfiguration().locale.getLanguage().equals("ar")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=r&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=r&act=get_cook");
                // mt4.execute("http://kshp-company.ru/z_body/1_.php?la=de&act=get_spo");
            }
            else if (getResources().getConfiguration().locale.getLanguage().equals("de")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=de&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=de&act=get_cook");
               // mt4.execute("http://kshp-company.ru/z_body/1_.php?la=de&act=get_spo");
            }
            else if (getResources().getConfiguration().locale.getLanguage().equals("ja")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=ja&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=ja&act=get_cook");
              //  mt4.execute("http://kshp-company.ru/z_body/1_.php?la=ko&act=get_spo");
            }
            else if (getResources().getConfiguration().locale.getLanguage().equals("ko")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=ko&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=ko&act=get_cook");
                //  mt4.execute("http://kshp-company.ru/z_body/1_.php?la=ko&act=get_spo");
            }
            else if (getResources().getConfiguration().locale.getLanguage().equals("es")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=es&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=es&act=get_cook");
                //  mt4.execute("http://kshp-company.ru/z_body/1_.php?la=ko&act=get_spo");
            }
            else if (getResources().getConfiguration().locale.getLanguage().equals("pt")) {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=po&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=po&act=get_cook");
                //  mt4.execute("http://kshp-company.ru/z_body/1_.php?la=ko&act=get_spo");
            }
            else
            {
                mt.execute("http://kshp-company.ru/z_diet/1_.php?la=en&act=get_e_food");
                mt1.execute("http://kshp-company.ru/z_diet/1_.php?la=en&act=get_cook");
              //  mt4.execute("http://kshp-company.ru/z_body/1_.php?la=en&act=get_spo");
            }
          /*  sPref = getPreferences(MODE_PRIVATE);
            String r=sPref.getString(SHARED_RE, "");
            if (r.equals("")) {} else {
                Upload_G uf_g=new Upload_G(r,this,"","" , SHARED_URL);
                uf_g.start();
                SharedPreferences.Editor ed = sPref.edit();

                //name=text;
                String re="";
                //launch++;
                ed.putString(SHARED_RE,re );
                ed.commit();}
         /*   Load1 mt = new Load1(this);
            mt.execute("http://kshp-company.ru/z_diet/1_.php?act=get_e_food");
            Load2 mt1 = new Load2(this);
            mt1.execute("http://kshp-company.ru/z_diet/1_.php?act=get_cook");
        */} else {
          //  Toast.makeText(getApplicationContext(), getString(R.string.show1), Toast.LENGTH_LONG).show();
        }
        ringProgressDialog.dismiss();
       // showlist();
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();


        //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        // fdne.newInstance(curdate, "", "");
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        ftrans.replace(R.id.main_c, fmain);

      //  ftrans.addToBackStack(null);
        ftrans.commit();
    }
    boolean Check ()
    {
        //Context ctx=delegate;
        ConnectivityManager conMgr = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;
    }
    @Override
    public void DneEdit (String dat)
    {
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
        fmore.newInstance(dat, "", "");
        //    ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        ftrans.replace(R.id.main_c, fmore);
        ftrans.addToBackStack(null);
        ftrans.commit();
    }
    @Override
    public void MainA (int a,Long id)
    {
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();

       if (a==1) {
            fitem.newInstance(id, "", "");
            //    ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, fitem);
        }
        else
        {
            //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);

            ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
            ftrans.replace(R.id.main_c, fedit);
        }
        ftrans.addToBackStack(null);
        ftrans.commit();
    }
    @Override
    public void ItemFinish (Long id)
    {
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
        fblud.newInstance(id, "", "");
        //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        //ftrans.set

        ftrans.replace(R.id.main_c, fblud);
        ftrans.addToBackStack(null);
        ftrans.commit();
    }
    @Override
    public void EditFinish(int le,int tal,int ro,int w,int d,int m) {
        // Log.d("m__", s);
        //Raschet ras=new Raschet(1,0,80,ctx);
        Raschet ras=new Raschet(le,tal,ro,m,d,w,ctx);
        ArrayList<Result> res=new ArrayList<Result>();
        res = ras.Run();
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
        fresult.newInstance(res, "", "");
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        //ftrans.set

        ftrans.replace(R.id.main_c, fresult);
        ftrans.addToBackStack(null);
        ftrans.commit();
    }
    @Override
    public void BludFinish (Long id)
    {

        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
        fblu.newInstance(id, "", "");
        //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        //ftrans.set

        ftrans.replace(R.id.main_c, fblu);
        ftrans.addToBackStack(null);
        ftrans.commit();
    }
    @Override
    public void ResFinish (Long id)
    {
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
        fblud.newInstance(id, "", "");
        //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        //ftrans.set

        ftrans.replace(R.id.main_c, fblud);
        ftrans.addToBackStack(null);
        ftrans.commit();
    }
    @Override
    public void GraEdit ()
    {
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();


        //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        ftrans.replace(R.id.main_c, fegr);

        ftrans.addToBackStack(null);
        ftrans.commit();
    }
    @Override
    public void DnaEdit (String curdate)
    {
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();


        //ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fdne1.newInstance(curdate, "", "");
        ftrans.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit,R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        ftrans.replace(R.id.main_c, fdne1);

        ftrans.addToBackStack(null);
        ftrans.commit();
    }
}
