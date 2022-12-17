package com.test.inditex;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

import static org.mockito.Mockito.times;

class InditexApplicationTests {

	@Test
	void testApplication() {
		try(MockedStatic<SpringApplication> app = Mockito.mockStatic(SpringApplication.class)){
			InditexApplication.main(new String[]{});
			app.verify(() -> SpringApplication.run(Mockito.any(Class.class), Mockito.any(String[].class)), times(1));
		}
	}

}
