package com.coba.tts_pam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

public class AddArticleActivity extends AppCompatActivity {
    private EditText ArticleName;
    private EditText Article;
    private EditText ArticleURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle(R.string.add_new_article);
        getSupportActionBar().setTitle(R.string.app_name);

        Article = findViewById(R.id.et_article);
        ArticleName = findViewById(R.id.et_articleName);
        ArticleURL =  findViewById(R.id.et_articleURL);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addArticle(View v){
        String article = Article.getText().toString();
        String title = ArticleName.getText().toString();
        String URL = ArticleURL.getText().toString();

        if(TextUtils.isEmpty(title) || TextUtils.isEmpty(URL) || TextUtils.isEmpty(article)){
            if(TextUtils.isEmpty(title)){
                ArticleName.setError("Article Name must be filled out");
            }
            if(TextUtils.isEmpty(URL)){
                ArticleURL.setError("Article URL Photo must be filled out");
            }
            if(TextUtils.isEmpty(article)){
                Article.setError("Article Name must be filled out");
            }
        } else {
            ArticleItems aItem = new ArticleItems(title,article,URL);
            Ipsum.listData.add(aItem);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}