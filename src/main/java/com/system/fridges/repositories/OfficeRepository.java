package com.system.fridges.repositories;

import com.system.fridges.models.Model;
import com.system.fridges.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
