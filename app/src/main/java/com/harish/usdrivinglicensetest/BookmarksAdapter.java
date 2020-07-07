package com.harish.usdrivinglicensetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.Viewholder> {

    private List<QuestionModel> list;
    View itemView;
    Context context;

    QuestionModel mRecentlyDeletedItem;
    int mRecentlyDeletedItemPosition;

    public BookmarksAdapter(List<QuestionModel> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_item,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(list.get(position).getQuestion(),list.get(position).getimg_url(),list.get(position).getCorrectAns(),position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public Context getContext() {
        return context;
    }

    public void removeItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(QuestionModel item, int position) {
        list.add(position, item);
        notifyItemInserted(position);
    }
    public List<QuestionModel> getData() {
        return list;
    }


    class Viewholder extends RecyclerView.ViewHolder{
        private ImageButton deleteBtn;
        private ImageView imageView;
        private TextView question,answer;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.question);
            imageView= itemView.findViewById(R.id.bookmarkImageView);
            answer = itemView.findViewById(R.id.answer);

        }




        private void setData(String question,String url, String answer, final int position){
            this.question.setText("Q: "+question);
            RequestOptions options = new RequestOptions()
                    .fitCenter()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);
            if(url.isEmpty())
            {

                imageView.setVisibility(View.GONE);
            }
            else {
                imageView.setVisibility(View.VISIBLE);
                Glide.with(imageView.getContext()).load(url).apply(options).into(imageView);
            }
            this.answer.setText("A: "+answer);
        }
    }
}
