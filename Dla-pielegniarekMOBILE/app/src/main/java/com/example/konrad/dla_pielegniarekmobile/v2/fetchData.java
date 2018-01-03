package com.example.konrad.dla_pielegniarekmobile.v2;

import android.os.AsyncTask;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Konrad on 2018-01-02.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data ="" ;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //url polaczenia z php
            URL url = new URL("http://localhost/project_grupowy/FromHelp.php");

            HttpURLConnection httpurlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputstream = httpurlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
            String line = "";
            while(line != null)
            {
                line = bufferedReader.readLine();
                data = data + line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Nurse_List.text1.setText(this.data);
    }
}
