package org.bkb.service;

import org.bkb.entity.Alien;

import javax.persistence.EntityManager;

public class AlienService {

    private EntityManager entityManager;

    public AlienService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Alien getAlienById(Long id) {
        return entityManager.find(Alien.class, id);
    }

    public void insertAlien(Alien alien){
        entityManager.getTransaction().begin();
        entityManager.persist(alien);
        entityManager.getTransaction().commit();
        System.out.println(alien.getFirstName() + " is added to DB.");
    }
}
