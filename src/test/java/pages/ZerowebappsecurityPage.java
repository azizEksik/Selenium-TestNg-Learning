package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZerowebappsecurityPage {

    public ZerowebappsecurityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement singinButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginTextBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement singinButton2;

    @FindBy(xpath = "//li[@id='onlineBankingMenu']")
    public WebElement onlineBankingMenuLink;

    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public WebElement payBillsLink;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyLink;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//span[text()='1 euro (EUR) = 1.3862 U.S. dollar (USD)']")
    public WebElement sellRateText;


}
