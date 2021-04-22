package repository;

import entity.Actor;

import java.util.List;

public interface ActorRepository {
    public void create(Actor actor);
    public Actor findById(Long Id);
    public List<Actor> findByName(String name);
}
