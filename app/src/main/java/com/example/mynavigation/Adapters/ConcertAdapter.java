package com.example.mynavigation.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynavigation.Model.Concert;
import com.example.mynavigation.R;

import java.util.ArrayList;

public class ConcertAdapter extends RecyclerView.Adapter<ConcertAdapter.ViewHolder> {

    private ArrayList<Concert> mConcerts;
    private ConcertAdapter.OnListItemClickListener mOnListItemClickListener;

    public ConcertAdapter(ArrayList<Concert> concerts, ConcertAdapter.OnListItemClickListener listener) {
        mConcerts = concerts;
        mOnListItemClickListener = listener;
    }

    public ConcertAdapter(ArrayList<Concert> mConcerts) {
        this.mConcerts = mConcerts;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.concertview, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ConcertAdapter.ViewHolder viewHolder, int position) {
        viewHolder.titleC.setText(mConcerts.get(position).getTitleConcert());
        viewHolder.descriptionC.setText(mConcerts.get(position).getConcertDescription());
        viewHolder.imageViewC.setImageResource(mConcerts.get(position).getImageConcert());
    }

    public int getItemCount() {
        return mConcerts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleC;
        TextView descriptionC;
        ImageView imageViewC;


        ViewHolder(View itemView) {
            super(itemView);
            titleC = itemView.findViewById(R.id.text_concerts);
            descriptionC = itemView.findViewById(R.id.short_concertdescription);
            imageViewC = itemView.findViewById(R.id.imageConcert);
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
