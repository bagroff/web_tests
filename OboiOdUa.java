package web_tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class OboiOdUa {

      WebDriver driver;

        @Test
        public void autoInputTest () throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
            driver = new ChromeDriver();

            //Авторизация
            driver.get("https://oboi.od.ua/admin/index.php?route=common/login");
            driver.manage().window().maximize();
            Thread.sleep(1000);
            driver.findElement(By.id("input-username")).sendKeys("admin");
            Thread.sleep(1000);
            driver.findElement(By.id("input-password")).sendKeys("****"); // По понятным причинам не могу указать пароль :)

            // Проход по каталогу
            driver.findElement(By.xpath("/html//div[@id='content']/div[@class='container-fluid']//form[@action='https://oboi.od.ua/admin/index.php?route=common/login']//button[@type='submit']")).sendKeys(Keys.ENTER);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[@id='button-menu']/i[@class='fa fa-indent fa-lg']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[@id='menu-catalog']/a[@class='parent']")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Товары")).click();
            Thread.sleep(1000);

            // Создание
            driver.findElement(By.xpath("/html//button[@id='btn-insert']")).click();
            Thread.sleep(1500);

            // RU Общие
            driver.findElement(By.xpath("/html//div[@id='tab-general']/div/div[1]//input[@name='product_description[1][name]']")).sendKeys("Inspiration Wall GranDeco IW1004");
            driver.findElement(By.xpath("/html//div[@id='tab-general']/div[@class='tab-content']/div[1]/div[3]/div[@class='col-sm-10']/div[@class='note-editor note-frame panel panel-default']/div[@class='note-editing-area']/div[@class='note-editable panel-body']")).sendKeys("Виниловые обои на флизелиновой основе");
            driver.findElement(By.xpath("/html//div[@id='tab-general']/div/div[1]//input[@name='product_description[1][meta_title]']")).sendKeys("Купить обои Inspiration Wall GranDeco IW1004");
            Thread.sleep(1500);

            // UA Общие
            driver.findElement(By.linkText("Укр")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-general']/div/div[2]//input[@name='product_description[3][name]']")).sendKeys("Inspiration Wall GranDeco IW1004");
            driver.findElement(By.xpath("/html//div[@id='tab-general']/div[@class='tab-content']/div[2]/div[3]/div[@class='col-sm-10']/div[@class='note-editor note-frame panel panel-default']/div[@class='note-editing-area']/div[@class='note-editable panel-body']")).sendKeys("Вінілові шпалери на флизелиновій основі");
            driver.findElement(By.id("input-meta-title3")).sendKeys("Купити шпалери Inspiration Wall GranDeco IW1004");

            // Вкладка Данные
            driver.findElement(By.xpath("//form[@id='form-product']/ul[@class='nav nav-tabs']//a[@href='#tab-data']")).click();
            driver.findElement(By.id("input-model")).sendKeys("Inspiration Wall GranDeco IW1004");
            driver.findElement(By.id("input-tax-class")).click();
            driver.findElement(By.xpath("//select[@id='input-tax-class']/option[@value='9']")).click();

            // SEO-Url
            driver.findElement(By.id("input-keyword")).sendKeys("Inspiration Wall GranDeco IW1004".replace(" ","-"));

            // Данные по размерам
            driver.findElement(By.id("input-length")).sendKeys("10.05");
            driver.findElement(By.id("input-width")).sendKeys("0.53");

            // Порядок сортировки
            driver.findElement(By.id("input-sort-order")).clear();
            driver.findElement(By.id("input-sort-order")).sendKeys("13");

            // Вкладка Связи
            driver.findElement(By.xpath("//form[@id='form-product']/ul[@class='nav nav-tabs']//a[@href='#tab-links']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']//select[@name='manufacturer_id']")).click();
            driver.findElement(By.xpath("//div[@id='tab-links']//select[@name='manufacturer_id']/option[@value='7']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']//select[@name='manufacturer_id']")).click();

//        driver.findElement(By.id("input-sub-manufacturer")).click();
//        driver.findElement(By.xpath("//div[@safeclass~'\\bbuslikdrev\\b']/ul[@safeclass~'\\bdropdown-menu\\b']/li[11]")).click();
//        driver.findElement(By.xpath("//*[@id=\"tab-links\"]/div[2]/div/div[1]/ul/li[11]/a")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("input-sub-manufacturer")).sendKeys("GranDeco Inspiration Wall");

            List<WebElement> listOfElements=driver.findElements(By.xpath("/html//div[@id='tab-links']//div[@class='buslikdrev']/ul[@class='dropdown-menu']"));
            for (WebElement webElement:listOfElements) {
                if(webElement.getText().trim().equals("GranDeco  >  GranDeco Inspiration Wall")) {
                    webElement.click();
                    break;
                }
            }
            Thread.sleep(1000);
//        driver.findElement(By.xpath("/html//div[@id='tab-links']//div[@class='buslikdrev']/ul[@class='dropdown-menu']")).click();
//        driver.findElement(By.cssSelector("li:nth-of-type(18) > a")).click();
//        driver.findElement(By.xpath("/html//div[@id='tab-links']//div[@class='buslikdrev']/ul[@class='dropdown-menu']/li[11]/a[@href='#']")).click();
//        driver.findElement(By.id("input-sub-manufacturer")).click();
//        driver.findElement(By.linkText("GranDeco  >  GranDeco Nordic Elegance")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[1]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[3]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[5]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[8]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[9]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[10]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[12]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[13]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[14]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();

            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[16]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[19]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();
            driver.findElement(By.xpath("/html//div[@id='tab-links']/div[4]//div[@class='well well-sm']/table[@class='table table-striped']/tbody/tr[23]/td[@class='checkbox']/label/input[@name='product_category[]']")).click();

            // Вкладка Атрибуты
            driver.findElement(By.xpath("//form[@id='form-product']/ul[@class='nav nav-tabs']//a[@href='#tab-attribute']")).click();
            driver.findElement(By.xpath("/html//table[@id='attribute']//button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//tr[@id='attribute-row0']//input[@name='product_attribute[0][name]']")).sendKeys("Страна");
            driver.findElement(By.xpath("/html//tr[@id='attribute-row0']//textarea[@name='product_attribute[0][product_attribute_description][1][text]']")).click();
            driver.findElement(By.xpath("/html//tr[@id='attribute-row0']//textarea[@name='product_attribute[0][product_attribute_description][1][text]']")).sendKeys("Бельгия");
            driver.findElement(By.xpath("/html//tr[@id='attribute-row0']//textarea[@name='product_attribute[0][product_attribute_description][1][text]']")).click();
            driver.findElement(By.xpath("/html//tr[@id='attribute-row0']//textarea[@name='product_attribute[0][product_attribute_description][3][text]']")).sendKeys("Бельгія");
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html//table[@id='attribute']/tfoot/tr/td[@class='text-left']/button/i[@class='fa fa-plus-circle']")).click();
            driver.findElement(By.xpath("//table[@id='attribute']/tbody/tr[2]//input[@name='product_attribute[1][name]']")).sendKeys("Основа");
            driver.findElement(By.xpath("//table[@id='attribute']/tbody/tr[2]/td[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html//table[@id='attribute']/tbody/tr[2]//textarea[@name='product_attribute[1][product_attribute_description][1][text]']")).sendKeys("Флизелиновая основа");
            driver.findElement(By.xpath("/html//table[@id='attribute']/tbody/tr[2]//textarea[@name='product_attribute[1][product_attribute_description][3][text]']")).sendKeys("Флізелінова основа");
            Thread.sleep(2000);

            // Сохранение карточки товара
            driver.findElement(By.xpath("/html//div[@id='content']//div[@class='pull-right']/button/i[@class='fa fa-save']")).click();
            Thread.sleep(5000);

            driver.quit();


        }

}





