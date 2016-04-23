package com.example.mahmoud_kamal.movies.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahmoud_kamal.movies.MovieInfo;
import com.example.mahmoud_kamal.movies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mahmoud_Kamal on 3/26/2016.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.viewHolder> {

    ArrayList<MovieInfo> movieInfos;
    Context context;
    LayoutInflater layoutInflater;
    onClick onClick;

    public RecycleAdapter(Context context, ArrayList<MovieInfo> movieInfos) {
        this.context = context;
        this.movieInfos = movieInfos;
        layoutInflater = layoutInflater.from(context);
        onClick = (onClick) context;

    }

    @Override
    public RecycleAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new viewHolder(layoutInflater.inflate(R.layout.rowmovie, parent, false));

    }

    @Override
    public void onBindViewHolder(RecycleAdapter.viewHolder holder, int position) {
        Picasso.with(context).load(Uri.parse("http://image.tmdb.org/t/p/w185" + movieInfos.get(position).getPoster_path()))
                .into(holder.imageView);
        holder.title.setText(movieInfos.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return movieInfos.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.poster1);
            title = (TextView) itemView.findViewById(R.id.moive_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClick.onclick(movieInfos.get(getPosition()).getId());

                }
            });
        }
    }

    public interface onClick {
        void onclick(long id);
    }
}
