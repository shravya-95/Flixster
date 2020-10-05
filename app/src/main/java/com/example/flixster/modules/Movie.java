package com.example.flixster.modules;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Movie {
    int movieId;
     String title;
     String overview;
     String posterPath;
     double rating;

    public int getMovieId() {
        return movieId;
    }

    public Movie(JSONObject jsonObject) throws JSONException {
         posterPath = jsonObject.getString("poster_path");
         overview=jsonObject.getString("overview");
         title=jsonObject.getString("title");
         rating = jsonObject.getDouble("vote_average");
         movieId = jsonObject.getInt("id");

     }
     //Needed by parceler
     public Movie(){}
     public static List<Movie> fromMovieArray(JSONArray jsonArray) throws JSONException {
         List<Movie> movieList = new ArrayList<>();
         for (int i=0;i<jsonArray.length();i++){
             movieList.add(new Movie(jsonArray.getJSONObject(i)));
         }
         return movieList;
     }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }
    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public double getRating() {
         return rating;
    }
}
