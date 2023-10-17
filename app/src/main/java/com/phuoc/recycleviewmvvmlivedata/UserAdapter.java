package com.phuoc.recycleviewmvvmlivedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<User> mUserList;

    public UserAdapter(List<User> mUserList) {
        this.mUserList = mUserList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mUserList.get(position);
        if (user == null) {
            return;
        }

        holder.imgAvatar.setImageResource(user.getImageAvatar());
        holder.tv_name.setText(user.getName());
        holder.tv_description.setText(user.getDescription());
    }

    @Override
    public int getItemCount() {
        if (mUserList != null)
            return mUserList.size();
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView imgAvatar;
        private TextView tv_name;
        private TextView tv_description;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
        }
    }
}
