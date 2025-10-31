package com.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="activity_logs")
@Data
public class ActivityLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID activityLogId;
	Float countable;
	String notes;
	LocalDateTime logDateTime;
	LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name="memberId")
	MemberEntity member;

	@ManyToOne
	@JoinColumn(name="activityId")
	ActivityEntity activity;
	
}
