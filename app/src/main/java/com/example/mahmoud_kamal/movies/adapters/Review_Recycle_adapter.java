package com.example.mahmoud_kamal.movies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoud_kamal.movies.MovieInfo;
import com.example.mahmoud_kamal.movies.R;

import java.util.ArrayList;

/**
 * Created by Mahmoud_Kamal on 4/18/2016.
 */
public class Review_Recycle_adapter  extends RecyclerView.Adapter<Review_Recycle_adapter.viewHolder> {

    ArrayList<MovieInfo> movieInfo;
    Context context;
    LayoutInflater layoutInflater;

    public Review_Recycle_adapter(Context context, ArrayList<MovieInfo> movieInfo) {
        this.context = context;
        this.movieInfo = movieInfo;
        layoutInflater = layoutInflater.from(context);


    }

    @Override
    public Review_Recycle_adapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new viewHolder(layoutInflater.inflate(R.layout.review_row, parent, false));

    }

    @Override
    public void onBindViewHolder(Review_Recycle_adapter.viewHolder holder, int position) {

        holder.author.setText(movieInfo.get(position).getAuthor());
        holder.content.setText(movieInfo.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return movieInfo.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView author;
        TextView content;

        public viewHolder(View itemView) {
            super(itemView);
            author = (TextView) itemView.findViewById(R.id.author);
            content = (TextView) itemView.findViewById(R.id.content);
        }
    }
}

