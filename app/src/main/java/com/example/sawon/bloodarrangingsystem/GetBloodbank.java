package com.example.sawon.bloodarrangingsystem;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.sawon.bloodarrangingsystem.app.AppController;
import com.example.sawon.bloodarrangingsystem.utils.Ambulance;
import com.example.sawon.bloodarrangingsystem.utils.Bloodbank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.sawon.bloodarrangingsystem.R.id.lv_ambulance_list;

public class GetBloodbank extends AppCompatActivity {
    ListView listView;
    TextView heding;
    String tag_json_arry = "json_array_req";
    //String URL = "http://dalia.a0001.net/getdata.php";
    String URL = "http://192.168.0.103/MyAPI/android/bas/getbloodbank.php";
    List<Bloodbank> bankArrayList;
    JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_ambulance);

        heding=findViewById(R.id.heding);
        heding.setText("Bloodbank BD");
        listView = findViewById(lv_ambulance_list);
        bankArrayList=new ArrayList<Bloodbank>();


        //region Database Request
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response:: ", response.toString());

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject ambulancrObject = response.getJSONObject(i);
                                Log.d("Object:: ", ambulancrObject.toString());
                                Bloodbank bloodbank = new Bloodbank(Integer.parseInt(ambulancrObject.getString("id")), ambulancrObject.getString("name"), ambulancrObject.getString("contact"), ambulancrObject.getString("service_time"),  ambulancrObject.getString("address"));
                                bankArrayList.add(bloodbank);
                            }

                            Log.d("arraylist:", bankArrayList.toString());
                            //creating custom adapter object
                            BloodbankAdapter adapter = new BloodbankAdapter(bankArrayList, getApplicationContext());

                            //adding the adapter to listview
                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("Error json array parse", "Json" + e);
                        }
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                pDialog.hide();
            }
        });
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
        //endregion

    }

}
