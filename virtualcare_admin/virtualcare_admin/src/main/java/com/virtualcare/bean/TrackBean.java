package com.virtualcare.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackBean 
{
	private Long track_id;
	private String test_status;
//	private Byte[] test_report;
	private String discharge_status;
}
