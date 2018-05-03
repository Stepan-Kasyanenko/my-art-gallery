package com.example.stepan.myartgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;

import com.example.stepan.myartgallery.adapters.ImageGalleryAdapter;
import com.example.stepan.myartgallery.models.SpacePhoto;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.rv_images);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        ImageGalleryAdapter adapter = new ImageGalleryAdapter(this, SpacePhoto.getSpacePhotos());
        recyclerView.setAdapter(adapter);

    }
}
