package vasilivanov.entities;

import vasilivanov.enums.PartecipationStatus;

import javax.persistence.*;
import java.util.Set;

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

  @ManyToMany
  @JoinColumn(name = "event_id")
  @JoinTable(name = "competion_partecipation", joinColumns = @JoinColumn(name = "partecipation_id"),
          inverseJoinColumns = @JoinColumn(name = "competion_id"))
  private Set<AthleticCompetion> atCompetion;

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
