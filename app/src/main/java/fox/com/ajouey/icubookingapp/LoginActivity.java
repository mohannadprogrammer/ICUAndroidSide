package fox.com.ajouey.icubookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button login ;
    private Button goToRegist;
    private EditText email , password ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.enter);
        goToRegist=findViewById(R.id.new_account);

        email = (EditText) findViewById(R.id.email);
        password =(EditText )findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
//
            }
        });
        goToRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(),Registration.class);
                startActivity(intent);
            }
        });
    }
    public void login(View  view) {
        String emailtext = email.getText().toString();
        String passtext = password.getText().toString();
        if (emailtext.isEmpty()
                || passtext.isEmpty()) {
            Toast.makeText(this, "تاكد من ادخال جميع البيانات", Toast.LENGTH_SHORT).show();
            return;
        }
        BackgroundTask task = new BackgroundTask(this);

        task.execute("login"
                , emailtext
                , passtext
        );
    }
}
