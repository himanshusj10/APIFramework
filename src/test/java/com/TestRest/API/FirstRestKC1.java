package com.TestRest.API;



import java.util.Set;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import groovyjarjarantlr4.v4.codegen.model.Action;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class FirstRestKC1 {
	
	public static WebDriver driver;

@Test
 void awe () {
	RequestSpecification req = RestAssured.given();
	
	req.delete("http://dummy.restapiexample.com/api/v1/employee/l");
	
	String details = req.get("http://dummy.restapiexample.com/api/v1/employee/583").asPrettyString();
	System.out.println("Details : "+details);
	
	
}

@Test
void ekBarDemoPost () {
	
	RequestSpecification resp = RestAssured.given();
	resp.header("Content-Type","application/json");
	JSONObject jp = new JSONObject();
	jp.put("name" , " Ganesha G");
	jp.put("salary", "10000");
	jp.put("age", "40");
	resp.body(jp.toJSONString());
	Response req1 = resp.post("http://dummy.restapiexample.com/api/v1/create");
	int code = resp.get("http://dummy.restapiexample.com/api/v1/create").getStatusCode();
	System.out.println(code);
}

@Test 
void DemoPost(){
	RequestSpecification req = RestAssured.given();
	
	req.header("Content-Type","application/json");
	
	JSONObject jp = new JSONObject();
	
	jp.put("name" , " Ganesha G");
	jp.put("salary", "10000");
	jp.put("age", "40");
	
	req.body(jp.toJSONString());
	
	Response resp = req.post("http://dummy.restapiexample.com/api/v1/create");
	
	int cdStat = resp.getStatusCode();
	//Assert.assertEquals(cdStat, 200);
	Assert.assertEquals(cdStat,200);
	
	
}

@Test
void omsa() throws InterruptedException {
	 String path = "D:\\Users\\XY59005\\Desktop\\Drivers\\chromedriver.exe";
	 System.setProperty("webdriver.chrome.driver", path);
	 driver = new ChromeDriver();
	 driver.navigate().to("https://www.amazon.com");
	 driver.manage().window().maximize();
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
	 Actions builder = new Actions(driver);
	  builder.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"))).build().perform();
	  Thread.sleep(5000);
	  builder.contextClick(driver.findElement(By.xpath("//img[@alt='Keyboards']"))).build().perform();
	  Thread.sleep(5000);
	  builder.dragAndDrop(driver.findElement(By.cssSelector("body")), driver.findElement(By.cssSelector("body"))).build().perform();
	
	  String wh = driver.getWindowHandle();
	  System.out.println(wh);
	  Set <String> as=driver.getWindowHandles();
	  System.out.println(as);
	  Thread.sleep(5000);
	  
	  Set <String> as1=driver.getWindowHandles();
	  System.out.println(as1);
	  
	// List  sht = driver.getWindowHandles();
	  
	 // driver.close();
	 
}	

@Test
@Parameters ({"name"})
void name(String name)

{
System.out.println(name);
}


@DataProvider(name = "DPDemo")

	public Object [][] DP(){
		return new Object [][] {{"SADA"},{"RAMG"}};
	}

@DataProvider(name="Pseudo")

public Object [][] DPa(){
	Object[][]key = new Object[2][2];
	key [0][0] = "RamJi";
	key[0][1] = "Ganesha ji";
	
	key[1][0] = "Laxman ji ";
	key[1][1]="Hanuman Ji";
	
	return key;
			
}

@Test(dataProvider = "Pseudo")
void DPb(String val1,String val2) {
	System.out.println(val1);
	System.out.println(val2);
	
}



@Test(dataProvider = "DPDemo")

public void DPDemo (String val)
{
System.out.println(val);	
}
}
	 
	 
	 