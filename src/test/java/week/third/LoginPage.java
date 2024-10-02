package week.third;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver driver){
        
        super(driver);
        
    }
    private final By nameField = By.xpath("//input[@type='text']");

    private final By passField = By.cssSelector("input[type='password");

    private final By loginButton = By.id("login-button");

    public void typeOnUsernameField(String username){

        WebElement usernameField =
                driver.findElement(nameField);

        usernameField.sendKeys(username);
    }

    public void typeOnPasswordField(String username){

        WebElement usernameField =
                driver.findElement(passField);

        usernameField.sendKeys(username);
    }

    public void clickOnLoginButton(){

        WebElement logInButton =
                driver.findElement(loginButton);

        logInButton.click();
    }

    public boolean isLoginButtonVisible(){

        return driver.findElement(loginButton).isDisplayed();
    }




}
