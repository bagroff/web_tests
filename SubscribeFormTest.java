package web_tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubscribeFormTest {

    @Test
    public void testSubscribe() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://tavriav.ua/");
        driver.manage().window().maximize();

//        driver.findElement(By.className("email valid")).clear();
//        driver.findElement(By.xpath("/html/body/form/div/div[1]/input")).sendKeys("email-test@"));
        driver.findElement(By.xpath("/html/body/form/div/div[2]/input")).click();
    }
}
