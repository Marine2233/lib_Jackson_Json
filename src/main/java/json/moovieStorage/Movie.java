package json.moovieStorage;

public class Movie {
   private String title;
   private String director;
   private String year;
   private int rating;
   private String duration;

    public Movie() {
    }

    public Movie(String director, String duration, int rating, String title, String year) {
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.title = title;
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public String getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                ", duration='" + duration + '\'' +
                '}';
    }
}
