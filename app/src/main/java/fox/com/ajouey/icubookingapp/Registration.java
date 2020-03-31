package fox.com.ajouey.icubookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    private EditText name , nationl_num_user , pass , passConf,email ,phone_number ,address;
    private Button registButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name=(EditText)findViewById(R.id.name);
        nationl_num_user=(EditText)findViewById(R.id.nationl_num_user);
        pass=(EditText)findViewById(R.id.pass);
        passConf=(EditText)findViewById(R.id.pass_conf);
        email=(EditText)findViewById(R.id.email);
        phone_number=(EditText)findViewById(R.id.phone_number);
        address=(EditText)findViewById(R.id.address);
        String data = "[{\"item_id\":\"56\",\"item_name\":\"\\u064b\\u064b\\u064b\\u0647\\u062a\\u0646\",\"item_details\":\"\\u062a\\u062a\\u062a\\u062a\",\"item_place\":\"\\u0648\\u0648\\u0648\\u0648\",\"item_state\":\"\\u0639\\u062b\\u0631 \\u0639\\u0644\\u064a\\u0647\",\"user_name\":\"43987\",\"user_phone\":\"96643987\",\"real_date\":\"2019-05-20 \",\"long_date\":\"20190520150034368\",\"image_url\":\"20190520150034368.jpeg\",\"is_deleted\":\"0\"},{\"item_id\":\"55\",\"item_name\":\"\\u0646\\u0637\\u0646\\u0637\\u0646\\u064a\\u062a\",\"item_details\":\"\\u0631\\u064a\\u0631\\u064a\\u064a\\u0648\\u0648\",\"item_place\":\"\\u0631\\u064a\\u0631\\u064a\\u064a\\u0631\\u064a\\u0631\",\"item_state\":\"\\u0639\\u062b\\u0631 \\u0639\\u0644\\u064a\\u0647\",\"user_name\":\"43987\",\"user_phone\":\"96643987\",\"real_date\":\"2019-05-15 \",\"long_date\":\"20190515003512224\",\"image_url\":\"20190515003512224.jpeg\",\"is_deleted\":\"0\"},{\"item_id\":\"7\",\"item_name\":\"\\u0645\\u0641\\u062a\\u0627\\u062d \\u0633\\u064a\\u0627\\u0631\\u0629\",\"item_details\":\"\\u0645\\u0641\\u062a\\u0627\\u062d \\u062a\\u0627\\u064a\\u0648\\u062a\\u0627\",\"item_place\":\"\\u062c\\u0627\\u0645\\u0639\\u0629 \\u0627\\u0644\\u0642\\u0635\\u064a\\u0645 \\/ \\u0627\\u0644\\u0645\\u062f\\u062e\\u0644 \\u0627\\u0644\\u0631\\u0626\\u064a\\u0633\\u064a \\u0644\\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u0637\\u0628\",\"item_state\":\"\\u0639\\u062b\\u0631 \\u0639\\u0644\\u064a\\u0647\",\"user_name\":\"\\u0641\\u0647\\u062f \\u0627\\u0644\\u062f\\u0628\\u064a\\u0627\\u0646\",\"user_phone\":\"966592243987\",\"real_date\":\"2018-09-21 \",\"long_date\":\"20180921180446738\",\"image_url\":\"20180921180446738.jpeg\",\"is_deleted\":\"0\"},{\"item_id\":\"6\",\"item_name\":\"\\u064a\\u0648 \\u0627\\u0633 \\u0628\\u064a\",\"item_details\":\"\\u0628\\u062f\\u0648\\u0646 \\u0648\\u0635\\u0641\",\"item_place\":\"\\u062c\\u0627\\u0645\\u0639\\u0629 \\u0627\\u0644\\u0642\\u0635\\u064a\\u0645 \\/ \\u0645\\u0639\\u0645\\u0644 \\u0627\\u0644\\u062d\\u0627\\u0633\\u0628 \\u0641\\u064a \\u0643\\u0644\\u064a\\u0629 \\u0627\\u0644\\u0639\\u0644\\u0648\\u0645\",\"item_state\":\"\\u0639\\u062b\\u0631 \\u0639\\u0644\\u064a\\u0647\",\"user_name\":\"\\u0641\\u0647\\u062f \\u0627\\u0644\\u062f\\u0628\\u064a\\u0627\\u0646\",\"user_phone\":\"966592243987\",\"real_date\":\"2018-09-21 \",\"long_date\":\"20180921180316312\",\"image_url\":\"20180921180316312.jpeg\",\"is_deleted\":\"0\"},{\"item_id\":\"5\",\"item_name\":\"\\u0628\\u0637\\u0627\\u0642\\u0629 \\u0627\\u062d\\u0648\\u0627\\u0644\",\"item_details\":\"\\u0628\\u0627\\u0633\\u0645 \\u0641\\u0647\\u062f \\u0639\\u0628\\u062f\\u0627\\u0644\\u0639\\u0632\\u064a\\u0632\",\"item_place\":\"\\u062c\\u0627\\u0645\\u0639\\u0629 \\u0627\\u0644\\u0642\\u0635\\u064a\\u0645 \",\"item_state\":\"\\u0645\\u0641\\u0642\\u0648\\u062f\",\"user_name\":\"\\u0641\\u0647\\u062f \\u0627\\u0644\\u062f\\u0628\\u064a\\u0627\\u0646\",\"user_phone\":\"966592243987\",\"real_date\":\"2018-09-21 \",\"long_date\":\"20180921180040700\",\"image_url\":\"20180921180040700.jpeg\",\"is_deleted\":\"0\"},{\"item_id\":\"4\",\"item_name\":\"\\u0646\\u0638\\u0627\\u0631\\u0629 \\u0634\\u0645\\u0633\\u064a\\u0629\",\"item_details\":\"\\u0628\\u062f\\u0648\\u0646 \\u0648\\u0635\\u0641 \",\"item_place\":\"\\u062c\\u0627\\u0645\\u0639\\u0629 \\u0627\\u0644\\u0642\\u0635\\u064a\\u0645 \\/ \\u0627\\u0644\\u0628\\u0647\\u0648 \\/ \\u0627\\u0644\\u0645\\u0633\\u062c\\u062f\",\"item_state\":\"\\u0639\\u062b\\u0631 \\u0639\\u0644\\u064a\\u0647\",\"user_name\":\"\\u0641\\u0647\\u062f \\u0627\\u0644\\u062f\\u0628\\u064a\\u0627\\u0646\",\"user_phone\":\"966592243987\",\"real_date\":\"2018-09-21 \",\"long_date\":\"20180921175941672\",\"image_url\":\"20180921175941672.jpeg\",\"is_deleted\":\"0\"},{\"item_id\":\"3\",\"item_name\":\"\\u062c\\u0648\\u0627\\u0644 \\u0633\\u0627\\u0645\\u0633\\u0648\\u0646\\u0642\",\"item_details\":\"\\u062c\\u0648\\u0627\\u0644 \\u0633\\u0627\\u0645\\u0633\\u0648\\u0646\\u0642 6 s \\u0644\\u0648\\u0646 \\u0630\\u0647\\u0628\\u064a\",\"item_place\":\"\\u062c\\u0627\\u0645\\u0639\\u0629 \\u0627\\u0644\\u0642\\u0635\\u064a\\u0645 \\/ \\u0643\\u0644\\u064a\\u0627\\u062a \\u0627\\u0644\\u0628\\u0646\\u0627\\u062a\",\"item_state\":\"\\u0645\\u0641\\u0642\\u0648\\u062f\",\"user_name\":\"\\u0641\\u0647\\u062f \\u0627\\u0644\\u062f\\u0628\\u064a\\u0627\\u0646\",\"user_phone\":\"966592243987\",\"real_date\":\"2018-09-21 \",\"long_date\":\"20180921175835865\",\"image_url\":\"20180921175835865.jpeg\",\"is_deleted\":\"0\"},{\"item_id\":\"2\",\"item_name\":\"\\u0631\\u062e\\u0635\\u0629 \\u0642\\u064a\\u0627\\u062f\\u0629\",\"item_details\":\"\\u0631\\u062e\\u0635\\u0629 \\u0628\\u0627\\u0633\\u0645 \\u0641\\u0647\\u062f \\u0628\\u0646 \\u0639\\u0628\\u062f\\u0627\\u0644\\u0639\\u0632\\u064a\\u0632\",\"item_place\":\"\\u062c\\u0627\\u0645\\u0639\\u0629 \\u0627\\u0644\\u0642\\u0635\\u064a\\u0645 \\/ \\u0645\\u0648\\u0627\\u0642\\u0641 \\u0627\\u0644\\u062c\\u0627\\u0645\\u0639\\u0629\",\"item_state\":\"\\u0639\\u062b\\u0631 \\u0639\\u0644\\u064a\\u0647\",\"user_name\":\"\\u0641\\u0647\\u062f \\u0627\\u0644\\u062f\\u0628\\u064a\\u0627\\u0646\",\"user_phone\":\"966592243987\",\"real_date\":\"2018-09-21 \",\"long_date\":\"20180921175715977\",\"image_url\":\"20180921175715977.jpeg\",\"is_deleted\":\"0\"},{\"item_id\":\"1\",\"item_name\":\"\\u0648\\u0635\\u0644\\u0629 \\u0634\\u0627\\u062d\\u0646\",\"item_details\":\"\\u0648\\u0635\\u0644\\u0629 \\u0634\\u0627\\u062d\\u0646 \\u062a\\u0627\\u064a\\u0628 \\u0633\\u064a\",\"item_place\":\"\\u062c\\u0627\\u0645\\u0639\\u0629 \\u0627\\u0644\\u0642\\u0635\\u064a\\u0645 \\/ \\u0642\\u0633\\u0645 \\u0627\\u0644\\u0645\\u062e\\u062a\\u0628\\u0631\\u0627\\u062a\",\"item_state\":\"\\u0639\\u062b\\u0631 \\u0639\\u0644\\u064a\\u0647\",\"user_name\":\"\\u0641\\u0647\\u062f \\u0627\\u0644\\u062f\\u0628\\u064a\\u0627\\u0646\",\"user_phone\":\"966592243987\",\"real_date\":\"2018-09-21 \",\"long_date\":\"20180921175610585\",\"image_url\":\"20180921175610585.jpeg\",\"is_deleted\":\"0\"}]";
