package com.future.tech.woody.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/config/spring/applicationContext.xml","classpath:/config/spring/testApplicationContext.xml"} )
@WebAppConfiguration
@EnableWebMvc
public abstract class AbstractSpringTests extends AbstractTestExecutionListener{

}
