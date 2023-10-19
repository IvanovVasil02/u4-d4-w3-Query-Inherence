package vasilivanov.entities;

import vasilivanov.enums.EventType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "events")
public abstract class Event {
  @Id
  @GeneratedValue
  private long id;
  private String title;
  private LocalDate eventDate;
  @Enumerated(EnumType.STRING)
  private EventType eventType;
  private int maxPartecipants;
  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;


  public Event() {
  }

  public Event(String title, String eventDate, EventType eventType, int maxPartecipants, Location location_id) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    this.title = title;
    this.eventDate = LocalDate.parse(eventDate, formatter);
    this.eventType = eventType;
    this.maxPartecipants = maxPartecipants;
    this.location = location_id;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getEventDate() {
    return eventDate;
  }

  public void setEventDate(LocalDate eventDate) {
    this.eventDate = eventDate;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public int getMaxPartecipants() {
    return maxPartecipants;
  }

  public void setMaxPartecipants(int maxPartecipants) {
    this.maxPartecipants = maxPartecipants;
  }


  @Override
  public String toString() {
    return "Event{" +
            ", title='" + title + '\'' +
            ", eventDate=" + eventDate +
            ", eventType=" + eventType +
            ", maxPartecipants=" + maxPartecipants +
            "location=" + location +
            '}';
  }
}
