package org.bkb.service;

import org.bkb.entity.Wheel;

import javax.persistence.EntityManager;

public class WheelService {

    private EntityManager entityManager;

    public WheelService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Wheel getWheelById(Long id) {
        return entityManager.find(Wheel.class, id);
    }

    public void insertWheel(Wheel wheel){
        entityManager.getTransaction().begin();
        entityManager.persist(wheel);
        entityManager.getTransaction().commit();
        System.out.println(wheel.getWheelDefinition() + " is added to DB.");
    }
}
