package movie.strat.com.moviedata.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import movie.strat.com.moviedata.R;
import movie.strat.com.moviedata.activity.MovieDetailActivity;
import movie.strat.com.moviedata.activity.MovieListActivity;
import movie.strat.com.moviedata.data.Movie;

/**
 * A fragment representing a single Movie detail screen.
 * This fragment is either contained in a {@link MovieListActivity}
 * in two-pane mode (on tablets) or a {@link MovieDetailActivity}
 * on handsets.
 */
public class MovieDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Movie mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MovieDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(MovieListActivity.MOVIE_LIST)) {
            mItem = (Movie) getArguments().getSerializable(MovieListActivity.MOVIE_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        String url = "https://dl.dropboxusercontent.com/u/5624850/movielist/images/" + mItem.getSlug() + "-backdrop.jpg";
        String coverUrl = "https://dl.dropboxusercontent.com/u/5624850/movielist/images/" + mItem.getSlug() + "-cover.jpg";

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ImageView img = (ImageView) rootView.findViewById(R.id.movie_image);
            Picasso.with(getActivity()).load(url).into(img);
            ImageView coverImg = (ImageView) rootView.findViewById(R.id.movie_cover);
            Picasso.with(getActivity()).load(coverUrl).into(coverImg);
            ((TextView) rootView.findViewById(R.id.movie_title)).setText(mItem.getTitle());
            ((TextView) rootView.findViewById(R.id.year_released)).setText(mItem.getYear() + "");
            ((TextView) rootView.findViewById(R.id.rating)).setText(mItem.getRating() + "");
            ((TextView) rootView.findViewById(R.id.title_long)).setText(mItem.getTitleLong());
            ((TextView) rootView.findViewById(R.id.language)).setText(mItem.getLanguage());
            ((TextView) rootView.findViewById(R.id.runtime)).setText(mItem.getRuntime() + " minutes");
            ((TextView) rootView.findViewById(R.id.mpa_rating)).setText(mItem.getMpaRating());
            ((TextView) rootView.findViewById(R.id.overview)).setText(mItem.getOverview());

            String genre = "";
            for (int i = 0; i < mItem.getGenres().size(); i++) {
                genre = genre + mItem.getGenres().get(i);
                if (!(i == (mItem.getGenres().size() - 1))) {
                    genre+= ", ";
                }
            }
            ((TextView) rootView.findViewById(R.id.genres)).setText(genre);
        }

        return rootView;
    }
}
