package com.example.androidsummary.AsyncTask;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidsummary.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskAty extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        textView = findViewById(R.id.tvResult);
    }
    public void ayncTaskClck(View v) {
        readURL("https://www.baidu.com");
    }
    @SuppressLint("StaticFieldLeak")
    private void readURL(String url){
        new AsyncTask<String, Void, String>(){

            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                   URLConnection connection = url.openConnection();
                  InputStream inputStream = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(inputStream);
                   BufferedReader br = new BufferedReader(isr);
                   String line;
                   StringBuilder builder = new StringBuilder();
                   while ((line = br.readLine())!=null){
                       builder.append(line);
                   }
                   br.close();
                   isr.close();
                   inputStream.close();
                   return builder.toString();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                textView.setText(s);
                super.onPostExecute(s);
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        }.execute(url);
    }
}
