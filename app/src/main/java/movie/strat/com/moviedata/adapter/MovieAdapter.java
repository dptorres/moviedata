package movie.strat.com.moviedata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import movie.strat.com.moviedata.data.Movie;
import movie.strat.com.moviedata.R;

/**
 * Created by Danah Torres on 6/7/2015.
 */
public class MovieAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private int layoutResourceId;
    private List<Movie> items;

    public MovieAdapter(final Context context, final int layoutResourceId, final List<Movie> items) {
        super(context, layoutResourceId, items);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.items = items;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = items.get(position);
        ViewHolder viewHolder;
        //TODO Paralax images

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.movie_title);
            viewHolder.yearReleased = (TextView) convertView.findViewById(R.id.year);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(movie.getTitle());
        viewHolder.yearReleased.setText(movie.getYear() + "");

        return convertView;
    }

    private static class ViewHolder {
        TextView title;
        TextView yearReleased;
    }
}
