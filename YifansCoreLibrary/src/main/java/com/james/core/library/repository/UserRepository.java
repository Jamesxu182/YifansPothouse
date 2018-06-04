
package com.james.core.library.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.james.core.library.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	User findByUsername(String username);
}
