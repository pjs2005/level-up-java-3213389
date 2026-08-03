package com.linkedin.javacodechallenges;

/**
 * Joke
 */
public class Joke {
  public String id;
  public String joke;
  public int status;

  public Joke(String id, String joke, int status) {
    this.id = id;
    this.joke = joke;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getJoke() {
    return joke;
  }

  public void setJoke(String joke) {
    this.joke = joke;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

}
