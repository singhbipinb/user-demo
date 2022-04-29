package com.bipin.physicswallahdemo;

import com.bipin.physicswallahdemo.Models.UserModel;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    String BASE_URL = "https://my-json-server.typicode.com/";
    @GET("easygautam/data/users")
    Call<List<UserModel>> getUsers();


}
