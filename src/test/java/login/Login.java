package login;

import page.LoginPage;

public class Login {
    public void login(LoginPage loginPage){
        UserDomParser parser = new UserDomParser();
        User user = parser.parseUser();
        loginPage.fillinLogin(user.getLogin())
                .fillinPassword(user.getPassword())
                .clickLogin();
    }
}