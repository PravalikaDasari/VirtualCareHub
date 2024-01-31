package com.virtualcare.bean;

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

public class StateBean {

	private String state_code;

	private String state_name;

	private int no_of_branches;

	private String status;

}
