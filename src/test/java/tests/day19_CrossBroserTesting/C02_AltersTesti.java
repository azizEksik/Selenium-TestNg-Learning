package tests.day19_CrossBroserTesting;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseCross;

public class C02_AltersTesti extends TestBaseCross {

    @Test
    public void test01(){

        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expectedAlertText,actualAlertText,"alertteki yazı gerçekleşenden farklı");

        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

        // Alertin kapatıldıgın ıtest Edin

        softAssert.assertTrue(driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).isEnabled(),"alert kapanmadı");

        softAssert.assertAll();

    }
}
