package com.migimnasio.sport.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class EjerMaqDao implements IEjerMaqDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertEjerMaq(long idEjercicio, long idMaquina) {
        entityManager.createNativeQuery("INSERT INTO ejercicio_maquina(id_ejercicio, id_maquina) VALUES (?1, ?2)")
                .setParameter(1, idEjercicio)
                .setParameter(2, idMaquina)
                .executeUpdate();
    }
}
