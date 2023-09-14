package com.example.girlfriend.repository;

import com.example.girlfriend.model.Girlfriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GirlfriendRepository extends JpaRepository<Girlfriend, UUID> {
}
