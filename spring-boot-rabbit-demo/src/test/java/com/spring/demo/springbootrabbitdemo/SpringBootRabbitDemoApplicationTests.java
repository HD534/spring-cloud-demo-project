package com.spring.demo.springbootrabbitdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRabbitDemoApplicationTests {

	@Autowired
	private Sender sender;


	@Test
	public void sendTest() throws Exception {

		for(int i = 0; i < 1; i++) {
			Todo todo = new Todo();
			todo.setId(i);
			todo.setTitle("Todo: " + i);
			todo.setDesc("Desc for " + i);
			sender.send(todo);
			Thread.currentThread().sleep(1000);
		}
	}
}
