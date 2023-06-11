package tests.day14_TestNGFrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DriverIlkTest {

    /*
        POM'de driver olusturmak icin
        inheritance ile kullandığımız TestBase class'ı yerine
        static yollara ulasabilcegimiz bir method kullanilması tercih edilmiştir

        Driver bizim icin çok önemli oldugundan
        driver icin bagımsız bir class olusturacagiz
     */

    @Test
    public void test01(){

        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapın
        WebElement serachBoxElement = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        serachBoxElement.sendKeys("Nutella", Keys.ENTER);

        // Arama sonuclarının "Nutella" kelimesi icerdigini test edin
        WebElement resutlsElement = Driver.getDriver().findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        Assert.assertTrue(resutlsElement.getText().contains("Nutella"));

         // Thred.sleep() yerine olusturdugumuz method
            ReusableMethods.bekle(3);
        //Driver.closeDriver(); // driver.close() yerine olusturdugumuz method
    }
}
