package com.example.ispovjesti;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.PushBuilder;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.zip.DataFormatException;

@Entity
public class Story {
    @Id
    @GeneratedValue
    private Long id;



    @Lob
    private String content;
    private String author;
    private String title;

    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    private boolean approved;
    private Integer llike = 0;
    private Integer ddislike = 0;




    public Story(){
    }

    public Story(Long id, String content, String author, String title, Date date, Integer llike, Integer ddislike){
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = new Date();
        this.llike = llike;
        this.ddislike = ddislike;

    }

    public Story(String title, String author, Date date, String content,Integer llike, Integer ddislike) {
        this.title = title;
        this.author = author;
        this.date = new Date();
        this.content = content;
        this.llike = llike;
        this.ddislike = ddislike;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Integer getLlike() {
        return llike;
    }

    public void setLlike(Integer llike) {
        this.llike = llike;
    }

    public Integer getDdislike() {
        return ddislike;
    }

    public void setDdislike(Integer ddislike) {
        this.ddislike = ddislike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(id, story.id) && Objects.equals(title, story.title) && Objects.equals(author, story.author)
                && Objects.equals(date, story.date) && Objects.equals(content, story.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, date, content);
    }


    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", approved=" + approved +
                ", llike=" + llike +
                ", ddislike=" + ddislike +
                '}';
    }
}
