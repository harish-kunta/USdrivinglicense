package com.harish.usdrivinglicensetest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;

public class GridAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

//    private final int sets;
//
//    private final String category;
//
//    private final InterstitialAd interstitialAd;
//
//    public GridAdapter(int sets, String category, InterstitialAd interstitialAd) {
//
//        this.sets = sets;
//        this.category = category;
//        this.interstitialAd = interstitialAd;
//
//    }
//
//    @Override
//    public int getCount() {
//        return sets;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(final int position, View convertView, final ViewGroup parent) {
//        View view;
//
//        if (convertView == null) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_item, parent, false);
//
//        } else {
//            view = convertView;
//
//        }
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Context context = parent.getContext();
//                interstitialAd.setAdListener(new AdListener() {
//                    @Override
//                    public void onAdClosed() {
//                        super.onAdClosed();
//                        interstitialAd.loadAd(new AdRequest.Builder().build());
//                        Intent questionIntent = new Intent(parent.getContext(), QuestionsActivity.class);
//                        questionIntent.putExtra(context.getString(R.string.category), category);
//                        questionIntent.putExtra(context.getString(R.string.set_no), position + 1);
//
//                        parent.getContext().startActivity(questionIntent);
//                    }
//                });
//                if (interstitialAd.isLoaded()) {
//                    interstitialAd.show();
//                    return;
//                }
//
//                Intent questionIntent = new Intent(parent.getContext(), QuestionsActivity.class);
//                questionIntent.putExtra(context.getString(R.string.category), category);
//                questionIntent.putExtra(context.getString(R.string.set_no), position + 1);
//                parent.getContext().startActivity(questionIntent);
//            }
//        });
//
//        ((TextView) view.findViewById(R.id.textview)).setText(String.valueOf(position + 1));
//
//        return view;
//    }
}
