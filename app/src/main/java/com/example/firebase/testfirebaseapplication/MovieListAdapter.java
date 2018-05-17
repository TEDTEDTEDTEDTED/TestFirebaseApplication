package com.example.firebase.testfirebaseapplication;



import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter< MovieListAdapter.TheHolder> {

    private List<com.example.firebase.testfirebaseapplication.Movie> movielists;

    public MovieListAdapter(List<com.example.firebase.testfirebaseapplication.Movie> movielists) {

        this.movielists = movielists;


    }

    @NonNull
    @Override
    public TheHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        View view =LayoutInflater.from(context).inflate(R.layout.row_movielist,parent,false);
        TheHolder theHolder = new TheHolder(view);
        return theHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TheHolder holder, int position) {
     //   Movie movie =movielist.get(position);
        //Movie movie =movielist.get(position);
      // holder.cityTextview.setText(movie.);
        com.example.firebase.testfirebaseapplication.Movie movie =movielists.get(position);
        holder.movieTextview.setText(movie.getMovie());
        holder.cityTextview.setText("  "+movie.getCity());
        holder.theaterTextview.setText(movie.getTheater());


    }

    @Override
    public int getItemCount() {


        return movielists.size();
    }

    public static class TheHolder extends RecyclerView.ViewHolder {
        private final TextView movieTextview;
        private final TextView cityTextview;
        private final TextView theaterTextview;

        public TheHolder(View itemView) {
            super(itemView);
            movieTextview = itemView.findViewById(R.id.col_movie);
            cityTextview = itemView.findViewById(R.id.col_city);
            theaterTextview = itemView.findViewById(R.id.col_theater);
        }


    }








}
