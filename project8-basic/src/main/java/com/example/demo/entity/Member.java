package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// JPA !!!!
@Entity
@Table(name= "tbl_member")

// Lombok !!
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

//extends BaseEntity : BaseEntity의 시간관련 컬럼 상속받아요
public class Member extends BaseEntity {

	@Id
	@Column
	String id;
	
	@Column(length = 200, nullable = false)
	String password;
	
	@Column(length = 100, nullable = false)
	String name;
}
