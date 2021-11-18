package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuickLaunchpadPage extends BasePage{

    @FindBy(css = ".oro-subtitle")
    public WebElement subtitle;
}
