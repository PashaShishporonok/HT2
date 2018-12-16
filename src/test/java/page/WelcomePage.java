package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {
    @FindBy(xpath = "//div[4][@class='task']//a")
    private WebElement manageHref;

    @FindBy(xpath = "//div[@class='smallfont']//a")
    private WebElement refresh;

    public WelcomePage clickManage() {
        manageHref.click();
        return this;
    }

    public String getRefreshText(){
        return refresh.getText();
    }

    public WelcomePage clickRefresh(){
        refresh.click();
        return this;
    }

}
