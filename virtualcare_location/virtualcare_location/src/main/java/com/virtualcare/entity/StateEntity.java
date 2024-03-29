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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="state")
public class StateEntity {
	@Id
	@Column(name="state_code")
	private String state_code;

	@Column(name="state_name")
	private String state_name;

	@Column(name="no_of_branches")
	private int no_of_branches;

	@Column(name="status")
	private String status;
}
