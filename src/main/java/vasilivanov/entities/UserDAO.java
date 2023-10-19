package vasilivanov.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
  private final EntityManager em;

  public UserDAO(EntityManager em) {
    this.em = em;
  }

  public void save(User user) {
    EntityTransaction trc = em.getTransaction();
    trc.begin();

    em.persist(user);
    trc.commit();
    System.out.println("New user was added successfully");
  }

  public User getById(long id) {
    return em.find(User.class, id);
  }

  public void deleteUserById(long id) {
    User userToremove = getById(id);
    if (userToremove != null) {
      EntityTransaction trc = em.getTransaction();
      trc.begin();

      em.remove(userToremove);
      trc.commit();
      System.out.println("The even was removed successfully");
    } else {
      System.out.println("There was not found element with this id.");
    }
  }

  public void userRefresh(User userToRefresh) {
    em.refresh(userToRefresh);
  }
}
