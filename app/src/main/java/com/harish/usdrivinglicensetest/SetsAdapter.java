package com.harish.usdrivinglicensetest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class SetsAdapter extends RecyclerView.Adapter<SetsAdapter.Viewholder> {

    private final List<SetsModel> setsModelList;
    private final String state;

    public SetsAdapter(List<SetsModel> setsModelList, String state) {
        this.setsModelList = setsModelList;
        this.state = state;
    }

    class Viewholder extends RecyclerView.ViewHolder {
        //        private final CircleImageView imageView;
        private final TextView testTitle;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

//            imageView = itemView.findViewById(R.id.image_view);
            testTitle = itemView.findViewById(R.id.title);
        }

        private void setData(String url, final String testName, final int setNo) {
//            Glide.with(itemView.getContext()).load(url).into(imageView);
            this.testTitle.setText(testName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Intent setIntent = new Intent(context, TestIntroActivity.class);
                    setIntent.putExtra(context.getString(R.string.state), state);
                    setIntent.putExtra(context.getString(R.string.set_no), setNo);
                    setIntent.putExtra(context.getString(R.string.set_title), testName);
                    itemView.getContext().startActivity(setIntent);
                }
            });
        }
    }


    @NonNull
    @Override
    public SetsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sets_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetsAdapter.Viewholder holder, int position) {
        holder.setData(setsModelList.get(position).getUrl(), setsModelList.get(position).getName(), setsModelList.get(position).getSet_no());
    }

    @Override
    public int getItemCount() {
        return setsModelList.size();
    }

}


