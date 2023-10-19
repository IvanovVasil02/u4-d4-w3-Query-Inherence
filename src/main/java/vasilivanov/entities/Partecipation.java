package vasilivanov.entities;

import vasilivanov.enums.PartecipationStatus;

import javax.persistence.*;

@Entity
@Table(name = "partecipations")
public class Partecipation {
  @Id
  @GeneratedValue
  private long id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  @Enumerated(EnumType.STRING)
  private PartecipationStatus status;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  public Partecipation() {
  }

  public Partecipation(User user, Event event, PartecipationStatus status) {
    this.user = user;
    this.event = event;
    this.status = status;
  }


  public long getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  @Override
  public String toString() {
    return "Partecipation{" +
            user +
            ", status=" + status +
            ", event=" + event +
            '}';
  }
}
