package com.bipin.physicswallahdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bipin.physicswallahdemo.Models.UserModel;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<UserModel> data;
    ItemClickListener clickListener;

    public MyAdapter(Context ctx, List<UserModel> dataList, ItemClickListener clickListener){

    this.context=ctx;
        this.data = dataList;
        this.clickListener = clickListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.nameView.setText(data.get(position).getName());
        holder.subjectView.setText(data.get(position).getSubjects()[0]);
        holder.qualificationView.setText(data.get(position).getQualification()[0]);
        Glide.with(context)
                .load(data.get(position).getProfileImage())
                .into(holder.profilePic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickListener.onItemClick(data.get(position));


            }
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameView, subjectView, qualificationView;
        ImageView profilePic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.name);
            subjectView = (TextView) itemView.findViewById(R.id.subject);
            qualificationView = (TextView) itemView.findViewById(R.id.qualification);
            profilePic = (ImageView) itemView.findViewById(R.id.profilePic);
        }
    }

    public interface ItemClickListener {

        public void onItemClick(UserModel userModel);
    }

}
