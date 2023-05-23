package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_QualitydemyLogintest {

    @Test
    public void test01(){
        // QUALITYDEMY ana sayfaya gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("qualitydemyUrl"));

        // login link'ine tıklayın
        QualityDemyPage qualityDemyPage = new QualityDemyPage();
        qualityDemyPage.loginLink.click();

        // gecerli username ve sifre yi ilgili kutulara yazın
        qualityDemyPage.emailTextBox.sendKeys(ConfigurationReader.getProperty("qualitydemyGecerliUsername"));
        qualityDemyPage.passwordTextBox.sendKeys("qualitydemyGecerliPassword");

        // login buttonuna basin
        qualityDemyPage.loginButton.click();

        // basarili oalrak giris yapıldıgını tes edin
        Assert.assertTrue(qualityDemyPage.userProfileImage.isDisplayed());

        // sayfayi kapatın

    }

}
