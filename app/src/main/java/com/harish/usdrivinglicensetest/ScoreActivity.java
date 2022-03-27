package com.harish.usdrivinglicensetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

import pl.droidsonroids.gif.GifImageView;


public class ScoreActivity extends AppCompatActivity {

    private Double percentage;
//    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        double score = 6d;
        double total_score = 100d;
        TextView scored = findViewById(R.id.scored);
        TextView total = findViewById(R.id.total);
        Button doneBtn = findViewById(R.id.done_btn);
        TextView summary = findViewById(R.id.summary);
//        gifImageView = findViewById(R.id.gifImageView2);

//        loadAds();
        try {
            score = (double) getIntent().getIntExtra(getString(R.string.score), 0);
            total_score = (double) getIntent().getIntExtra(getString(R.string.total), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scored.setText(String.valueOf(score));
        total.setText("OUT OF " + String.valueOf(total_score));
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        try {
            percentage = (double) Math.round((score / total_score) * 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (percentage > 80) {
            summary.setText("Congratulations! You got " + percentage + "% in the test");
//            gifImageView.setImageResource(R.drawable.celebration);

        } else {
            summary.setText("Better luck next time! You got " + percentage + "% in the test");
            doneBtn.setText("Try Again!!");
//            gifImageView.setImageResource(R.drawable.lost);
        }
    }

//    private void loadAds() {
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//    }
}