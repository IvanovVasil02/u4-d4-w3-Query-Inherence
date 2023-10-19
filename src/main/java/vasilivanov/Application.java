package vasilivanov;

import vasilivanov.entities.*;
import vasilivanov.enums.EventType;
import vasilivanov.enums.PartecipationStatus;
import vasilivanov.enums.Sex;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d2w3");

  public static void main(String[] args) {
    EntityManager em = emf.createEntityManager();
    System.out.println("Hello World!");

    try {
      LocationDAO ld = new LocationDAO(em);
      EventDAO ed = new EventDAO(em);
      UserDAO ud = new UserDAO(em);
      PartecipationDAO pd = new PartecipationDAO(em);

      Location location = ld.getById(9);

      Event event1 = new Event("event2", "27/10/2027", EventType.PUBLIC, 50, location);

      Location location1 = new Location("location2", "Roma");

      User user1 = new User("Gianni", "Secondo", "gianni@gmail.com", "27/10/2002", Sex.MALE);

      Event eventDb = ed.getById(3);
      User userDb = ud.getById(11);


      Partecipation partecipation1 = new Partecipation(userDb, eventDb, PartecipationStatus.TO_BE_CONFIRMED);

//

      userDb.getPartecipationList().forEach(System.out::println);


    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    } finally {
      em.close();
      emf.close();
    }
  }
}
