package com.future.tech.woody.spring;

import java.io.InputStream;
import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.test.context.TestContext;

public class DBTests extends AbstractSpringTests {
	private static IDatabaseConnection connection;

	private static String dataSetPath;
	
	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
		super.beforeTestClass(testContext);
		DataSource datasouce = (DataSource)testContext.getApplicationContext().getBean("dataSource");
		connection = new DatabaseConnection(datasouce.getConnection());
		dataSetPath = "config/dataset/";
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		if (connection != null) {
			connection.close();
		}
	}

	public void refresh(String dataSetName) throws Exception {
		DatabaseOperation.REFRESH.execute(connection, this.loadDataSet(dataSetName));
	}

	public void recover(String dataSetName) throws Exception {
		DatabaseOperation.CLEAN_INSERT.execute(connection, this.loadDataSet(dataSetName));
	}
	
	public IDataSet loadDataSet(String dataSetName) throws Exception {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(dataSetPath + dataSetName);
		return new XmlDataSet(in);
	}
}
