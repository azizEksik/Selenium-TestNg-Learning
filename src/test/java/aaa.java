import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class aaa {

    @Test
    public void test01(){
        Driver.getDriver().get("https://qa.tripandway.com/");
        WebElement body = Driver.getDriver().findElement(By.xpath("//body[@style='overflow-x: hidden;']"));
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < 65; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        WebElement birinciVarisNoktasi = Driver.getDriver().findElement(By.xpath("//img[@src='https://qa.tripandway.com/public/uploads/destination-2.jpg']"));

        System.out.println(birinciVarisNoktasi.getAttribute("src"));

        WebElement ikon = Driver.getDriver().findElement(By.xpath("(//i[@class='fa fa-search-plus'])[1]"));
        ikon.click();

        WebElement img = Driver.getDriver().findElement(By.xpath("(//img[@src='https://qa.tripandway.com/public/uploads/destination-2.jpg'])[1]"));

        Assert.assertTrue(img.isDisplayed());
        Assert.assertTrue(img.isEnabled());

        String imgFoto1= img.getAttribute("src");
        String imgFoto2 = birinciVarisNoktasi.getAttribute("src");

        Assert.assertEquals(imgFoto1,imgFoto2);
    }
}
