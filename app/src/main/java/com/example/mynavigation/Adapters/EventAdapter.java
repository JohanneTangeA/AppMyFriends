package com.example.mynavigation.Adapters;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mynavigation.Model.Event;
import com.example.mynavigation.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<Event> mEvents;
    private EventAdapter.OnListItemClickListener mOnListItemClickListener;

    public EventAdapter(ArrayList<Event> events, EventAdapter.OnListItemClickListener listener) {
        mEvents = events;
        mOnListItemClickListener = listener;
    }

    public EventAdapter(ArrayList<Event> mEvents) {
        this.mEvents = mEvents;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.eventview, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder viewHolder, int position) {
        viewHolder.title.setText(mEvents.get(position).getTitle());
        viewHolder.descriptionE.setText(mEvents.get(position).getEventDescription());
        viewHolder.imageView.setImageResource(mEvents.get(position).getImage());
    }

    public int getItemCount() {
        return mEvents.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView descriptionE;
        ImageView imageView;


        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_events);
            descriptionE = itemView.findViewById(R.id.short_description);
            imageView = itemView.findViewById(R.id.imageEvent);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int position);
    }
}