package com.example.projectclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class LoginActivity extends AppCompatActivity {

    EditText edUser, edPass;
    TextView edLognfor;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        edLognfor = findViewById(R.id.edlognfor);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });

        if (checkLogin()){
            goToMain();
        }
    }
    private void onLogin(){
        saveStateLogin();
        goToMain();
    }

    private void goToMain(){
        Intent shipper = new Intent(this, MainActivity.class);
        startActivity(shipper);
        finish();
    }

    private boolean checkLogin(){
        SharedPreferences setting = getSharedPreferences("SS8", MODE_PRIVATE);
        String username = setting.getString("username", null);
        if (username != null){
            return true;
        }
        return false;
    }

    private void saveStateLogin(){
        SharedPreferences setting = getSharedPreferences("SS8", MODE_PRIVATE);
        SharedPreferences.Editor editor = setting.edit();
        editor.putString("username", edUser.getText().toString());
        editor.putString("password", edPass.getText().toString());
        editor.commit();
    }
}