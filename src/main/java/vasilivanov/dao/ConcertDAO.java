package vasilivanov.dao;

import vasilivanov.entities.Concert;
import vasilivanov.enums.Genre;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConcertDAO {
  private final EntityManager em;

  public ConcertDAO(EntityManager em) {
    this.em = em;
  }

  public List<Concert> getConcertsInSrteamin() {
    TypedQuery<Concert> getResultQuery = em.createQuery("SELECT c FROM Concert c WHERE c.inStreaming = true", Concert.class);
    return getResultQuery.getResultList();
  }

  public List<Concert> getConcertsForGenre(Genre genre) {
    TypedQuery<Concert> getResultQuery = em.createQuery("SELECT c FROM Concert c WHERE c.genre = :genre", Concert.class);
    getResultQuery.setParameter("genre", genre);
    return getResultQuery.getResultList();
  }
}
