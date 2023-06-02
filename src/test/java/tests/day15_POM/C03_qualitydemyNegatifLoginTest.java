package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;

public class C03_qualitydemyNegatifLoginTest {

    @Test
    public void gecersizIsisimTesti(){

        // qualitydemy anasayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");

        // ilk login linkine tıklayın
        QualityDemyPage qualityDemyPage = new QualityDemyPage();
        qualityDemyPage.loginLink.click();

        // kullanıcı adı olarak selenium
        qualityDemyPage.emailTextBox.sendKeys("senelinum@gmail.com");

        // password olarak heyecandir yazin
        qualityDemyPage.passwordTextBox.sendKeys("heyecandir");

        // login buttonuna tıklayın
        qualityDemyPage.loginButton.click();

        // giris yapılamadıgını test edin

        Assert.assertTrue(qualityDemyPage.emailTextBox.isEnabled());

        Driver.closeDriver();
    }

    @Test
    public void gecersizSifreTesti(){

        // qualitydemy anasayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");

        // ilk login linkine tıklayın
        QualityDemyPage qualityDemyPage = new QualityDemyPage();
        qualityDemyPage.loginLink.click();

        // kullanıcı adı olarak selenium
        qualityDemyPage.emailTextBox.sendKeys("senelinum@gmail.com");

        // password olarak heyecandir yazin
        qualityDemyPage.passwordTextBox.sendKeys("heyecandir");

        // login buttonuna tıklayın
        qualityDemyPage.loginButton.click();

        // giris yapılamadıgını test edin

        Assert.assertTrue(qualityDemyPage.emailTextBox.isEnabled());

        Driver.closeDriver();
    }

}
