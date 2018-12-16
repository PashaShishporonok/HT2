package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageJenkinsPage {

    @FindBy(xpath = "//a[@title='Manage Users']//dl//dt")
    private WebElement dt;

    @FindBy(xpath = "//a[@title='Manage Users']//dl//dd")
    private WebElement dd;

    @FindBy(xpath = "//a[@title='Manage Users']")
    private WebElement manageUsersHref;

    public String getDT() {
        return dt.getText();
    }

    public String getDD() {
        return dd.getText();
    }

    public ManageJenkinsPage clickManageUsers() {
        manageUsersHref.click();
        return this;
    }
}
