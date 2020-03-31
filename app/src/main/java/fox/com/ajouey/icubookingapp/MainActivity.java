package fox.com.ajouey.icubookingapp;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> hospital ,types;
    private ArrayList<Float> prices ;
    private ArrayList<String> ids = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recy);

        hospital = new ArrayList<>();
        types = new ArrayList<>();
        prices = new ArrayList<>();
        ids= new ArrayList<>();


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(hospital,types,prices,ids,this.getBaseContext());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
        BackgroundTask req = new BackgroundTask(this);

        req.execute("getRooms");
    }
    void setData(String s){
        try {
            JSONArray json = new JSONArray(s);
            for(int i=0;i < json.length();i++){
                JSONObject j =json.getJSONObject(i);
                hospital.add(j.getString("name_hospitle"));
                types.add(j.getString("room_type_name"));
                prices.add(Float.parseFloat(j.getString("price_room")));
                ids.add(j.getString("id_room"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
