package com.migimnasio.sport.dao;

import com.migimnasio.sport.models.Instructor;

import java.util.Optional;

public interface IIntructorDao {

    Optional<Instructor> existeInstructor(Long id);
}
