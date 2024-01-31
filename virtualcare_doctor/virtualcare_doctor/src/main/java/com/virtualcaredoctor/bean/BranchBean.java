package com.virtualcaredoctor.bean;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BranchBean {

	
	private String branch_code;
	private String branch_name;
	private String status;
	private String state_code;
}
