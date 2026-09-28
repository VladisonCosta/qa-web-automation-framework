package br.com.vladison.qa.pages;

import br.com.vladison.qa.core.BasePage;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage loginSuccessfully(String user, String pass) {
        Allure.step("Fill username", () -> type(username, user));
        Allure.step("Fill password", () -> type(password, pass));
        Allure.step("Submit login", () -> click(loginButton));
        return new InventoryPage(driver);
    }

    public LoginPage loginExpectingFailure(String user, String pass) {
        Allure.step("Fill username", () -> type(username, user));
        Allure.step("Fill password", () -> type(password, pass));
        Allure.step("Submit login", () -> click(loginButton));
        return this;
    }

    public String getErrorMessage() {
        return text(errorMessage);
    }
}
