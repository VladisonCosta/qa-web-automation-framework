package br.com.vladison.qa.pages;

import br.com.vladison.qa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage extends BasePage {
    private final By confirmationHeader = By.cssSelector("[data-test='complete-header']");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlContains("checkout-complete.html"));
        visible(confirmationHeader);
    }

    public String getConfirmationMessage() {
        return text(confirmationHeader);
    }
}
