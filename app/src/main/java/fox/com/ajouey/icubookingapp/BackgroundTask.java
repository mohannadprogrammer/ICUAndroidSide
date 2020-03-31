package fox.com.ajouey.icubookingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;


public class BackgroundTask extends AsyncTask<String,Void,String> {
    String path ="http://192.168.43.2/hos/api";
    Context context;
    MainActivity main;

    public BackgroundTask (Context context){
        this.context=context;
    }
    public BackgroundTask (MainActivity main){
        this.main=main;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();

    }
    @Override
    protected String doInBackground(String... params) {
        String method =params[0];

        if(method.equals("regist")){
            String name = params[1];
            String email_user = params[2];
            String phone_user = params[3];
            String address_user = params[4];
            String nationl_num_user = params[5];
            String password_user = params[6];

            HashMap<String,String> data = new HashMap<>();
            data.put("name_user",name);
            data.put("email_user",email_user);
            data.put("phone_user",phone_user);
            data.put("address_user",address_user);
            data.put("nationl_num_user",nationl_num_user);
            data.put("password_user",password_user);

            RequestHandler requestHandler = new RequestHandler();
            String res = requestHandler.sendPostRequest(this.path+"/Regstrion.php",data);
//
            Intent intent = new Intent (this.context,LoginActivity.class);
            this.context.startActivity(intent);
            return "تم التسجيل بنجاح يرجى تسجيل الدخول للاستفادة من الخدمة";
        }
        if (method.equals("login")){
            String email = params[1];
            String pass = params[2];

            HashMap<String,String> data = new HashMap<>();
            data.put("email",email);
            data.put("pass",pass);
            RequestHandler requestHandler = new RequestHandler();
            String res = requestHandler.sendPostRequest(this.path+"/login.php",data);
            try {
                JSONArray arrayjson = new JSONArray(res);
                JSONObject resp = arrayjson.getJSONObject(0).getJSONObject("data");
                SharedPreferences.Editor editor = context.getSharedPreferences("save", MODE_PRIVATE).edit();
                String id = resp.getString("id_user");
                editor.putString("userID",id);

                editor.apply();
                Intent intent = new Intent (context,MainActivity.class);
                this.context.startActivity(intent);
                return "تمت العملية";
            } catch (JSONException e) {
                e.printStackTrace();
                return "حاول مرة اخرى";
            }
//            return  res;


        }
        if (method.equals("getRooms")){
            RequestHandler requestHandler = new RequestHandler();
            String res = requestHandler.sendGetRequest(this.path+"/get_all_rooms.php");
            if(main!=null)
                main.setData(res);

            return null;
        }
        if(method.equals("booking")){
            String username = params[1];
            String id = params[2];

            HashMap<String,String> data = new HashMap<>();
            data.put("booking_user_id",username);
            data.put("booking_room_id",id);
            RequestHandler requestHandler = new RequestHandler();
            String res = requestHandler.sendPostRequest(this.path+"/booking_room.php",data);
            return res;
        }
        return "not is happen";
    }
    @Override
    protected  void  onProgressUpdate(Void... prams){
        super.onProgressUpdate(prams);
    }
    @Override
    protected void onPostExecute(String result){
        if(result!=null)
            Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
    }
}
