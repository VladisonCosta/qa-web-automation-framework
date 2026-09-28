package br.com.vladison.qa.tests;

import br.com.vladison.qa.core.BaseTest;
import br.com.vladison.qa.core.Config;
import br.com.vladison.qa.pages.InventoryPage;
import br.com.vladison.qa.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic("E-commerce Web Quality")
@Feature("Inventory and Cart")
class InventoryTests extends BaseTest {
    private InventoryPage inventory;

    @BeforeEach
    void login() {
        inventory = new LoginPage(driver)
                .loginSuccessfully(Config.get("username"), Config.get("password"));
    }

    @Test
    @Tag("regression")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC-INV-001 | Products can be sorted by price low to high")
    void shouldSortProductsByPriceLowToHigh() {
        List<Double> actual = inventory.sortPriceLowToHigh().getPrices();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Comparator.naturalOrder());

        assertEquals(expected, actual);
    }

    @Test
    @Tag("smoke")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC-CART-001 | Product can be added and removed from cart")
    void shouldAddAndRemoveProductFromCart() {
        inventory.addBackpackToCart();
        assertEquals("1", inventory.getCartBadge());

        inventory.removeBackpackFromCart();
        assertFalse(inventory.isCartBadgeVisible(), "Cart badge should disappear after removing the item");
    }
}
