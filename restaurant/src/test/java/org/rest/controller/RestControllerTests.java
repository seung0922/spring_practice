package org.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rest.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // ApplicationContext ctx�� ����ִ� ����
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class RestControllerTests {

	@Setter(onMethod_ = {@Autowired} )
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	private RestService service;
	
	
	@Before
	public void ready() {
		log.info("ready mock................");
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.info(mockMvc);
	}
	
	@Test
	public void test() throws Exception {
		log.info("test");
		
		mockMvc.perform(get("/rest/list")).andReturn();
	}
}
