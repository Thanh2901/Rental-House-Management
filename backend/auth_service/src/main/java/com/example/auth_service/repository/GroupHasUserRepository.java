package com.example.auth_service.repository;

import com.example.auth_service.entity.GroupHasUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupHasUserRepository extends JpaRepository<GroupHasUser, Integer> {
}
