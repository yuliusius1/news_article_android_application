package com.coba.tts_pam;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class FragmentA extends ListFragment  {
    OnFragmentASelectedListener mCallback;
    public interface OnFragmentASelectedListener {
        public void onArticleSelected(int position);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Ipsum.listData.isEmpty()){
            for(int i=0;i<getResources().getStringArray(R.array.newsArticles).length;i++){
                ArticleItems aItems = new ArticleItems(getResources().getStringArray(R.array.newsTitles)[i],getResources().getStringArray(R.array.newsArticles)[i], getResources().getStringArray(R.array.newsPhoto)[i]);
                Ipsum.listData.add(aItems);
            }
        }

        setListAdapter(new ArticleListAdapter(getActivity(),R.layout.adapter_layout_view,Ipsum.listData));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallback.onArticleSelected(position);
        getListView().setItemChecked(position, true);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnFragmentASelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

}
