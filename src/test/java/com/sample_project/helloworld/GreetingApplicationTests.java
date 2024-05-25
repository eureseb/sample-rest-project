package com.sample_project.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GreetingApplicationTests {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	GreetingService greetingService;

	@Test
	void contextLoads() {
	}

	@Test
	void greetingShouldReturnMessageFromService() throws Exception {
		String greeting = "Hello, Mock";
		when(greetingService.greet()).thenReturn(greeting);

		this.mockMvc.perform(get("/api/greet")).
				andDo(print()).
					andExpect(status().isOk()).
					andExpect(content().string(containsString(greeting)));
	}
}
