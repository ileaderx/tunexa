package com.example.Tunexa;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    ListView songLV;
    ArrayList<DataModel> dataModelArrayList;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        songLV = findViewById(R.id.list);
        dataModelArrayList = new ArrayList<>();

        db = FirebaseFirestore.getInstance();

        loadDatainListview();
    }

    private  void loadDatainListview(){
        db.collection("Songs")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot document : list) {
                               DataModel dataModel = document.toObject(DataModel.class);

                                dataModelArrayList.add(dataModel);
                            }

                            SongLVAdapter adapter = new SongLVAdapter(MainActivity.this, dataModelArrayList);

                            songLV.setAdapter(adapter);
                        } else {
                            Toast.makeText(MainActivity.this, "No data found in database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}