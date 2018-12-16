package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//input[@id='j_username']")
    private WebElement login;

    @FindBy(xpath = "//input[@name='j_password']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='yui-gen1-button']")
    private WebElement loginButton;

    public LoginPage fillinLogin(String value) {
        login.clear();
        login.sendKeys(value);
        return this;
    }

    public LoginPage fillinPassword(String value) {
        password.clear();
        password.sendKeys(value);
        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    public String getLoginButtonColor(){
        return loginButton.getCssValue("background-color");
    }
}
