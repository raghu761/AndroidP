package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText city;
    TextView result;
    //https://api.openweathermap.org/data/2.5/weather?q=Mysore&appid=a3533dfb79204fc27c6b14ae98c62759

    String BaseURL="https://api.openweathermap.org/data/2.5/weather?q=";
    String API="&appid=a3533dfb79204fc27c6b14ae98c62759";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        city=findViewById(R.id.editText);
        result=findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myURL=BaseURL+city.getText().toString()+API;
                final JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, myURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {


                       try {
                           String info=jsonObject.getString("weather");
                           JSONArray array=new JSONArray(info);

                         for(int i=0;i<1;i++) {
                               JSONObject  parobj=array.getJSONObject(i);

                               String myWeather=parobj.getString("main");
                               result.setText((myWeather));
                          }

                       }

                       catch (JSONException e)
                       {
                           e.printStackTrace();
                       }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });

                    MySingleton.getInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);
            }
        });


    }
}
