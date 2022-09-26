package com.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class OrangeHRM {

	WebDriver driver;

	@BeforeMethod
	public void init() throws Exception {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		implicitWait(3);
		driver.manage().window().maximize();
		implicitWait(3);
	}

	@Test
	public void aLogincredentials() throws Exception {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
				.submit();
		implicitWait(3);
	}

	@Test
	public void admin() throws Exception {
		aLogincredentials();
		driver.findElement(By.xpath("//a[contains(@href, '/web/index.php/admin/viewAdminModule')]")).click();
		implicitWait(3);
	}

	@Test
	public void adminUserManagement() throws Exception {
		admin();
		driver.findElement(By.xpath("//span[contains(text(), 'User Management ')]")).click();
		implicitWait(3);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Users")).click();
		implicitWait(3);
		driver.findElement(By.xpath("//div[@data-v-2fe357a6]//input[@data-v-844e87dc]")).sendKeys("Charlie.Carter");
		implicitWait(3);
		driver.findElement(By.xpath("//div[@data-v-4acd865c]")).click();
		implicitWait(3);
		driver.findElement(By.xpath("//div[@data-v-bdd98d14]//input[@data-v-7c56a434]")).sendKeys("Charlie  Carter");
		implicitWait(3);
		// driver.findElement(
		// By.xpath("//button[@class='oxd-button oxd-button--medium
		// oxd-button--secondary orangehrm-left-space']"))
		// .submit();
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		implicitWait(3);
	}

	@Test
	public void adminJobJobTitles() throws Exception {
		admin();
		driver.findElement(By.xpath("//span[contains(text(), 'Job ')]")).click();
		implicitWait(3);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Job Titles")).click();
		implicitWait(3);
		// driver.findElements(By.xpath("//span[@data-v-5ba85061]")).get(13).click();
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		implicitWait(3);
		driver.findElement(By.xpath("//div[@data-v-2fe357a6]//input[@data-v-844e87dc]")).sendKeys("IT Manager");
		implicitWait(3);
	}

	@Test
	public void adminJobPayGrades() throws Exception {
		admin();
		driver.findElement(By.xpath("//span[contains(text(), 'Job ')]")).click();
		implicitWait(3);
		driver.findElement(By.linkText("Pay Grades")).click();
		implicitWait(3);
		//driver.findElements(By.xpath("//span[@data-v-5ba85061]")).get(2).click();
		implicitWait(3);
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		implicitWait(3);
		driver.findElement(By.xpath("//div[@data-v-2fe357a6]//input[@data-v-844e87dc]")).sendKeys("Anny");
		implicitWait(3);
	}


	@Test
	private void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	
	  @AfterMethod 
	  public void destroy() throws Exception 
	  { 
		  implicitWait(3);
	      driver.quit(); }
	 
}
