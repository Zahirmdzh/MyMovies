package sg.edu.rp.c346.mymovies;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvToDo;
    ArrayList<Movie> alTodoList;
    CustomAdapter caToDo;

    TextView tvDesc;
    TextView tvDate;
    TextView tvVenue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvToDo = findViewById(R.id.listViewMovie);
        alTodoList = new ArrayList<>();

        tvDesc = findViewById(R.id.textViewDesc);
        tvDate= findViewById(R.id.textViewDate);
        tvVenue = findViewById(R.id.textViewVenue);

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.set(2014,11,15);
        date2.set(2015,5,15);
//        String desc1 = getResources().getString(R.string.descMovie1);
        Movie movie1 = new Movie("The Avengers","2012 - ","pg13","Action | Sci-Fi",date1,
                "Golden Village - Bishan",getResources().getString(R.string.descMovie1));

        Movie movie2 = new Movie("Planes","2013 - ","pg","Animation | Comedy",date2,
                "Cathay - AMK Hub",getResources().getString(R.string.descMovie2));

        alTodoList.add(movie1);
        alTodoList.add(movie2);

        caToDo = new CustomAdapter(this,R.layout.movie_item,alTodoList);
        lvToDo.setAdapter(caToDo);

        lvToDo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    tvDesc.getResources().getString(R.string.descMovie1);
                }

            }
        });

    }
}
