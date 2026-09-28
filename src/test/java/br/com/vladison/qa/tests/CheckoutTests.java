package br.com.vladison.qa.tests;

import br.com.vladison.qa.core.BaseTest;
import br.com.vladison.qa.core.Config;
import br.com.vladison.qa.pages.CheckoutPage;
import br.com.vladison.qa.pages.ConfirmationPage;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("E-commerce Web Quality")
@Feature("Checkout")
class CheckoutTests extends BaseTest {
    private CheckoutPage checkout;

    @BeforeEach
    void prepareCart() {
        InventoryPage inventory = new LoginPage(driver)
                .loginSuccessfully(Config.get("username"), Config.get("password"));
        inventory.addBackpackToCart();
        checkout = inventory.openCart().checkout();
    }

    @Test
    @Tag("smoke")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("TC-CHK-001 | Customer can complete checkout")
    void shouldCompleteCheckout() {
        ConfirmationPage confirmation = checkout
                .fillInformationAndContinue("Vladison", "Costa", "50000-000")
                .finish();

        assertEquals("Thank you for your order!", confirmation.getConfirmationMessage());
    }

    @Test
    @Tag("regression")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC-CHK-002 | Mandatory checkout data is validated")
    void shouldValidateRequiredCheckoutData() {
        checkout.continueWithoutData();
        assertTrue(checkout.getErrorMessage().contains("First Name is required"));
    }
}
