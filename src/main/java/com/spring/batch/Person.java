package com.spring.batch;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -3084512411991188148L;
	private String lastName;
	private String firstName;
}
