package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongLVAdapter extends ArrayAdapter<DataModel> {

    public SongLVAdapter(@NonNull Context context, ArrayList<DataModel> dataModelArrayList) {
        super(context, 0, dataModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        DataModel dataModel = getItem(position);

        TextView titleTV = listitemView.findViewById(R.id.titleTV);
        ImageView imageIV = listitemView.findViewById(R.id.idIVimage);
        titleTV.setText(dataModel.getTitle() + "\n" + dataModel.getArtist());
        Picasso.get().load(dataModel.getImage()).into(imageIV);

        listitemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Item clicked is : " + dataModel.getTitle() +  " " + dataModel.getArtist(), Toast.LENGTH_SHORT).show();
            }
        });
            return listitemView;
        }


}

