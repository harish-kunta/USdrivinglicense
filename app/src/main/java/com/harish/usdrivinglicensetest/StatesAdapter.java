package com.harish.usdrivinglicensetest;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.Viewholder> {

    private final List<StateModel> stateModelList;

    public StatesAdapter(List<StateModel> categoryModelList) {
        this.stateModelList = categoryModelList;
    }

    static class Viewholder extends RecyclerView.ViewHolder {
        private final CircleImageView imageView;
        private final TextView stateTitle;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            stateTitle = itemView.findViewById(R.id.title);
        }

        private void setData(String url, final String state) {
            Glide.with(itemView.getContext()).load(url).into(imageView);
            this.stateTitle.setText(state);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    SharedPreferences.Editor editor = context.getSharedPreferences(UserSettings.PREFERENCES,MODE_PRIVATE).edit();
                    editor.putString(UserSettings.SELECTED_STATE, state);
                    editor.apply();
                    Intent setIntent = new Intent(context, SetsActivity.class);
                    setIntent.putExtra(context.getString(R.string.state), state);
                    setIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(setIntent);
                    ((Activity)context).finish();
                }
            });
        }
    }


    @NonNull
    @Override
    public StatesAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatesAdapter.Viewholder holder, int position) {
        holder.setData(stateModelList.get(position).getUrl(), stateModelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return stateModelList.size();
    }

}


