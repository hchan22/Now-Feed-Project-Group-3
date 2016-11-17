package nyc.c4q.ashiquechowdhury.nowfeed.moviedb.network;

/**
 * Created by ashiquechowdhury on 11/13/16.
 */
public class Movie {
    String poster_path;
    String overview;
    String title;
    String release_date;

    public String getTitle(){
        return title;
    }

    public String getRelease_date(){
        return release_date;
    }
    public String getOverview(){
        return overview;
    }

    public String getPoster_path(){
        return poster_path;
    }
}
