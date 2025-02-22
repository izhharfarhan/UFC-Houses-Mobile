package com.example.ufc_houses.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ufc_houses.ArticleActivity;
import com.example.ufc_houses.R;
import com.example.ufc_houses.model.ModelArticle;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private List<ModelArticle> articleList;
    private Context context;

    public ArticleAdapter(List<ModelArticle> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_recycler_row, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        ModelArticle article = articleList.get(position);

        holder.articleTitle.setText(article.getArticleTitle());
        holder.articleCategory.setText(article.getArticleCategory());
        holder.articleDate.setText(article.getCreatedAt());

        // Load article image using Picasso library
        if (article.getArticleThumbnail() != null && !article.getArticleThumbnail().isEmpty()) {
            Picasso.get().load(article.getArticleThumbnail()).into(holder.articleImage);
        } else {
            holder.articleImage.setImageResource(R.drawable.no_image);
        }

        // Handle click on article
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ArticleActivity.class);
            intent.putExtra("articleTitle", article.getArticleTitle());
            intent.putExtra("articleCategory", article.getArticleCategory());
            intent.putExtra("articleDate", article.getCreatedAt());
            intent.putExtra("articleThumbnail", article.getArticleThumbnail());
            intent.putExtra("articleContent", article.getArticleContent());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return articleList != null ? articleList.size() : 0;
    }

    public void updateArticleList(List<ModelArticle> newArticleList) {
        this.articleList = newArticleList;
        notifyDataSetChanged();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView articleTitle;
        TextView articleCategory;
        TextView articleDate;
        ImageView articleImage;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            articleTitle = itemView.findViewById(R.id.article_title);
            articleCategory = itemView.findViewById(R.id.article_category);
            articleDate = itemView.findViewById(R.id.article_date);
            articleImage = itemView.findViewById(R.id.article_image_view);
        }
    }
}
