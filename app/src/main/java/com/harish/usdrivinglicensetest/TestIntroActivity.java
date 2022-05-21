package com.harish.usdrivinglicensetest;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.MobileAds;

public class TestIntroActivity extends AppCompatActivity {
//    private InterstitialAd interstitialAd;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference questionsRef;
    private Dialog loadingDialog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intro);
        Button continueBtn = findViewById(R.id.continue_btn);
        TextView testTitle = findViewById(R.id.test_title);
        TextView noOfQuestionsTextView = findViewById(R.id.number_of_questions);
        loadingDialog = new Dialog(this);
        loadingDialog.setContentView(R.layout.loading);
        loadingDialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.rounded_corners));
        loadingDialog.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        loadingDialog.setCancelable(false);
//        MobileAds.initialize(this);
//        loadAds();
        final String state = getIntent().getStringExtra(getString(R.string.state));
        final int setNo = getIntent().getIntExtra(getString(R.string.set_no), 1);
        final String setTitleString = getIntent().getStringExtra(getString(R.string.set_title));
        testTitle.setText(setTitleString);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                interstitialAd.setAdListener(new AdListener() {
//                    @Override
//                    public void onAdClosed() {
//                        super.onAdClosed();
//                        interstitialAd.loadAd(new AdRequest.Builder().build());
//                        Intent questionsIntent = new Intent(TestIntroActivity.this, QuestionsActivity.class);
//                        questionsIntent.putExtra(getString(R.string.state), state);
//                        questionsIntent.putExtra(getString(R.string.set_no), setNo);
//                        startActivity(questionsIntent);
//                        finish();
//                    }
//                });
//                if (interstitialAd.isLoaded()) {
//                    interstitialAd.show();
//                    return;
//                }
                Intent questionsIntent = new Intent(TestIntroActivity.this, QuestionsActivity.class);
                questionsIntent.putExtra(getString(R.string.state), state);
                questionsIntent.putExtra(getString(R.string.set_no), setNo);
                startActivity(questionsIntent);
                finish();
            }
        });
        questionsRef = myRef.child(getString(R.string.sets_v2)).child(state).child("set_"+setNo).child("questions");
        questionsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                noOfQuestionsTextView.setText(snapshot.getChildrenCount()+"");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
//    private void loadAds() {
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//
//        interstitialAd = new InterstitialAd(this);
//        interstitialAd.setAdUnitId(getResources().getString(R.string.intertitial_ad_id));
//
//        interstitialAd.loadAd(new AdRequest.Builder().build());
//    }
}