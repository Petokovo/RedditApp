package com.example.reddit.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;

  private String url;

  private long votes;

  @Temporal(TemporalType.DATE)
  private Date creationDate;

  public Post() {}

  public Post(String title, String url) {
    this.title = title;
    this.url = url;
    this.creationDate = new Date();
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public long getVotes() {
    return votes;
  }

  public void setVotes(long votes) {
    this.votes = votes;
  }

  public long getId() {
    return id;
  }
}
