package com.migimnasio.sport.data;

import com.migimnasio.sport.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "instructor")
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
