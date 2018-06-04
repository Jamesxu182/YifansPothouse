package com.james.core.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.james.core.library.model.Authority;
import com.james.core.library.model.type.AuthorityType;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByAuthority(AuthorityType authority);
}
