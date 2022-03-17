package com.coba.tts_pam;

public class ArticleItems {
    private String newsTitle;
    private String newsArticle;
    private String newsPhoto;

    public ArticleItems(String newsTitle, String newsArticle, String newsPhoto) {
        this.newsTitle = newsTitle;
        this.newsArticle = newsArticle;
        this.newsPhoto = newsPhoto;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsArticle() {
        return newsArticle;
    }

    public void setNewsArticle(String newsArticle) {
        this.newsArticle = newsArticle;
    }

    public String getNewsPhoto() {
        return newsPhoto;
    }

    public void setNewsPhoto(String newsPhoto) {
        this.newsPhoto = newsPhoto;
    }
}
