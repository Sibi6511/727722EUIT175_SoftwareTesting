package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {

    WebDriver driver;

    @BeforeMethod
    public void before() throws Exception {
        System.out.println("Start Test");
    }

    // Test case 1
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[2]/div/input[1]"))
                .sendKeys("Chetan Bhagat");
        ;
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/span")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    // Test case 2
    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com");
        WebElement clickable = driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[4]/div/ul/li[5]/a"));
        new Actions(driver)
                .clickAndHold(clickable)
                .perform();
        driver.findElement(By.linkText("Audiobooks Top 100")).click();
        Thread.sleep(3000);
        // driver.findElement(By.xpath(
        // "/html/body/main/div[2]/div[1]/div/div[2]/div/div[2]/section[2]/ol/li[2]/div/div[2]/div[5]/div[2]/div/div/form"))
        // .click();
        // Thread.sleep(3000);

    }

    // Testcase 3
    @Test
    public void test3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(3000);
        driver.navigate().to("https://www.barnesandnoble.com/membership/");
        Thread.sleep(3000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='rewards-modal-link']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sibi@gmail.com");

    }

    @AfterMethod
    public void after() throws Exception {

        System.out.println("End Test");
    }

}