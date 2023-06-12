package tests.day19_CrossBroserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {


    @Test
    public void amazonTest(){

        // amazon anasayfaya gidelim
        driver.get(ConfigurationReader.getProperty("amazonUrl"));

        //Nutella icin arama yapalım

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // Sonucların Nutella icerdigini test edelim
        WebElement searchResults = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String expectedIcerik = "Nutella";
        String actualIcerik = searchResults.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));


    }
}
