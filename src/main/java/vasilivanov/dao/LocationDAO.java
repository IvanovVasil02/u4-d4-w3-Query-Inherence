package vasilivanov.dao;

import vasilivanov.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
  private final EntityManager em;

  public LocationDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Location location) {
    EntityTransaction trc = em.getTransaction();
    trc.begin();

    em.persist(location);
    trc.commit();
    System.out.println("New location was added successfully");
  }

  public Location getById(long id) {
    return em.find(Location.class, id);
  }

  public void deleteLocationById(long id) {
    Location locationToremove = getById(id);
    if (locationToremove != null) {
      EntityTransaction trc = em.getTransaction();
      trc.begin();

      em.remove(locationToremove);
      trc.commit();
      System.out.println("The even was removed successfully");
    } else {
      System.out.println("There was not found element with this id.");
    }
  }

  public void locationRefresh(Location locationToRefresh) {
    em.refresh(locationToRefresh);
  }
}
