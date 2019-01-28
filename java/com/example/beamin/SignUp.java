package com.example.beamin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private TextView id;
    private TextView pw;
    private TextView addr;
    private TextView addrDetail;
    private TextView phone;
    private TextView name;
    private TextView nickName;
    private TextView backBt;
    private TextView signUpBt;

    private HttpConnection httpConn = HttpConnection.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        id = findViewById(R.id.idSignUp);
        pw = findViewById(R.id.pwSignUp);
        addr = findViewById(R.id.addrSignUp);
        addrDetail = findViewById(R.id.addrDetSignUp);
        phone = findViewById(R.id.phoneSignUp);
        name = findViewById(R.id.nameSignUp);
        nickName = findViewById(R.id.nickNameSignUp);
        backBt = findViewById(R.id.backSignUp);
        signUpBt = findViewById(R.id.btSignUp);

        backBt.setOnClickListener(this);
        signUpBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backSignUp){
            finish();
        }
        else if(v.getId() == R.id.btSignUp){
            sendData();
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