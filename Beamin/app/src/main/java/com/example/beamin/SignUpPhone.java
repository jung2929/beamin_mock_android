package com.example.beamin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class SignUpPhone extends AppCompatActivity implements View.OnClickListener {
    private TextView backView;
    private EditText phoneEdit;
    private Button certBt;
    private EditText cerNum;

    private HttpConnection httpConn = HttpConnection.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_phone);

        backView = findViewById(R.id.backSignUpPhone);
        phoneEdit = findViewById(R.id.phoneSignUp);
        certBt = findViewById(R.id.certBtSignup);
        cerNum = findViewById(R.id.certNumSignup);

        backView.setOnClickListener(this);
        certBt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backSignUpPhone){

        }
        else if(v.getId() == R.id.certBtSignup){

        }
    }

    private void sendData() {
        Log.i("asdfwefi",id.getText().toString()+" "+pw.getText().toString()+" "+name.getText().toString()+" "+nickName.getText().toString()+" "+phone.getText().toString()
                +" "+addr.getText().toString()+" "+addrDetail.getText().toString());
        new Thread() {
            public void run() {
                httpConn.requestSignUp(id.getText().toString(),pw.getText().toString(),name.getText().toString(),nickName.getText().toString(),phone.getText().toString()
                        ,addr.getText().toString(),addrDetail.getText().toString(),callback);
            }
        }.start();
    }

    private final Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.d("Error", "콜백오류:"+e.getMessage());
        }
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String body = response.body().string();
            Log.d("TestSignUp", "서버에서 응답한 Body:"+body);
        }
    };


}