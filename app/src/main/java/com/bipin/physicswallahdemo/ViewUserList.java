package com.bipin.physicswallahdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bipin.physicswallahdemo.Models.UserModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewUserList extends AppCompatActivity implements MyAdapter.ItemClickListener {


    RecyclerView recyclerView;
    List<UserModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_list);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);



        getUsers();
    }



    private void getUsers(){

        Call<List<UserModel>> call = RetrofitClient.getInstance().getMyApi().getUsers();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                List<UserModel> userList = response.body();
                String[] user = new String[userList.size()];

                for (int i = 0; i < userList.size(); i++) {
                    user[i] = userList.get(i).getName();
                    list.add(userList.get(i));
                    System.out.println("()()()"+userList.get(i).getName());
                }

                MyAdapter myAdapter = new MyAdapter(ViewUserList.this, userList, ViewUserList.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(ViewUserList.this));
                recyclerView.setAdapter(myAdapter);



    }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }


        });

//        MyAdapter myAdapter = new MyAdapter(ViewUserList.this, list, this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(ViewUserList.this));
//        recyclerView.setAdapter(myAdapter);

    }


    @Override
    public void onItemClick(UserModel userModel) {

        System.out.println(Arrays.toString(userModel.getQualification()));

        StringBuilder strsub = new StringBuilder("");
        StringBuilder strqual = new StringBuilder("");

        for (int i=0;i<userModel.getSubjects().length;i++){
            strsub.append(userModel.getSubjects()[i]+ "\n");
        }
        for (int i=0;i<userModel.getQualification().length;i++){
            strqual.append(userModel.getQualification()[i]+ "\n");
        }


        Fragment fragment = DetailFragment.newInstance(userModel.getName(),strsub.toString(),strqual.toString(),userModel.getProfileImage());
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment,"detail_fragment");
        transaction.addToBackStack(null);
        transaction.commit();


    }
}
