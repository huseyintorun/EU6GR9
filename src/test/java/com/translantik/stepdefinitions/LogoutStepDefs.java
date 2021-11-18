package com.translantik.stepdefinitions;

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

import java.util.Set;

public class LogoutStepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("{string} logged in successfully")
    public void loggedInSuccessfully(String userType) {
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




    @When("the {string} click on the logout button")
    public void the_click_on_the_logout_button(String string) {
        BrowserUtils.waitFor(1);
        dashboardPage.logOut();

    }


    @And("the {string} landed in login page")
    public void theUserLandedInLoginPage(String string) {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Login";
        Assert.assertEquals("verify the page",actualTitle,expectedTitle);
    }


    @And("the {string} can not go to the home page again by clicking the step back button")
    public void theCanNotGoToTheHomePageAginByClickingTheStepBackButton(String arg0) {
        Driver.get().navigate().back();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Login";
        Assert.assertEquals("verify the page",actualTitle,expectedTitle);

    }

    @When("the {string} close the tab")
    public void theCloseTheTab(String arg0) {
    Set<String> windowsHandles = Driver.get().getWindowHandles();

       Driver.closeDriver();


    }

    @Then("the {string} can not be still logged in")
    public void theCanNotBeStillLoggedIn(String arg0) {
        System.out.println("Driver.get().getCurrentUrl() = " + Driver.get().getCurrentUrl());

    }


    @Then("the {string} can log out successfully")
    public void theCanLogOutSuccessfully(String arg0) {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Login";
        Assert.assertEquals("verify the page",actualTitle,expectedTitle);
    }
}
