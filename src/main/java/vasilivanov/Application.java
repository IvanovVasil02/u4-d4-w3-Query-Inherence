package vasilivanov;

import vasilivanov.dao.*;
import vasilivanov.entities.Concert;
import vasilivanov.entities.Event;
import vasilivanov.entities.Location;
import vasilivanov.enums.EventType;
import vasilivanov.enums.Genre;

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
      ConcertDAO cd = new ConcertDAO(em);
      UserDAO ud = new UserDAO(em);
      PartecipationDAO pd = new PartecipationDAO(em);

      Location location = ld.getById(9);
//      User userDb = ud.getById(36);
//      User userDb1 = ud.getById(37);

//      Event event1 = new FootballMatch("team1 vs team2", "27/10/2027", EventType.PUBLIC, 50, location, "team1", "team2", "team2", 10, 20);
      Event event1 = new Concert("concert test", "27/10/2027", EventType.PUBLIC, 50, location, Genre.POP, true);

//      User user1 = new User("Mike", "Secondo", "gianni@gmail.com", "27/10/2002", Sex.MALE);
//      User user2 = new User("Franck", "Secondo", "gianni@gmail.com", "27/10/2002", Sex.MALE);

//      AthleticCompetion eventDb = ad.getById(30);


//      Partecipation partecipation1 = new Partecipation(userDb, eventDb, PartecipationStatus.TO_BE_CONFIRMED);
//      Partecipation partecipation2 = new Partecipation(userDb1, eventDb, PartecipationStatus.TO_BE_CONFIRMED);
//      ud.save(user1);
//      ed.save(event1);
//      eventDb.getPartecipations().forEach(System.out::println);

//      pd.save(partecipation1);
//      pd.save(partecipation2);

//      cd.getConcertsInSrteamin().forEach(System.out::println);
//      cd.getConcertsForGenre(Genre.POP).forEach(System.out::println);


    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    } finally {
      em.close();
      emf.close();
    }
  }
}
