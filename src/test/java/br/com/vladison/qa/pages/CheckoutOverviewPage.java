package br.com.vladison.qa.pages;

import br.com.vladison.qa.core.BasePage;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
        visible(finishButton);
    }

    public ConfirmationPage finish() {
        Allure.step("Finish checkout", () -> {
            click(finishButton);
            wait.until(ExpectedConditions.urlContains("checkout-complete.html"));
        });
        return new ConfirmationPage(driver);
    }
}
