package com.coba.tts_pam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements FragmentA.OnFragmentASelectedListener{
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_article,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.openBrowser) {
            Intent intent = new Intent(this, AddArticleActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.frame_container) != null){
            if(savedInstanceState != null)
                return;
            FragmentA headlineFragment = new FragmentA();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_container, headlineFragment,"AnyTag").commit();
        }
    }

    @Override
    public void onArticleSelected(int position){
        FragmentB articleFrag = (FragmentB)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        boolean is_landscape = getApplicationContext().getResources().getBoolean(R.bool.is_landscape);
        if(is_landscape){
            if (articleFrag != null) {
                articleFrag.updateArticleView(position);
            }
        }
    }
}