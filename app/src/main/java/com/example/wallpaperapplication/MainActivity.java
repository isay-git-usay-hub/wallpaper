package com.example.wallpaperapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wallpaperapplication.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changewallpaper;
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wpm;
    int prev = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytimer = new Timer();
        wpm = WallpaperManager.getInstance(this);
        changewallpaper = findViewById(R.id.button);
        changewallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallpaper();
            }
        });
    }

    private void setWallpaper() {
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                switch (prev) {
                    case 1:
                        drawable = getResources().getDrawable(R.drawable.one);
                        prev = 2;
                        break;
                    case 2:
                        drawable = getResources().getDrawable(R.drawable.two);
                        prev = 3;
                        break;
                    case 3:
                        drawable = getResources().getDrawable(R.drawable.three);
                        prev = 4;
                        break;
                    case 4:
                        drawable = getResources().getDrawable(R.drawable.four);
                        prev = 5;
                        break;
                    case 5:
                        drawable = getResources().getDrawable(R.drawable.five);
                        prev = 1;
                        break;
                }
                Bitmap wallpaper = ((BitmapDrawable) drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 3000); // Change wallpaper every 30 seconds
    }
}
