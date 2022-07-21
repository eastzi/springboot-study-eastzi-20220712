package com.springboot.studyeastzi.web.controller.api.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/di")

public class DiController {
	
	//private TestInterface testInterface = new TestInterfaceImpl1(); //의존성이 높은 상태. 의존성은 낮춰야 함. 알아서 찾을 수 있도록
	@Autowired
	@Qualifier("t1")
	private TestInterface testInterface1; 
	
	@Autowired
	@Qualifier("t2")
	private TestInterface testInterface2; 
	
	@GetMapping("/test1")
	public ResponseEntity<?> test1() {
		testInterface1.a();
		testInterface1.b();
		
		testInterface2.a();
		testInterface2.b();
		return ResponseEntity.ok().body(null);
	}
}
