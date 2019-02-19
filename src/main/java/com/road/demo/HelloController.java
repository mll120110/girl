package com.road.demo;

import com.road.test.java.StaticThreadTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${cupSize}")
	private String cupSize;

	@Value("${age}")
	private Integer age;

	@Value("${content}")
	private String content;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String say() {
		StaticThreadTest staticThreadTest = new StaticThreadTest();
		return content;
	}
}
