package test;

import driver.WebDriverSingleton;
import login.Login;
import page.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestClass {
    private WebDriver driver = WebDriverSingleton.getInstance();
    static final String USERNAME = "someuser";
    static final String PASSWORD = "somepassword";
    static final String FULLNAME = "Some Full Name";
    List<String> buttonColorList;


    @Before
    public void setUp(){
        driver.get("localhost:8080");
        buttonColorList = new ArrayList<>();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        buttonColorList.add(loginPage.getLoginButtonColor());
        Login loginObj = new Login();
        loginObj.login(loginPage);
    };

    @Test
    public void jenkinsInteractionTest() throws InterruptedException {
        WelcomePage welcomePage = PageFactory.initElements(driver,WelcomePage.class);
        welcomePage.clickManage();
        ManageJenkinsPage mjPage = PageFactory.initElements(driver,ManageJenkinsPage.class);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,900)", "");


        Assert.assertEquals("Manage Users", mjPage.getDT());
        Assert.assertEquals("Create/delete/modify users that can log in to this Jenkins", mjPage.getDD());

        mjPage.clickManageUsers();
        ManageUsersPage muPage = PageFactory.initElements(driver,ManageUsersPage.class);


        Assert.assertEquals("Create User", muPage.getCreateUserLink());

        muPage.clickCreateUser();
        CreateUserPage cuPage = PageFactory.initElements(driver,CreateUserPage.class);


        Assert.assertTrue(cuPage.isFormPresent());

        buttonColorList.add(cuPage.getCreateButtonColor());

        cuPage.fillinUsername(USERNAME)
                .fillinPassword(PASSWORD)
                .confirmPassword(PASSWORD)
                .fillinFullname(FULLNAME)
                .clickCreate();


        Assert.assertEquals(USERNAME, muPage.getUsernameTable());

        muPage.clickDelete();
        DeletePage deletePage = PageFactory.initElements(driver,DeletePage.class);

        Assert.assertTrue(deletePage.getDeleteConfirmText("Are you sure about deleting the user from Jenkins?"));

        buttonColorList.add(deletePage.getDeleteButtonColor());
        deletePage.clickConfirmDelete();


        Assert.assertFalse(muPage.isUserPresent());
        Assert.assertFalse(muPage.isDeletePresent());


        Assert.assertFalse(muPage.isAdminDeletePresent());


        for (int i = 0; i < buttonColorList.size(); i++) {
            String colorHex = toHex(buttonColorList.get(i));
            Assert.assertEquals("#4b758b", colorHex);
        }
    }


    public String toHex(String color) {
        color = color.replace("rgba(","");
        color = color.replace(")", "");;
        String colors[] = color.split(", ");
        String red = pad(Integer.toHexString(Integer.parseInt(colors[0])));
        String green = pad(Integer.toHexString(Integer.parseInt(colors[1])));
        String blue = pad(Integer.toHexString(Integer.parseInt(colors[2])));
        String hex = "#" + red + green + blue;
        return hex;
    }

    private static final String pad(String s) {
        return (s.length() == 1) ? "0" + s : s;
    }



    @After
    public void shutDown() throws IOException {
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.destroyInstance();
    }
}
