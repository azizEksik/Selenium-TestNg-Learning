package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_qualitydemyLoginTest {

    @Test
    public void test01(){
        // QUALITYDEMY ana sayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");

        // login link'ine tıklayın
        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        qualityDemyPage.loginLink.click();

        // gecerli username ve sifre yi ilgili kutulara yazın
        qualityDemyPage.emailTextBox.sendKeys("anevzatcelik@gmail.com");
        qualityDemyPage.passwordTextBox.sendKeys("Nevzat152032");

        // login buttonuna basin
        qualityDemyPage.loginButton.click();

        // basarili oalrak giris yapıldıgını tes edin
        Assert.assertTrue(qualityDemyPage.userProfileImage.isDisplayed());

        // sayfayi kapatın
        ReusableMethods.waitOfSecond(3);
        Driver.closeDriver();
    }
}
