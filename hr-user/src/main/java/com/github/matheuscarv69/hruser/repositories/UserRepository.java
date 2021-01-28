package com.github.matheuscarv69.hruser.repositories;

import com.github.matheuscarv69.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
