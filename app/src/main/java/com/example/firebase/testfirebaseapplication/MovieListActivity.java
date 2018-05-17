package com.example.firebase.testfirebaseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    private static final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        ArrayList<Movie> movieArrayList =new ArrayList<>();


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference movieitem =db.collection("MovieList");
        Query query =movieitem.limit(100);




        query.get().addOnCompleteListener(task ->{
            QuerySnapshot querySnapshot =task.isSuccessful()? task.getResult():null;

            for (DocumentSnapshot documentSnapshot:querySnapshot.getDocuments()) {
                Movie movie = documentSnapshot.toObject(Movie.class);
           //     String movi =movie.getMovie();
                String cit =movie.getCity();
//movie.setMovie(movie.getMovie());
//movie.setCity(movie.getCity());
//movie.setTheater(movie.getTheater());
              //  String theate =movie.getTheater();
               // Movie movieshow =new Movie(movi,cit,theate);
                movieArrayList.add(movie);
                Toast.makeText(MovieListActivity.this, "成功"+cit,Toast.LENGTH_LONG).show();

                setupRecyclerView(movieArrayList);



               // Log.d(TAG, "USER:" + movie.city);
            }

        });
   //   ArrayList<Movie> movieArrayLists =new ArrayList<>();



//Movie movie =new Movie("A","B","C");
    //    Movie movie1 =new Movie("B","B","C");
//movieArrayLists.add(movie);
     //   movieArrayLists.add(movie1);

       // setupRecyclerView(movieArrayList);







    }

private  void  setupRecyclerView(List<Movie> list){
    RecyclerView recyclerView =(RecyclerView) findViewById(R.id.recycler);
    MovieListAdapter adapter =new MovieListAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
}










}
