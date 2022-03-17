package com.coba.tts_pam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArticleListAdapter extends ArrayAdapter<ArticleItems> {

    private final Context mContext;
    int mResource;

    public ArticleListAdapter(Context context, int resource, ArrayList<ArticleItems> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        String newsTitle = getItem(position).getNewsTitle();
        String newsArticle = getItem(position).getNewsArticle();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent,false);

        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvArticle = convertView.findViewById(R.id.tv_article);

        if(newsTitle.length() >= 10){
            tvTitle.setText(newsTitle.substring(0,10)+"...");
        } else {
            tvTitle.setText(newsTitle);
        }
        if(newsArticle.length() >= 30){
            tvArticle.setText(newsArticle.substring(0,30)+"...");
        } else {
            tvArticle.setText(newsArticle);
        }

        return convertView;
    }
}
