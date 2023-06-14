package com.service.service.repository.custom.workflow;

import java.util.List;

import jakarta.persistence.EntityManager;

public class CustomWorkflowRepository<T> {

    private final EntityManager entityManager;

    public CustomWorkflowRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // @Override
    // public List<T> customFunction() {
    //     return entityManager.createQuery("SELECT t FROM SomeEntity t", SomeEntity.class)
    //                         .getResultList();
    // }
}
