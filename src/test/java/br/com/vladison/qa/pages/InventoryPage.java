package br.com.vladison.qa.pages;

import br.com.vladison.qa.core.BasePage;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends BasePage {
    private final By pageTitle = By.cssSelector(".title");
    private final By productPrices = By.cssSelector(".inventory_item_price");
    private final By sortSelect = By.cssSelector("[data-test='product-sort-container']");
    private final By addBackpack = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private final By removeBackpack = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return "Products".equals(text(pageTitle));
    }

    public InventoryPage sortPriceLowToHigh() {
        Allure.step("Sort products from lowest to highest price", () -> {
            Select select = new Select(visible(sortSelect));
            select.selectByValue("lohi");
        });
        return this;
    }

    public List<Double> getPrices() {
        return driver.findElements(productPrices).stream()
                .map(element -> element.getText().replace("$", ""))
                .map(Double::parseDouble)
                .toList();
    }

    public InventoryPage addBackpackToCart() {
        Allure.step("Add Sauce Labs Backpack to cart", () -> click(addBackpack));
        return this;
    }

    public InventoryPage removeBackpackFromCart() {
        Allure.step("Remove Sauce Labs Backpack from cart", () -> click(removeBackpack));
        return this;
    }

    public String getCartBadge() {
        return text(cartBadge);
    }

    public boolean isCartBadgeVisible() {
        return !driver.findElements(cartBadge).isEmpty();
    }

    public CartPage openCart() {
        Allure.step("Open shopping cart", () -> click(cartLink));
        return new CartPage(driver);
    }
}
