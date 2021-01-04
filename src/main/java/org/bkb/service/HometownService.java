package org.bkb.service;

import org.bkb.entity.Hometown;

import javax.persistence.EntityManager;

public class HometownService {

    private EntityManager entityManager;

    public HometownService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Hometown getHometownById(Long id) {
        return entityManager.find(Hometown.class, id);
    }

    public void insertHometown(Hometown ht){
        entityManager.getTransaction().begin();
        entityManager.persist(ht);
        entityManager.getTransaction().commit();
        System.out.println(ht.getName() + " is added to DB.");
    }
}
