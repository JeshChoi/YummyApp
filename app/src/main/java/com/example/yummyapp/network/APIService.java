package com.example.yummyapp.network;

import com.example.yummyapp.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("cars_list.json")
    Call<List<MovieModel>> getMovieList();
}
