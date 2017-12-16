package com.testproject.SeleniumProject;

import org.testng.Reporter;
import org.testng.annotations.Test;

import utils.DataTable;

public class SampleTest {
	
	@Test
	public void Start()
	{
		Reporter.log("STep2");
		System.out.println("Welcome to maven");
		DataTable data = new DataTable("C:\\Users\\my pc\\Desktop\\TestData.xlsx", "Sheet1");
		System.out.println(data.getData(2, "Test"));
	}

}
