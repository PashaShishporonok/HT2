package page;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUsersPage {
    @FindBy(xpath = "//div[3][@class='task']//a[2]")
    private WebElement createUserHref;

    @FindBy(xpath = "//tr[3]//td[2]")
    private WebElement usernameTable;

    @FindBy(xpath = "//a[contains(@href,'user/someuser/delete')]")
    private WebElement delete;

    @FindBy(xpath = "//a[contains(@href,'user/admin/delete')]")
    private WebElement adminDelete;

    public ManageUsersPage clickCreateUser() {
        createUserHref.click();
        return this;
    }

    public String getCreateUserLink() {
        return createUserHref.getText();
    }

    public String getUsernameTable() {
        return usernameTable.getText();
    }

    public ManageUsersPage clickDelete() {
        delete.click();
        return this;
    }

    public boolean isDeletePresent() {
        try {
            delete.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isUserPresent() {
        try {
            usernameTable.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAdminDeletePresent() {
        try {
            adminDelete.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

