package ru.jaguardesign.testnav;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by x on 20.12.2015.
 */
class Load1 extends AsyncTask<String, Void, JSONArray> {
    String m;public AsyncResponse delegate=null;
    Context ct;
    public Load1(Context c) {
        ct = c;//Assigning call back interfacethrough constructor
    }
    @Override
    protected void onPreExecute() {

       // TextView tvId = (TextView) findViewById(R.id.textView1);
        super.onPreExecute();
        //  tvInfo.setText("Begin");
    }
    boolean Check ()
    {
        //Context ctx=delegate;
        ConnectivityManager conMgr = (ConnectivityManager) ct
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
    protected JSONArray doInBackground(String... params) {
        //Context context=params[0];
        String urlStr = params[0];
        //String urlStr = "http://kshp-company.ru/about/1/1_.php?login=ttestt&pass=74b69df948800bdd602031fe25feb13b&act=get_active_tasks";
        try {

            URL url = new URL(urlStr);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //urlConnection.setDoOutput(true);
            //urlConnection.setChunkedStreamingMode(0);
            //urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(false);
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            //writer.write(getQuery(params));
            urlConnection.connect();
            writer.flush();
            writer.close();
            os.close();
            InputStream IS = urlConnection.getInputStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(IS));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            m =total.toString();
            IS.close();

            //OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            //writeStream(out);
            //out.wri

            //InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //readStream(in);

        } //finally {
        //urlConnection.disconnect();
        //}
        catch (IOException e) {
            e.printStackTrace(); }JSONArray array=null;
        if (m!="")
        {
            //Context mContext = getApplicationContext();
           // db = new DB(this);
            //db = new DB(this);
            //db.open();
         try {  // JSONObject json = new JSONObject(m);
            //JSONArray jsa = json.getJSONArray("udeals");
              array = new JSONArray(m);
             for(int i = 0; i < array.length(); i++)
             {
                 JSONObject obj = array.getJSONObject(i);

                 //now, get whatever value you need from the object:
                 String placename = obj.getString("title");
                 Log.d("m__l",  placename);
                 //or if on the MainUI thread you can set your TextView from here:
               //  yourTextView.setText(obj.getString("placename"));
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        /*DB db = new DB(context);
        db.open();
        db.upRecTasks(array);
        db.close();*/
        return array;
    }

    @Override
    protected void onPostExecute(JSONArray result) {
        //delegate.processFinish(result);
        super.onPostExecute(result);
        //
        Log.d("m__", "1");
        DB db = new DB(ct);
        db.open();
        db.upRecFood1(result);
                db.close();
        /*try {  // JSONObject json = new JSONObject(m);
            //JSONArray jsa = json.getJSONArray("udeals");
            JSONArray array = result;
            for(int i = 0; i < array.length(); i++)
            {
                JSONObject obj = array.getJSONObject(i);

                //now, get whatever value you need from the object:
                String placename = obj.getString("descp_seo");
                Log.d("m__",  placename);
                //or if on the MainUI thread you can set your TextView from here:
                //  yourTextView.setText(obj.getString("placename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

     //   Context mContext = MainActivity.this.getApplicationContext();
       // Context dd=MainActivity.ctx;
        //DB db = new DB(dd);
        //db.open();
        //db.upRecTasks(result);
//                db.close();

    //    Toast.makeText(getApplicationContext(), (String) m,
      //          Toast.LENGTH_SHORT).show();
        // tvInfo.setText("End");
        //Log.d("m__",  m);
    }
}
