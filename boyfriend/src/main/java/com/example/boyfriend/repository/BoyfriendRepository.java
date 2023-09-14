package com.example.boyfriend.repository;
import com.example.boyfriend.model.BoyFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoyfriendRepository extends JpaRepository<BoyFriend, UUID> {

}
