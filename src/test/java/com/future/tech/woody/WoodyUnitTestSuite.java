package com.future.tech.woody;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.future.tech.woody.controller.OrderControllerTests;
import com.future.tech.woody.db.OrderDaoDBTests;
import com.future.tech.woody.mock.OrderServiceMockTests;
import com.future.tech.woody.unit.OrderTests;

@RunWith(Suite.class)
@SuiteClasses({
	OrderTests.class,
	OrderServiceMockTests.class,
	OrderDaoDBTests.class,
	OrderControllerTests.class
})
public class WoodyUnitTestSuite {

}
