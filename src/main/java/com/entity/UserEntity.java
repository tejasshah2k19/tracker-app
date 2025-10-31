package com.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID userId;
	String firstName;
	String lastName;
	String email;
	String role;
	String password;
	String gender;
	LocalDate createdAt; 
	String profilePicUrl; 
	
	@OneToMany
	@JoinColumn(name="userId")//fk 
	List<MemberEntity> members;

}