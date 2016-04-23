package com.example.mahmoud_kamal.movies.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoud_kamal.movies.DetailActivity;
import com.example.mahmoud_kamal.movies.MovieInfo;
import com.example.mahmoud_kamal.movies.R;

import java.util.ArrayList;

/**
 * Created by Mahmoud_Kamal on 4/18/2016.
 */
public class Trailer_Recycle_adapter  extends RecyclerView.Adapter<Trailer_Recycle_adapter.viewHolder> {

    ArrayList<MovieInfo> movieInfo;
    Context context;
    LayoutInflater layoutInflater;

    public Trailer_Recycle_adapter(Context context, ArrayList<MovieInfo> movieInfo) {
        this.context = context;
        this.movieInfo = movieInfo;
        layoutInflater = layoutInflater.from(context);


    }

    @Override
    public Trailer_Recycle_adapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new viewHolder(layoutInflater.inflate(R.layout.trailer_row, parent, false));

    }

    @Override
    public void onBindViewHolder(Trailer_Recycle_adapter.viewHolder holder, int position) {

        holder.trailername.setText(movieInfo.get(position).getTrailername());

    }

    @Override
    public int getItemCount() {
        return movieInfo.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView trailername;

        public viewHolder(final View itemView) {
            super(itemView);
            trailername = (TextView) itemView.findViewById(R.id.trailer_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.youtube.com/watch?v=" + movieInfo.get(getPosition()).getTrailerkey() ));
                    context.startActivity(i);
                }
            });

        }
    }
}
