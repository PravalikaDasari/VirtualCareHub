package com.virtualcare.bean;

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

public class BranchBean {

	private String branch_code;

	private String branch_name;

	private String status;

	private String state_code;

}
