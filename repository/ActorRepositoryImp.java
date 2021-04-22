package repository;

import entity.Actor;

import javax.persistence.EntityManager;
import java.util.List;

public class ActorRepositoryImp implements ActorRepository {
    private EntityManager em;

    public ActorRepositoryImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Actor actor) {
        this.em.persist(actor);
    }

    @Override
    public Actor findById(Long Id) {
        return this.em.find(Actor.class, Id);
    }

    @Override
    public List<Actor> findByName(String name) {
        return this.em.createNamedQuery("getByName", Actor.class).getResultList();
    }
}
