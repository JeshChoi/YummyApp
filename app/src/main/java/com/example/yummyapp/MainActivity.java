package com.example.yummyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.view.View;

import com.example.yummyapp.adapter.MovieListAdapter;
import com.example.yummyapp.model.MovieModel;
import com.example.yummyapp.viewmodel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;
    private MovieListViewModel viewModel;
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                startActivity(intent);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final TextView noResult = findViewById(R.id.noResultTv);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MovieListAdapter(this, movieModelList);
        recyclerView.setAdapter(adapter);


        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels != null){
                    movieModelList = movieModels;
                    adapter.setMovieList(movieModels);
                }
                else{
                    noResult.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.makeApiCAll();
    }
}