package com.example.instagramclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
    public Adapter(List<ModuleClass> moduleClassList) {
        this.moduleClassList = moduleClassList;
    }

    private List<ModuleClass> moduleClassList;

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        int userImage=moduleClassList.get(position).getUserProfilePic();
        String userName=moduleClassList.get(position).getUserName();
        int itemUser=moduleClassList.get(position).getUserUploadedItem();
        holder.setitem(userImage,userName,itemUser);

    }

    @Override
    public int getItemCount() {
        return moduleClassList.size();
    }

    //Viewholder class to set data on home page
    class Viewholder extends RecyclerView.ViewHolder
    {
        ImageView userProfilePic;
        TextView userName;
        ImageView userUploadedItem;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            userProfilePic=(ImageView) itemView.findViewById(R.id.userProfilePic);
            userName=(TextView) itemView.findViewById(R.id.userName);
            userUploadedItem=(ImageView) itemView.findViewById(R.id.userUploadedItem);
        }

        private void setitem(int userPic,String userName1, int userUploadedItem1)
        {
            userProfilePic.setImageResource(userPic);
            userName.setText(userName1);
            userUploadedItem.setImageResource(userUploadedItem1);
        }
    }




}
