package com.example.flixster.modules;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
     String title;
     String overview;
     String posterPath;
     public Movie(JSONObject jsonObject) throws JSONException {
         posterPath = jsonObject.getString("poster_path");
         overview=jsonObject.getString("overview");
         title=jsonObject.getString("title");
     }

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
}
