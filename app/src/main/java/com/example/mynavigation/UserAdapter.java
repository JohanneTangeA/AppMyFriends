package com.example.mynavigation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mynavigation.Model.Friend;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>  {

    private List<Friend> mUsers;
    final private OnListItemClickListener mOnListItemClickListener;

    public UserAdapter(List<Friend> users, OnListItemClickListener listener){
        mUsers = users;
        mOnListItemClickListener = listener;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.name.setText(mUsers.get(position).getName());
        //viewHolder.icon.setImageResource(mUsers.get(position).getIconId());
        viewHolder.desc.setText(mUsers.get(position).getDescription());
        //viewHolder.numb.setText(mUsers.get(position).getNumb());

    }

    public int getItemCount() {
        return mUsers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView icon;
        TextView desc;
        TextView numb;



        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon);
            desc = itemView.findViewById(R.id.tv_desc);
            numb = itemView.findViewById(R.id.tv_numb);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(mUsers.get(getAdapterPosition()));
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(Friend user);
    }

}