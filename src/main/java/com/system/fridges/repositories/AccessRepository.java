package com.system.fridges.repositories;

import com.system.fridges.models.Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<Access, Integer> {
}
