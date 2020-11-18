package com.example.tyitproject2020.SplashScreen;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.loader.content.AsyncTaskLoader;

import com.example.tyitproject2020.HomePage.HomePageIndex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.spec.ECField;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class AsynTaskLogin extends AsyncTask<URL,Integer,String> {
    String UID;
    String Password;
    Context applicationContext;
    private static String urlRequest;
    Handler handler;

    //Constructor
    public AsynTaskLogin(String UID, String Password, Context applicationContext){
         this.UID = UID;
         this.Password = Password;
         this.applicationContext = applicationContext;
         handler = new Handler(applicationContext.getMainLooper());
         urlRequest = "http://192.168.0.27:8080/AndroidProjectTYIT/Validation?UID="+UID+"&PASS="+Password;
         Log.i("IN ASYNC CONSTRUCTOR",urlRequest);
    }

    @Override
    protected String doInBackground(URL... urls) {

        URL url = createURL(urlRequest);
        Log.i("NO NET","CHECK!");
        String response = "";
        try{
            response = makeHTTPrequest(url);

        }catch(Exception e){
            Log.i("NO NET","CHECK!");
            e.printStackTrace();
        }
        return response;
    } //do in background end here

    @Override
    protected void onPostExecute(String s) {
        if(s.equals("true")){
            Toast.makeText(applicationContext,"LOGIN SUCCESSFULL",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(applicationContext, HomePageIndex.class);
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK);  // FLAG_ACTIVITY_CLEAR_TASK : clear backstack activities maybe all.
            // FLAG_ACTIVITY_NEW_TASK  : compulsory if you want to intent from outside the activity.
            intent.putExtra("USERNAME",UID);
            applicationContext.startActivity(intent);


        }
        else if(s.equals("")) {
            //Toast.makeText(applicationContext,"FATAL ERROR , WEAK CONNECTION",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(applicationContext,"LOGIN UNSUCCESSFULL",Toast.LENGTH_SHORT).show();
        }
    }

    public URL createURL(String input_url){
        URL url = null;
        try{
            url = new URL(input_url);
        } catch(Exception e){
            e.printStackTrace();
        }
        return  url;
    }

    public String makeHTTPrequest(URL url) throws IOException {
        String localResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{
          urlConnection =  (HttpURLConnection)url.openConnection();
          urlConnection.setRequestMethod("GET");
          urlConnection.setReadTimeout(10000);
          urlConnection.setConnectTimeout(15000);
          urlConnection.connect();
          inputStream = urlConnection.getInputStream();
          localResponse = readfromStream(inputStream);

        }catch (Exception e){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(applicationContext,"Please Connect To Internet ! \nor\n Check your Connection" ,Toast.LENGTH_SHORT).show();
                }
            });
            e.printStackTrace();}
        finally{
            if(urlConnection != null){
                urlConnection.disconnect();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }
        return localResponse;
    }

    public String readfromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while(line != null){
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
}
