package org.bkb.service;

import org.bkb.entity.UFO;

import javax.persistence.EntityManager;

public class UFOService {

    private EntityManager entityManager;

    public UFOService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UFO getUFOById(Long id) {
        return entityManager.find(UFO.class, id);
    }

    public void insertUFO(UFO ufo){
        entityManager.getTransaction().begin();
        entityManager.persist(ufo);
        entityManager.getTransaction().commit();
        System.out.println(ufo.getName() + " is added to DB.");
    }

}
