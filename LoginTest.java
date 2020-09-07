package web_test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, 30);

    @Before
    public void beforeTest () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mymarket.lu/ru/login/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("username-143")).sendKeys("test_usr");
    }

    @Test
    public void testSuccessfulLoginTest () throws InterruptedException {
        driver.findElement(By.id("user_password-143")).sendKeys("123456789");
        Thread.sleep(2000);
        driver.findElement(By.id("user_password-143")).sendKeys(Keys.ENTER);
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("<< GO BACK")));
        Assert.assertNotNull(driver.findElement(By.className("um-faicon-user")));

    }

    @Test
    public void testErrorPageTest () throws InterruptedException {
        driver.findElement(By.id("user_password-143")).sendKeys("9999999");
        Thread.sleep(2000);
        driver.findElement(By.id("user_password-143")).sendKeys(Keys.ENTER);
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("<< GO BACK")));
        Assert.assertNotNull(driver.findElement(By.className("um-field-error")));
    }

    @After
    public void quit () {
       driver.quit();
    }

}
