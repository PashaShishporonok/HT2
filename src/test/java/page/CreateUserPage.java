package page;

import driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.Iterator;

public class CreateUserPage {
    private WebDriver driver = WebDriverSingleton.getInstance();

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password1']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='password2']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='fullname']")
    private WebElement fullname;

    @FindBy(xpath = "//button[@id='yui-gen1-button']")
    private WebElement createButton;

    @FindBy(xpath = "//div[@class='error']")
    private WebElement error;

    public CreateUserPage fillinUsername(String value) {
        username.clear();
        username.sendKeys(value);
        return this;
    }

    public CreateUserPage fillinPassword(String value) {
        password.clear();
        password.sendKeys(value);
        return this;
    }

    public CreateUserPage confirmPassword(String value) {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
        return this;
    }

    public CreateUserPage fillinFullname(String value) {
        fullname.clear();
        fullname.sendKeys(value);
        return this;
    }

    public CreateUserPage clickCreate() {
        createButton.click();
        return this;
    }

    public String getCreateButtonColor(){
        return createButton.getCssValue("background-color");
    }

    public String getError(){
        return error.getText();
    }

    public boolean isFormPresent() {
        Collection<WebElement> forms = driver.findElements(By.tagName("form"));
        if (forms.isEmpty()) {
            return false;
        }

        Iterator<WebElement> i = forms.iterator();
        boolean isPresent = false;
        WebElement form = null;

        while (i.hasNext()) {
            form = i.next();
            if ((form.findElement(By.xpath("//input[@name='username']")).getAttribute("type").equalsIgnoreCase("text")) &&
                    (form.findElement(By.xpath("//input[@name='password1']")).getAttribute("type").equalsIgnoreCase("password")) &&
                    (form.findElement(By.xpath("//input[@name='password2']")).getAttribute("type").equalsIgnoreCase("password")) &&
                    (form.findElement(By.xpath("//input[@name='fullname']")).getAttribute("type").equalsIgnoreCase("text"))) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }
}