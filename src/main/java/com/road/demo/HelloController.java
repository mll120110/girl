package com.road.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private String content = "Hello World Girl";

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String say() {
		return content;
	}
}
