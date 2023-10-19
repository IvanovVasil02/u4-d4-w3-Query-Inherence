package vasilivanov.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String address;
  @OneToMany(mappedBy = "location")
  private Set<Event> events;

  public Location() {
  }

  public Location(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Set<Event> getEvent() {
    return events;
  }

  public void setEvent(Set<Event> events) {
    this.events = events;
  }

  public void addEvent(Event event) {
    this.events.add(event);
  }
}
