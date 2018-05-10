package com.example.firebase.testfirebaseapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    private EditText edmovie;
    private  EditText edcity;
    private EditText edtheater;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void findviews(){

        edmovie = (EditText) findViewById(R.id.movie);
    edcity = (EditText) findViewById(R.id.city);
    edtheater = (EditText) findViewById(R.id.theater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
      //  String edmovie = edmovie.getText().toString();
      //  String info = edInfo.getText().toString();
       // String cdate = edDate.getText().toString();


    //    edmovie = (EditText) findViewById(R.id.);
     //   edcity = (EditText) findViewById(R.id.passwd);
     //   edtheater = (EditText) findViewById(R.id.userid);






    }

    public void add(View v) {
         String edMovie = edmovie.getText().toString();
         String edCity=  edcity.getText().toString();
         String edTheater = edtheater.getText().toString();

      /*  if(edCity.equals("新北市") ){
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
        }*/

    //   String[] movielist = {edMovie ,edCity, edTheater };

       List<Movie> movies = Arrays.asList(
                new Movie(edMovie,edCity,edTheater));
        for(Movie movie:movies){

            db.collection("MovieList")
                    .add(movie)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(MainActivity.this, "成功",Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, "失敗",Toast.LENGTH_LONG).show();

                        }
                    });
       // db.collection("MovieList")
               // .add(movielist);
        }







        }



   }




