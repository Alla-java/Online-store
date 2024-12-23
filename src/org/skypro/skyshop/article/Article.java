package org.skypro.skyshop.article;

import org.skypro.skyshop.common.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String title; // Название статьи
    private final String content; // Текст статьи

    public Article(String title, String content) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Название статьи не может быть пустым");
        }
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым");
        }
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getName() {
        return getTitle();
    }

    @Override
    public String getStringRepresentation() {
        return getTitle() + " — ARTICLE";
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

}
