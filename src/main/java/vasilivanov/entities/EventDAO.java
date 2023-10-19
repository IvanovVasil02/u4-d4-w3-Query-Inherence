package vasilivanov.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventDAO {
  private final EntityManager em;

  public EventDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Event event) {
    EntityTransaction trc = em.getTransaction();
    trc.begin();

    em.persist(event);
    trc.commit();
    System.out.println("New event was added successfully");
  }

  public Event getById(long id) {
    return em.find(Event.class, id);
  }

  public void deleteEventById(long id) {
    Event eventToremove = getById(id);
    if (eventToremove != null) {
      EntityTransaction trc = em.getTransaction();
      trc.begin();

      em.remove(eventToremove);
      trc.commit();
      System.out.println("The even was removed successfully");
    } else {
      System.out.println("There was not found element with this id.");
    }
  }

  public void eventRefresh(Event eventToRefresh) {
    em.refresh(eventToRefresh);
  }
}
