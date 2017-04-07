package com.future.tech.woody;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.future.tech.woody.mock.OrderServiceMockTests;
import com.future.tech.woody.unit.OrderTests;

@RunWith(Suite.class)
@SuiteClasses({
	OrderTests.class,
	OrderServiceMockTests.class
})
public class WoodyUnitTestSuite {

}
