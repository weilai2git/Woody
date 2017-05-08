package com.future.tech.woody.spring;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class AbstractSpringMVCTests extends DBTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	public MockMvc getMockMvc() {
		return this.mockMvc;
	}
}
