package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "tbl_gift")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Gift {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no;
	
	@Column(length = 20, nullable = true)
	String name;
	
	@Column(nullable = true)
	int price;
	
	@Column(length = 20, nullable = true)
	String type;
	
	
	
	

}
