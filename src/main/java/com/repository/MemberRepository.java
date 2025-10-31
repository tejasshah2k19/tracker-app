package com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, UUID>{

}
