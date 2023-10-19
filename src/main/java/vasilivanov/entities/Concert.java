package vasilivanov.entities;

import vasilivanov.enums.EventType;
import vasilivanov.enums.Genre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "concerts")

public class Concert extends Event {
  private Genre genre;
  @Column(name = "in_streaming")
  private boolean inStreaming;

  public Concert() {
  }

  public Concert(String title, String eventDate, EventType eventType, int maxPartecipants, Location location_id, Genre genre, boolean inStreaming) {
    super(title, eventDate, eventType, maxPartecipants, location_id);
    this.genre = genre;
    this.inStreaming = inStreaming;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public boolean isInStreaming() {
    return inStreaming;
  }

  public void setInStreaming(boolean inStreaming) {
    this.inStreaming = inStreaming;
  }

  @Override
  public String toString() {
    return "Concert{" +
            "genre=" + genre +
            ", inStreaming=" + inStreaming +
            "} " + super.toString();
  }
}
