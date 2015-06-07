package movie.strat.com.moviedata.data;

import java.util.List;

/**
 * Created by Danah Torres on 6/7/2015.
 */
public class Movie {

    // Movie information
    private float rating;
    private List<String> genres;
    private String language;
    private String title;
    private String url;
    private String title_long;
    private String imdb_code;
    private int id;
    private String state;
    private int year;
    private int runtime;
    private String overview;
    private String slug;
    private String mpa_rating;

    public Movie(float rating, String language, String title, String url, String title_long,
                 String imdb_code, int id, String state, int year, int runtime, String overview, String slug,
                 String mpa_rating) {

        this.rating = rating;
//        this.genre = genre;
        this.language = language;
        this.title = title;
        this.url = url;
        this.title_long = title_long;
        this.imdb_code = imdb_code;
        this.id = id;
        this.state = state;
        this.year = year;
        this.runtime = runtime;
        this.overview = overview;
        this.slug = slug;
        this.mpa_rating = mpa_rating;

    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenre(List<String> genres) {
        this.genres = genres;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovieUrl() {
        return url;
    }

    public void setMovieUrl(String url) {
        this.url = url;
    }

    public String getTitleLong() {
        return title_long;
    }

    public void setTitleLong(String title_long) {
        this.title_long = title_long;
    }

    public String getMovieCode() {
        return imdb_code;
    }

    public void setMovieCode(String imdb_code) {
        this.imdb_code = imdb_code;
    }

    public int getMovieId() {
        return id;
    }

    public void setMovieId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMpaRating() {
        return mpa_rating;
    }

    public void setMpaRating(String mpa_rating) {
        this.mpa_rating = mpa_rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", genres=" + genres +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", title_long='" + title_long + '\'' +
                ", imdb_code='" + imdb_code + '\'' +
                ", id=" + id +
                ", state='" + state + '\'' +
                ", year=" + year +
                ", runtime=" + runtime +
                ", overview='" + overview + '\'' +
                ", slug='" + slug + '\'' +
                ", mpa_rating='" + mpa_rating + '\'' +
                '}';
    }
}
