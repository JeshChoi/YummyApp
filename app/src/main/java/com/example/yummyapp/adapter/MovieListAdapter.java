package com.example.yummyapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yummyapp.R;
import com.example.yummyapp.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.myViewHolder> {

    private Context context;
    private List<MovieModel> movieList;

    public MovieListAdapter(Context context, List<MovieModel> movieList){
        this.context = context;
        this.movieList = movieList;

    }

    public void setMovieList(List<MovieModel> movieList){
        this.movieList = movieList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MovieListAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new myViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.myViewHolder holder, int position) {
        holder.tvTitle.setText(this.movieList.get(position).getTitle()); //maybe this is why my images wont show

        Glide.with(context)
                .load(this.movieList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(this.movieList != null){
            return this.movieList.size();
        }
        return 0;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        ImageView imageView;

        public myViewHolder(View itemView){
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.titleView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }
}
