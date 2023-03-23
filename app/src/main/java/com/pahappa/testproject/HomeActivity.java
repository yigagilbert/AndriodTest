package com.pahappa.testproject;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pahappa.testproject.util.ApiUtils;

public class HomeActivity extends AppCompatActivity {

    EditText edcityName;
    Button btnSubmit;
    TextView tvResult;
    TextView state;
    TextView year;
    TextView id;
    String cityName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edcityName = findViewById(R.id.city_name_et);
        btnSubmit = findViewById(R.id.submit_btn);
        tvResult = findViewById(R.id.result);
        state = findViewById(R.id.state);
        year = findViewById(R.id.Idyear);
        id = findViewById(R.id.Idstate);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.submit_btn) {
                    cityName = edcityName.getText().toString();

                    try {
                        queryData(cityName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        TextView greetings = (TextView) findViewById(R.id.greetings);
        String name = getIntent().getStringExtra("username");
        greetings.setText("Hey " + name);

    }

    private void queryData(String cityName) throws IOException{
        URL url = ApiUtils.buildUrl();
        new DataTask().execute(url);
    }


    public class DataTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];
            String data = null;
            try {
                data = ApiUtils.getDatafromHttpUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            setcityData(s);
        }

        public void setcityData(String data) {
            JSONObject myObject = null;
            try {
                myObject = new JSONObject(data);
                JSONArray citya = myObject.getJSONArray("data");
                for (int i = 0; i < citya.length(); i++) {
                    JSONObject cityo = citya.getJSONObject(i);
                    String cityn = cityo.get("State").toString();
                    Log.d("adApi", cityn);
                    Log.d("TextCityName", "cityName");
                    if (cityn.equals(cityName)) {
                        String cityp = cityo.get("Population").toString();
                        tvResult.setText("State Population: "+cityp);
                        state.setText("State Name: "+cityo.get("State").toString());
                        year.setText("Year: "+cityo.get("Year").toString());
                        id.setText("State ID: "+cityo.get("ID State").toString());
                        break;
                    } else {
                        tvResult.setText(cityName + "Not Found");

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}