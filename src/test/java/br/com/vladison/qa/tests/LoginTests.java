package br.com.vladison.qa.tests;

import br.com.vladison.qa.core.BaseTest;
import br.com.vladison.qa.core.Config;
import br.com.vladison.qa.pages.InventoryPage;
import br.com.vladison.qa.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("E-commerce Web Quality")
@Feature("Authentication")
class LoginTests extends BaseTest {

    @Test
    @Tag("smoke")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("TC-LOGIN-001 | User can login with valid credentials")
    void shouldLoginWithValidCredentials() {
        InventoryPage inventory = new LoginPage(driver)
                .loginSuccessfully(Config.get("username"), Config.get("password"));

        assertTrue(inventory.isLoaded(), "Inventory page should be displayed after login");
    }

    @Test
    @Tag("regression")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC-LOGIN-002 | Invalid credentials show an error")
    void shouldRejectInvalidCredentials() {
        LoginPage login = new LoginPage(driver)
                .loginExpectingFailure("invalid_user", "invalid_password");

        assertTrue(login.getErrorMessage().contains("Username and password do not match"));
    }

    @Test
    @Tag("regression")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC-LOGIN-003 | Locked user cannot login")
    void shouldRejectLockedUser() {
        LoginPage login = new LoginPage(driver)
                .loginExpectingFailure("locked_out_user", Config.get("password"));

        assertTrue(login.getErrorMessage().contains("locked out"));
    }
}
