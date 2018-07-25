package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> toDoList;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Movie> toDoList) {
        super(context, resource, toDoList);
        this.parent_context = context;
        this.layout_id = resource;
        this.toDoList = toDoList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater object.
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI elements and bind them to their respective Java variable.
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);
//      TextView tvDate = rowView.findViewById(R.id.textViewDate);

        ImageView ivLogo = rowView.findViewById(R.id.imageViewRated);

        // Obtain the property values from the Data Class object
        // and set them to the corresponding UI elements.
        Movie currentItem = toDoList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear());
        tvGenre.setText(currentItem.getGenre());
        if (currentItem.getTitle().equalsIgnoreCase("The Avengers")) {
            ivLogo.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getTitle().equalsIgnoreCase("Planes")) {
            ivLogo.setImageResource(R.drawable.rating_pg);
        }

        return rowView;
    }
}
