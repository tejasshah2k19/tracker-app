package com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ActivityEntity;
import com.entity.UserEntity;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, UUID>{

}
