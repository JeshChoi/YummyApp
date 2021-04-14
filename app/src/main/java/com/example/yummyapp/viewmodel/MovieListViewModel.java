package com.example.yummyapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yummyapp.network.APIService;
import com.example.yummyapp.model.MovieModel;
import com.example.yummyapp.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> moviesList;

    public MovieListViewModel(){
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMoviesList(){
        return moviesList;
    }

    public MutableLiveData<List<MovieModel>> getMoviesListObserver() {
        return moviesList;

    }

    public void makeApiCAll(){
        APIService apiService = RetroInstance.getRetrofit().create(APIService.class);
        Call<List<MovieModel>> call = apiService.getMovieList();
        Log.d("api", "it works here?");
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                moviesList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                moviesList.postValue(null);
            }
        });
    }
}
