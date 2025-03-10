package com.migimnasio.sport.data;

import com.migimnasio.sport.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
