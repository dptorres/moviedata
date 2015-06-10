package movie.strat.com.moviedata.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import movie.strat.com.moviedata.R;
import movie.strat.com.moviedata.data.Movie;
import movie.strat.com.moviedata.fragment.MovieDetailFragment;
import movie.strat.com.moviedata.fragment.MovieListFragment;
import movie.strat.com.moviedata.utils.JsonParser;


/**
 * An activity representing a list of Movies. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link MovieDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link MovieListFragment} and the item details
 * (if present) is a {@link MovieDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link MovieListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class MovieListActivity extends FragmentActivity
        implements MovieListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    // Movie URL
    private String url = "https://dl.dropboxusercontent.com/u/5624850/movielist/list_movies_page1.json";

    // List of Movies
    private List<Movie> movies = new ArrayList<Movie>();

    // Movie List Fragment
    private MovieListFragment fragment;

    public static final String MOVIE_LIST = "movie_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);


        if (findViewById(R.id.movie_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.

            ((MovieListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.movie_list))
                    .setActivateOnItemClick(true);

        }
        // TODO do a connectivity check first. Save loaded file into a local data store
        JsonParser.getJsonFromURL(url, this);

    }

    /**
     * Callback method from {@link MovieListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(int position) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putSerializable(MovieListActivity.MOVIE_LIST, movies.get(position));
            MovieDetailFragment fragment = new MovieDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, MovieDetailActivity.class);
            detailIntent.putExtra(MovieListActivity.MOVIE_LIST, movies.get(position));
            startActivity(detailIntent);
        }
    }

    public void setJsonMovieObject(JSONObject movieJson) {
        Gson gson = new GsonBuilder().create();
        try {
            JSONArray movArray = movieJson.getJSONObject("data").getJSONArray("movies");

            for (int i = 0; i < movArray.length(); i++) {
                Movie temp = gson.fromJson(movArray.get(i).toString(), Movie.class);
                movies.add(temp);
            }
            fragment.addAdapterContents();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getMovieList() {
        return movies;
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof MovieListFragment) {
            this.fragment = (MovieListFragment) fragment;
        }

    }

    public boolean ismTwoPane() {
        return mTwoPane;
    }
}
