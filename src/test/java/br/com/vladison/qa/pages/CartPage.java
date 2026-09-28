package br.com.vladison.qa.pages;

import br.com.vladison.qa.core.BasePage;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    private final By backpackItem = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean containsBackpack() {
        return !driver.findElements(backpackItem).isEmpty();
    }

    public CheckoutPage checkout() {
        Allure.step("Start checkout", () -> {
            click(checkoutButton);
            wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
        });
        return new CheckoutPage(driver);
    }
}
