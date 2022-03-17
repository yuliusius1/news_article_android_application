package com.coba.tts_pam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.InputStream;

public class FragmentB extends Fragment {
    final static String ARG_POSITION = "position";

    int mCurrentPosition = -1;

    private TextView txtArticle;
    private TextView tvTitle;
    private ImageView imgEmpty;
    private ImageView imgArticle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        View view = inflater.inflate(R.layout.article_layout_view, container, false);
        txtArticle = view.findViewById(R.id.tvArticle);
        imgEmpty = view.findViewById(R.id.iv_empty);
        tvTitle = view.findViewById(R.id.tvTitle);
        imgArticle = view.findViewById(R.id.iv_article);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void updateArticleView(int position){

        if(position >= 0) {
            txtArticle.setText(Ipsum.listData.get(position).getNewsArticle());
            tvTitle.setText(Ipsum.listData.get(position).getNewsTitle());
            imgArticle.setVisibility(View.VISIBLE);
            new DownloadImage(imgArticle).execute(Ipsum.listData.get(position).getNewsPhoto());
            imgEmpty.setVisibility(View.GONE);
        } else {
            txtArticle.setText("");
        }
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.d("Error", e.getStackTrace().toString());

            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
