package com.TestCase;

import org.testng.TestNG;

public class TestRunner {

	static TestNG testng;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testng = new TestNG();
		testng.setTestClasses(new Class[] { ExportData.class });
		testng.run();
	}

}
