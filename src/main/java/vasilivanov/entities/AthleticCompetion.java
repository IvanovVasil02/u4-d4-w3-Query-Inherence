package vasilivanov.entities;

import vasilivanov.enums.EventType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "at_competions")
public class AthleticCompetion extends Event {

  @OneToMany(mappedBy = "event")
  private Set<Partecipation> partecipations;
  @ManyToOne
  @JoinColumn(name = "winner_id")
  private User winner;

  public AthleticCompetion() {
  }

  public AthleticCompetion(String title, String eventDate, EventType eventType, int maxPartecipants, Location location_id, User winner) {
    super(title, eventDate, eventType, maxPartecipants, location_id);
    this.winner = winner;

  }

  public Set<Partecipation> getPartecipations() {
    return partecipations;
  }

  public Set<Partecipation> getPartecipants() {
    return partecipations;
  }

  public void setPartecipants(Set<Partecipation> partecipations) {
    this.partecipations = partecipations;
  }

  public User getWinner() {
    return winner;
  }

  public void setWinner(User winner) {
    this.winner = winner;
  }

  @Override
  public String toString() {
    return "AthleticCompetion{" +
            
            ", winner=" + winner +
            '}';
  }
}
