package com.example.beamin;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpConnection {

    private OkHttpClient client;
    private static HttpConnection instance = new HttpConnection();
    public static HttpConnection getInstance() {
        return instance;
    }

    public HttpConnection(){ this.client = new OkHttpClient(); }
/*
    userId
            userPw
    userName
            userNickname
    userPhoneNumber
            userAddress
    userDetailAddress
    */
    public void requestSignUp(String id, String pw, String name, String nickName, String phone, String addr, String detailAddr,Callback callback){
        RequestBody body = new FormBody.Builder()
                .add("userId",id)
                .add("userPw",pw)
                .add("userName",name)
                .add("userNickname",nickName)
                .add("userPhoneNumber",phone)
                .add("userAddress",addr)
                .add("userDetailAddress",detailAddr)
                .build();

        Request request = new Request.Builder()
                .url("http://bucoco.kr/users")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
//통신을 위한 Connection