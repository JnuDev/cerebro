package com.meli.cerebro;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CerebroApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void main() {
		CerebroApplication.main(getArgs());
	}

	private String[] getArgs() {
		String[] args = {};
		return args;
	}
}
