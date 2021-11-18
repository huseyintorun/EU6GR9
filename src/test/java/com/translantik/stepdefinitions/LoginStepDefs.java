package com.translantik.stepdefinitions;

import com.github.javafaker.Faker;
import com.translantik.pages.BasePage;
import com.translantik.pages.DashboardPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    Faker faker = new Faker();

    @Given("the user is on the loginpage")
    public void the_user_is_on_the_loginpage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) throws InterruptedException {
        BrowserUtils.sleep(2);
        String username = null;
        String password = null;
        switch (userType) {
            case "driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");

                break;
            case "salesManager":
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");

                break;
            case "storeManager":
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");

                break;
            default:
                System.out.println("WARNING: <You did not enter a valid keyword on the feature page or check properties page");
                break;

        }
        loginPage.login(username, password);
    }

    @Then("the user should land on the {string}")
    public void theUserShouldLandOnThe(String relatedPage) {
        BrowserUtils.waitFor(2);
        String actualTitle = dashboardPage.subtitle.getText();
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("relatedPage = " + relatedPage);
        Assert.assertEquals("verify the page", relatedPage, actualTitle);
    }

    @When("the user enter invalid username and invalid password")
    public void theUserEnterInvalidAndInvalid() {

        String username=faker.name().username();
        String password=faker.internet().password();
        loginPage.login(username,password);

    }

    @Then("the user should not be able to logged in")
    public void theUserShouldNotBeAbleToLoggedIn() {
        String actualTitle = Driver.get().getTitle();
        BrowserUtils.waitFor(1);
        String expectetTitle = "Login";
        Assert.assertEquals("verify the page",expectetTitle,actualTitle);

    }

    @Then("the user logged out successfully and paste the same url to browser and try to skip authentication step")
    public void theUserLoggedOutSuccessfullyAndPasteTheSameUrlToBrowserAndTryToSkipAuthenticationStep() {
        String currentUrl = Driver.get().getCurrentUrl();
        dashboardPage.logOut();
       // BrowserUtils.waitFor(2);
       // Driver.get().navigate().forward();
       // BrowserUtils.waitFor(1);
        Driver.get().get(currentUrl);
        BrowserUtils.waitFor(1);

    }

    @Then("the user see their own usernames in profile menu {string}")
    public void theUserSeeTheirOwnUsernamesInProfileMenu(String userName) {
        BrowserUtils.waitFor(2);
        String actualName = dashboardPage.getUserName();
        System.out.println("actualName = " + actualName);
        System.out.println("userName = " + userName);
        Assert.assertEquals("verify the page", userName, actualName);

    }

    @Then("the user should see {string} message")
    public void theUserShouldSeeMessage(String expectedText) {
        String actualText = loginPage.warning.getText();
        Assert.assertEquals("Verify the page",expectedText,actualText);
    }

    @When("the user enter password")
    public void theUserEnter() {
       String password = faker.internet().password();
        loginPage.passwordLp.sendKeys(password);
        BrowserUtils.waitFor(2);

    }
/*You can verify if the statement has bullet points by checking
 if the element (h2 in this case) has an ancestor with tag ul
  (for unordered list, which gives bullet points). The xpath
for such a scenario would be: //h2[@id='stepone']/ancestor::ul
 */
    @Then("the user should see bullet signs by default")
    public void theUserShouldSeeBulletSignsByDefault() {
        String type = loginPage.passwordLp.getAttribute("type");
        Assert.assertEquals("Verify password",type,"password");
        
       
    }

    @When("the user click on the Forgot your password? link")
    public void theUserClickOnTheLink() {
        loginPage.forgotPassword.click();
    }


    @Then("the user land on the {string} page")
    public void theUserLandOnThePage(String forgotPassword) {
        String currentTitle = Driver.get().getTitle();

        Assert.assertEquals("Verify url",forgotPassword,currentTitle);
    }

    @When("the user on the login page should user see the {string} link")
    public void theUserOnTheLoginPageShouldUserSeeTheLink(String arg0) {

        String actualText = loginPage.rememberMe.getText();
        System.out.println("actualText = " + actualText);
        String expectedText = "Remember me on this computer" ;
        Assert.assertEquals("Verify page",expectedText,actualText);
        
    }

    @Then("the user should be able to click on the checkbox")
    public void theUserShouldBeAbleToClickOnTheCheckbox() {
        //JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        //jse.executeScript("arguments[0].click();", loginPage.checkBox);
        BrowserUtils.clickWithJS(loginPage.checkBox);
        BrowserUtils.waitFor(4);

    }

    @And("the user should be able to click")
    public void theUserShouldBeAbleToClick() {

        Assert.assertTrue(loginPage.checkBox.isSelected());

    }

    @When("the user clicks on Username hit the enter and enter Password input box hit the enter")
    public void theUserClicksOnUsernameHitTheEnterAndEnterPasswordInputBoxHitTheEnter() {
        loginPage.userNameLp.sendKeys(ConfigurationReader.get("driver_username")+ Keys.ENTER+ConfigurationReader.get("driver_password")+Keys.ENTER);

    }
    @And("the user should be able to logged in")
    public void theUserShouldBeAbleToLoggedIn() {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals("Verify the page",expectedTitle,actualTitle);



    }
}
