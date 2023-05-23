package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualityDemyPage {

    public QualityDemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement  passwordTextBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "(//img[@class='img-fluid'])[2]")
    public WebElement userProfileImage;

}
