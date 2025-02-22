package com.example.ufc_houses.model;

public class ModelArticle {
    private String ArticleThumbnail;
    private String ArticleTitle;
    private String ArticleCategory;
    private String CreatedAt;
    private String ArticleContent;  // Tambahkan atribut ini

    public ModelArticle() {
        // Default constructor required for calls to DataSnapshot.getValue(ModelArticle.class)
    }

    public ModelArticle(String articleThumbnail, String articleTitle, String articleCategory, String createdAt, String articleContent) {
        ArticleThumbnail = articleThumbnail;
        ArticleTitle = articleTitle;
        ArticleCategory = articleCategory;
        CreatedAt = createdAt;
        ArticleContent = articleContent;  // Tambahkan ini di konstruktor
    }

    public String getArticleThumbnail() {
        return ArticleThumbnail;
    }

    public void setArticleThumbnail(String articleThumbnail) {
        ArticleThumbnail = articleThumbnail;
    }

    public String getArticleTitle() {
        return ArticleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        ArticleTitle = articleTitle;
    }

    public String getArticleCategory() {
        return ArticleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        ArticleCategory = articleCategory;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getArticleContent() {  // Tambahkan getter ini
        return ArticleContent;
    }

    public void setArticleContent(String articleContent) {  // Tambahkan setter ini
        ArticleContent = articleContent;
    }
}
