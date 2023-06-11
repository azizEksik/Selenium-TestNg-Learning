package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluSoftAssert extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest = extentReports.createTest("JsAlert Testi","Alert Textini doğrula ve Alerti kapat testi");

        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        extentTest.info("the-internet.herokuapp.com adresine gidildi");

        //- 1.alert'e tiklayin
        Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        extentTest.info("Alerte Tıklandı");

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = Driver.getDriver().switchTo().alert().getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expectedAlertText,actualAlertText,"alertteki yazı gerçekleşenden farklı");
        extentTest.info("Alert text'inin I am a JS Alert olduğu doğrulandı");

        //- OK tusuna basip alert'i kapatin
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("Alert Kapatıldı");

        // Alertin kapatıldıgın ıtest Edin

        softAssert.assertTrue(Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']")).isEnabled(),"alert kapanmadı");
        extentTest.info("alertin kapalı olduğu doğrulandı");

        softAssert.assertAll();
        extentTest.pass("soft asert ile yapılan tum testleri sonucu raporlar");

        Driver.quitDriver();
        extentTest.info("sayfayi kapatir");
    }

}
