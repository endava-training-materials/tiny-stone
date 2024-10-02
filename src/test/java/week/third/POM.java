package week.third;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class POM {



    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    WebDriver driver = null;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser){

        /**
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get("http://localhost:9010");
         */

        driver = WebDriverFabric.startBrowser(browser);
    }


    @Test
    public void secondTestRewritten(){

        /**
             String currentURL = driver.getCurrentUrl();
             System.out.println("CURRENT URL IS -> " + currentURL);
         */


        LoginPage loginPage = new LoginPage(driver);
        loginPage.getCurrentUrl();

        /**
             WebElement usernameFieldXPath = driver.findElement(By.xpath("//input[@type='text']"));
             usernameFieldXPath.sendKeys("admin");
         */

        loginPage.typeOnUsernameField(USERNAME);

        /**
             WebElement usernameFieldCSS = driver.findElement(By.cssSelector("input[type='password']"));
             usernameFieldCSS.sendKeys("password");
         */


        loginPage.typeOnPasswordField(PASSWORD);

        /**
             WebElement logInButtonCSS = driver.findElement(By.cssSelector("input[value='Login']"));
             logInButtonCSS.click();
         */

        loginPage.clickOnLoginButton();

        /**
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             wait.until(ExpectedConditions.titleIs("Swag Labs"));
         */


        HomePage homePage = new HomePage(driver);
        homePage.waitUntilPageTitleIsCorrect(5, HomePage.PAGE_TITLE);

        /**
             currentURL = driver.getCurrentUrl();
             System.out.println("CURRENT URL IS -> " + currentURL);
         */

        homePage.getCurrentUrl();

        /**
             WebElement menu = driver.findElement((By.id("react-burger-menu-btn")));
             menu.click();
         */


        TopMenu topMenu = new TopMenu(driver);
        topMenu.clickTopMenu();

        /**
             WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));
             logOutButton.click();
         */


        homePage.clickLogoutButton();

        /**
             currentURL = driver.getCurrentUrl();
             System.out.println("CURRENT URL IS -> " + currentURL);
         */

        loginPage.getCurrentUrl();

        Assert.assertTrue(loginPage.isLoginButtonVisible(), "ERROR: Login Button is not visible!");

    }


    @AfterMethod
    public void teardown(){

        /**
            driver.close();
         */

        LoginPage loginPage = new LoginPage(driver);
        loginPage.quitBrowser();
    }
}






