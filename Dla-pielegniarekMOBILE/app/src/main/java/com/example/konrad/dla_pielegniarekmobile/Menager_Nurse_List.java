package com.example.konrad.dla_pielegniarekmobile;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.protocol.HttpService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Wykaz Harmonogramow dla pielegniarek
 * Made by VallenRod
 *
 */
public class Menager_Nurse_List extends AppCompatActivity {
    ListView MenagerListView;
    ProgressBar progressBarSubject;
    String ServerURL ="http://127.0.0.1/project_grupowy/FromHelp.php";
    EditText editText ;
    List<String> listString = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menager__nurse__list);
        MenagerListView =(ListView)findViewById(R.id.lisview1);
        progressBarSubject = (ProgressBar)findViewById(R.id.progressBar);
        editText = (EditText)findViewById(R.id.edittext1);
        new GetHttpResponse(this).execute();
        //wyszukiwanie po peselu pacjenta
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Menager_Nurse_List.this.arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private class GetHttpResponse extends AsyncTask<Void,Void,Void>
    {
        public Context context;
        String ResultHolder;
        List<menager> listaHarmonogramow;
        List<user_pesel> lista_userow;

        public GetHttpResponse(Context context)
        {
            this.context = context;
        }
        protected  void onPreExecute()
        {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            HtttpServiceClass httpServiceObject = new HtttpServiceClass(ServerURL);
            try
            {
                httpServiceObject.ExecutePostRequest();
                if(httpServiceObject.getResponseCode() == 200)
                {
                    ResultHolder = httpServiceObject.getResponse();
                    if(ResultHolder != null)
                    {
                        JSONArray jsonArray = null;
                        try
                        {
                            jsonArray= new JSONArray(ResultHolder);
                            JSONObject jsonObject;
                            //menager menagers;
                            user_pesel user;
                            //listaHarmonogramow = new ArrayList<menager>();
                            lista_userow = new ArrayList<user_pesel>();
                            for(int i = 0; i< jsonArray.length();i++)
                            {

                                user = new user_pesel();
                                jsonObject = jsonArray.getJSONObject(i);
                                user.PESEL_User = jsonObject.getInt("user_pesel");

                                lista_userow.add(user);


                            }


                        }
                        catch(JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }

                }
                else
                {
                    Toast.makeText(context,httpServiceObject.getErrorMessage(),Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Void result)
        {
            progressBarSubject.setVisibility(View.GONE);
            MenagerListView.setVisibility(View.VISIBLE);
            if(listaHarmonogramow != null)
            {
                ListAdapter adapter = new ListAdapter(listaHarmonogramow,context);
                MenagerListView.setAdapter(adapter);
            }
            else {
            Toast.makeText(Menager_Nurse_List.this,"blad",Toast.LENGTH_LONG).show();
            }
        }
    }
}
