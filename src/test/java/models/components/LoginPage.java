package models.components;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage {
    // Example:
    //* Internal Login Page
    // #username
    // #password
    // #loginBtn
    //
    //* External Login Page
    //  #username
    //  #password
    //  #loginBtn
    // input username > password > click on Login Btn > User Dashboard
    //  req: Test Login Pages
    // *

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(){

        System.out.println(username());
        System.out.println(password());
        System.out.println(loginBtn());
    }

    public void verifyLoginSuccess(){
        System.out.println("Verifying Dashboard Display");
    }

    public abstract String username();
    public abstract String password();
    public abstract String loginBtn();
}
