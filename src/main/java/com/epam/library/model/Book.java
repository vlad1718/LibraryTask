package com.epam.library.model;


public class Book {
    private Integer id;
    private String title;
    private String brief;
    private Integer year;
    private String author;

    public Book() {
    }

    public Book(Integer id, String title, String brief, Integer year, String author) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.year = year;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (brief != null ? !brief.equals(book.brief) : book.brief != null) return false;
        if (year != null ? !year.equals(book.year) : book.year != null) return false;
        return !(author != null ? !author.equals(book.author) : book.author != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" id ").append(id);
        stringBuilder.append(" title ").append(title);
        stringBuilder.append(" brief ").append(brief);
        stringBuilder.append(" year ").append(year);
        stringBuilder.append(" author ").append(author);
        return stringBuilder.toString();
    }
}
