package nyc.c4q.ashiquechowdhury.nowfeed.moviedb;

/**
 * Created by ashiquechowdhury on 11/13/16.
 */
public class MovieDescriptions {
    String imagePath;
    String description;

    public MovieDescriptions(String description, String imagePath){
        this.imagePath = imagePath;
        this.description = description;
    }

    public String getImagePath(){
        return imagePath;
    }

    public String getDescription(){
        return description;
    }
}