//        madapter.setData(data);

//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.e("dataIsd",response.toString());
//
//                            madapter.setData(response.toString());
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//        });


    }
    public void regist(View view){

        String nametext = name.getText().toString();
        String nationl_num_usertext =nationl_num_user.getText().toString();
        String passtext = pass.getText().toString();
        String passConftext=passConf.getText().toString();
        String emailtext =email.getText().toString();
        String phone_numbertext =phone_number.getText().toString();
        String addresstext =address.getText().toString();
        if (nametext.isEmpty() || nationl_num_usertext.isEmpty()
                ||passtext.isEmpty()
                ||passConftext.isEmpty()
                ||emailtext.isEmpty()
                ||phone_numbertext.isEmpty()
                || addresstext.isEmpty()){
            Toast.makeText(this, "تاكد من ادخال جميع البيانات", Toast.LENGTH_SHORT).show();
            return;
        }
        if(passtext.equals(passConftext)){

            BackgroundTask task =new BackgroundTask(this);

            task.execute("regist"
                    ,nametext
                    ,emailtext
                    ,phone_numbertext
                    ,addresstext
                    ,nationl_num_usertext
                    ,passtext
            );
        }else{
            Toast.makeText(this, "كلمة السر غير متطابقة ", Toast.LENGTH_SHORT).show();
        }
    }
}
