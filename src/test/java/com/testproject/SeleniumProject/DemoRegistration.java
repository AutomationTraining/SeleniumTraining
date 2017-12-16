package com.testproject.SeleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class DemoRegistration 
{
	@Test
	public void PerformRegistration()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement registerLink = driver.findElement(By.linkText("Register"));
		registerLink.click();
		
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Madhu");
		driver.findElement(By.name("LastName")).sendKeys("Java");
		
		WebElement ele = driver.findElement(By.name("DateOfBirthDay"));
		Select selectDay = new Select(ele);
		selectDay.selectByValue("10");
		
		Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		selectMonth.selectByVisibleText("June");
		
		driver.findElement(By.name("Email")).sendKeys("Java@gmail.com");
		driver.findElement(By.name("Company")).sendKeys("Centene");
		driver.findElement(By.id("Newsletter")).click();
		driver.findElement(By.name("Password")).sendKeys("password");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("password");
		driver.findElement(By.xpath("//input[@value = 'Register']")).click();
		
		String actualtext = driver.findElement(By.xpath("//div[@class='result']")).getText();
		
		if(actualtext.contains("Your registration completed"))
		{
			System.out.println("Registraction is Successful");
		}else
		{
			System.out.println("Registraction is NOT Successful");

		}
	}

}
