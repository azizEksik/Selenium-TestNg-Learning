package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C04_ConfigurationDosyasiKullanma {

    /*
        POM'de hedef test class'ında
        manuel olarak hic bir Test Datasi GIRMEMEKTİR

        Test Datasi :
        1- Kullanacagimiz Webdriver : Driver class'indan dinamik olarak kullaniyoruz
        2- Locate : Locate'ler Pages sayfalarından dinamik olarak kullanıyoruz
        3- Kullanilan Url, aranan  kelime, expectred icerik , dogru kullanici adi,
           yanlis kullanici adi, yanlıs şifre... gibi datalar
     */

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();

        amazonPage.searchBox.sendKeys(ConfigurationReader.getProperty("amazonAranacakKelime"), Keys.ENTER);

        String expectedIcerik = ConfigurationReader.getProperty("amazonExpectedIcerik");
        String actualIcerik = amazonPage.searchResults.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        Driver.closeDriver();

    }
}
