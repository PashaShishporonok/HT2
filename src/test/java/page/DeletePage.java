package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePage {
    @FindBy(xpath = "//form[@name='delete']")
    private WebElement deleteConfirmText;

    @FindBy(xpath = "//button[@id='yui-gen1-button']")
    private WebElement deleteButton;

    public boolean getDeleteConfirmText(String value) {
        return deleteConfirmText.getText().contains(value);
    }

    public DeletePage clickConfirmDelete(){
        deleteButton.click();
        return this;
    }

    public String getDeleteButtonColor(){
        return deleteButton.getCssValue("background-color");
    }


}
