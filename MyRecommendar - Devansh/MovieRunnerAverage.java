
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class MovieRunnerAverage {
    
    public void printAverageRatings(){
        int minimalRaters =50;
        String moviesFile = "data/ratedmoviesfull.csv";
        String ratingsFile = "data/ratings.csv";
   
        SecondRatings sr = new SecondRatings(moviesFile,ratingsFile);
        System.out.println("Number of rated movie: "+ sr.getMovieSize());
        System.out.println("Number of raters: "+ sr.getRaterSize());
        

        ArrayList<Rating> avgRatingList = sr.getAverageRatings(minimalRaters);
        Collections.sort(avgRatingList);

        for(Rating r:avgRatingList){
            System.out.println(r.getValue()+ " : " + sr.getTitle(r.getItem()));
        }  

        System.out.println("avgRatingList size " + avgRatingList.size());
    }

    public void getAverageRatingOneMovie(){
        int minimalRaters=20;

        String title = "Vacation";
        String moviesFile = "data/ratedmoviesfull.csv";
        String ratingsFile = "data/ratings.csv";
        SecondRatings sr = new SecondRatings(moviesFile,ratingsFile);

        String id = sr.getID(title);
        ArrayList<Rating> avgRatingList = sr.getAverageRatings(minimalRaters);
        
        for(Rating rating:avgRatingList){
            
            if(rating.getItem().equals(id)){
                System.out.println("Average rating for '" + title + "' is: " + rating.getValue());
            }

        }
        System.out.println("There are " + avgRatingList.size() + " movies that has  more than "+ minimalRaters + " ratings");
        

    }
    
}
