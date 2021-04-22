import entity.Actor;
import entity.Director;
import entity.Genre;
import entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Actor actor = new Actor();
        actor.setName("Brad Pitt");

        Director director = new Director();
        director.setName("Jean Annaud");

        Movie movie = new Movie();
        movie.setTitle("12 years in Tibet");
        movie.setFilmId(12);
        movie.setScore(8);
        movie.setRelease_date(1997);

        Genre genre = new Genre();
        genre.setName("Drama");

        movie.setDirector(director);
        movie.addActor(actor);
        movie.setGenre(genre);

        var manager = PersistenceManager.getInstance();
        EntityManagerFactory entityManagerFactory = manager.getEmf();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //entityManager.persist(actor);
        entityManager.persist(movie);
        entityManager.persist(genre);
        entityManager.persist(director);
        entityManager.getTransaction().commit();
        entityManager.close();
        manager.closeEmf();

    }
}
