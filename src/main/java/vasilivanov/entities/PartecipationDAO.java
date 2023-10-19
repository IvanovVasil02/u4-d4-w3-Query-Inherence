package vasilivanov.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipationDAO {
  private final EntityManager em;

  public PartecipationDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Partecipation partecipation) {
    EntityTransaction trc = em.getTransaction();
    trc.begin();

    em.persist(partecipation);
    trc.commit();
    System.out.println("New partecipation was added successfully");
  }

  public Partecipation getById(long id) {
    return em.find(Partecipation.class, id);
  }

  public void deletePartecipationById(long id) {
    Partecipation partecipationToremove = getById(id);
    if (partecipationToremove != null) {
      EntityTransaction trc = em.getTransaction();
      trc.begin();

      em.remove(partecipationToremove);
      trc.commit();
      System.out.println("The even was removed successfully");
    } else {
      System.out.println("There was not found element with this id.");
    }
  }

  public void partecipationRefresh(Partecipation partecipationToRefresh) {
    em.refresh(partecipationToRefresh);
  }
}
