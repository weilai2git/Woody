package com.future.tech.woody.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AbstractTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/config/spring/applicationContext.xml","classpath:/config/spring/testApplicationContext.xml"} )
public abstract class AbstractSpringTests extends AbstractTestExecutionListener{

}
