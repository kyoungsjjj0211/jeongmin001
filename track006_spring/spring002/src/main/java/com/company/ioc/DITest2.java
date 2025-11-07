package com.company.ioc;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// ver-1 
// @Data
// ver-2
@Getter @Setter @ToString @EqualsAndHashCode
// @RequiredArgsConstructor
// @NoArgsConstructor
@AllArgsConstructor //생성자
public class DITest2 {
	private String name;
	private int age;
}
