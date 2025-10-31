package com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ActivityLogEntity;
import com.entity.UserEntity;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLogEntity, UUID>{

}
