package br.com.vladison.qa.pages;

import br.com.vladison.qa.core.BasePage;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
        visible(firstName);
    }

    public CheckoutOverviewPage fillInformationAndContinue(String first, String last, String zip) {
        Allure.step("Fill checkout information", () -> {
            type(firstName, first);
            type(lastName, last);
            type(postalCode, zip);
        });

        Allure.step("Continue checkout", () -> {
            click(continueButton);
            wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
        });

        return new CheckoutOverviewPage(driver);
    }

    public CheckoutPage continueWithoutData() {
        Allure.step("Continue checkout without mandatory data", () -> click(continueButton));
        return this;
    }

    public String getErrorMessage() {
        return text(errorMessage);
    }
}
