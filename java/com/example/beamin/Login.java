package com.example.beamin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText id;
    private EditText pw;
    private TextView signUpBt;
    private Button loginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = findViewById(R.id.idLogin);
        pw = findViewById(R.id.pwLogin);
        signUpBt = findViewById(R.id.signUpBtLogin);
        loginBt = findViewById(R.id.btLogin);

        loginBt.setOnClickListener(this);
        signUpBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btLogin){
        }
        else if(v.getId() == R.id.signUpBtLogin){
            Intent intent = new Intent(this,SignUp.class);
            startActivity(intent);
        }
    }
}