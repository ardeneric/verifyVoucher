package com.evoucher.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Evoucher implements Serializable {
	
	private static final long serialVersionUID = 8886841202378551631L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String voucher;
	private LocalDateTime created;
	private LocalDateTime modified;
	
	@Enumerated(EnumType.STRING)
	private Status status;
}
