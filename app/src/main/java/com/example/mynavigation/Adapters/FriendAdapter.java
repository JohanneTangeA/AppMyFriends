package com.example.mynavigation.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mynavigation.Model.Friend;
import com.example.mynavigation.R;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>  {

    private List<Friend> mFriends;
    final private OnListItemClickListener mOnListItemClickListener;

    public FriendAdapter(List<Friend> friends, OnListItemClickListener listener){
        mFriends = friends;
        mOnListItemClickListener = listener;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.name.setText(mFriends.get(position).getName());
        viewHolder.age.setText(mFriends.get(position).getAge());
        viewHolder.desc.setText(mFriends.get(position).getDescription());
        viewHolder.phone.setText(mFriends.get(position).getPhone());

    }

    public int getItemCount() {
        return mFriends.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView age;
        TextView phone;
        TextView desc;



        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            desc = itemView.findViewById(R.id.tv_desc);
            age = itemView.findViewById(R.id.tv_age);
            phone = itemView.findViewById(R.id.tv_phone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(mFriends.get(getAdapterPosition()));
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(Friend friend);
    }

}