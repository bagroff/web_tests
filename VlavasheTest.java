package web_tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VlavasheTest {

    WebDriver driver;

    @Before
    public void beforeCondition () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vlavashe.ua/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @Test
    public void mainMenuCartTest () throws InterruptedException {

        // main menu
        driver.findElement(By.xpath("/html//nav//ul[@class='itemMenu']/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='ProductContainer']/form[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body[@class='tpl-main']//div[@class='productInfoBlock']/form[@action='#']//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body[@class='tpl-main']/div[3]/div[@class='controls']/label[2]")).click();
        Thread.sleep(2000);

        //add to Cart
        driver.findElement(By.xpath("/html/body[@class='tpl-main']/div[@class='cartPopup']/div[@class='cartProductsBlock']//div[@class='cartProductControls']/form[2]//img[@src='/media/apps/vlavashe/icons/plus.svg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body[@class='tpl-main']/div[@class='cartPopup']/div[@class='cartProductsBlock']//div[@class='cartProductControls']/form[2]//img[@src='/media/apps/vlavashe/icons/plus.svg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body[@class='tpl-main']//div[@class='cartControls row']/label")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='popupOrder']//img[@src='/media/apps/vlavashe/icons/close.svg']")).click();
        Thread.sleep(2000);

        // delete from Cart
        driver.findElement(By.xpath("/html/body[@class='tpl-main']/div[@class='cartPopup']/div[@class='cartProductsBlock']//div[@class='cartProductControls']/form[3]//img[@src='/media/apps/vlavashe/icons/close.svg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//div[@class='cartPopup']/label[@class='absolute']/img[@src='/media/apps/vlavashe/icons/close.svg']")).click();
        Thread.sleep(2000);

    }

    @Test
    public void feedBackFormInputTest () throws InterruptedException {
        driver.findElement(By.xpath("/html//label[@class='feedbackButton']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/form/select[@name='point']")).click();
        driver.findElement(By.xpath("//body/form/select[@name='point']/option[@value='ул. Бунина, 38']")).click();
        driver.findElement(By.xpath("//body/form/select[@name='point']")).click();
        driver.findElement(By.xpath("/html/body/form//input[@name='phone']")).sendKeys("0123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/form//input[@name='name']")).sendKeys("test_usr");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/form//img[@alt='X']")).click();
        Thread.sleep(3000);

    }

    @Test
    public void galleryTest () throws InterruptedException {
        driver.findElement(By.xpath("/html//nav/ul[@class='contactMenu']//a[@href='/feed/']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//main/nav//a[@href='/feed/gallery/']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//section[@class='gallery']/img[9]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='forward']/img[@class='arrow-right']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='forward']/img[@class='arrow-right']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='forward']/img[@class='arrow-right']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//main/section[2]/img[@class='close ico-32']")).click();
        Thread.sleep(2000);

    }

    @After
    public void quit (){
        driver.quit();
    }
}
