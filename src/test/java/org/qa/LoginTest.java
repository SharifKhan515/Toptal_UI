package org.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest {


  /*  public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
        driver.get("https://github.com/bonigarcia/webdrivermanager");
    }*/
 @Test()
    public void Browser(){
        //https://rahulshettyacademy.com/locatorspractice/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
     WebDriverWait wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

         WebElement name =  driver.findElement(By.id("inputUsername"));
         WebElement pass = driver.findElement(By.name("inputPassword"));
         WebElement signInButton = driver.findElement(By.className("signInBtn"));
         name.sendKeys("sharif");
         pass.sendKeys("password");
         signInButton.click();
         WebElement error = driver.findElement(By.cssSelector("p.error"));
         String errorMessage = error.getText();

         driver.findElement(By.linkText("Forgot your password?")).click();

          driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("New Name");
          driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("New Name and mail");
          driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
          driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("nem mail id again");
          driver.findElement(By.xpath("//form/input[3]")).sendKeys("123456789");
          wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='reset-pwd-btn']"))));
          driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

          String scm= driver.findElement(By.cssSelector("form p")).getText();

         driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[@class='go-to-login-btn']")).click();

          driver.findElement(By.cssSelector("form[class='form'] input#inputUsername")).sendKeys("rahul");
          driver.findElement(By.cssSelector("form[class='form'] input[name*='inputPas']")).sendKeys("rahulshettyacademy");
          wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(@class,'submit')]"))));
          driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

       System.out.println(errorMessage);
       System.out.println(scm);
    }
}
