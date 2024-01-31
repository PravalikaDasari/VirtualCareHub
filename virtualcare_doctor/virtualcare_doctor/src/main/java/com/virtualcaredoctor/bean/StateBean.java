package com.virtualcaredoctor.bean;

import jakarta.persistence.Column;
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
public class StateBean {

	private String state_code;
	
	private String state_name;
	
	private int no_of_brancges;
	
	private String status;

}
