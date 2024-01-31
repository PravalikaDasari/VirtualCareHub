package com.virtualcare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="branch")
public class BranchEntity {
	@Id
	@Column(name="branch_code")
	private String branch_code;
	
	@Column(name="branch_name")
	private String branch_name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="state_code")
	private String state_code;
}
