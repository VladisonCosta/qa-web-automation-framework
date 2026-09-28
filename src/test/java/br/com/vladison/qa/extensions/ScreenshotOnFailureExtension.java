package br.com.vladison.qa.extensions;

import br.com.vladison.qa.core.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotOnFailureExtension implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Object instance = context.getRequiredTestInstance();
        if (!(instance instanceof BaseTest baseTest)) {
            return;
        }

        WebDriver driver = baseTest.getDriver();
        if (!(driver instanceof TakesScreenshot screenshotDriver)) {
            return;
        }

        byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot on failure", "image/png", new ByteArrayInputStream(screenshot), ".png");

        try {
            Path directory = Path.of("target", "screenshots");
            Files.createDirectories(directory);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName = context.getRequiredTestMethod().getName() + "-" + timestamp + ".png";
            Files.write(directory.resolve(fileName), screenshot);
        } catch (IOException ignored) {
            // Allure attachment is still attempted even if local persistence fails.
        }
    }
}
