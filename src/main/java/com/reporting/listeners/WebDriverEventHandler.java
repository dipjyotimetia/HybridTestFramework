package com.reporting.listeners;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class WebDriverEventHandler implements WebDriverListener {
    @Setter
    public static String fieldAttribute = "placeholder";

    private static String getElementName(WebElement element) {
        String elementText = element.getText();
        return elementText.isBlank() ? getLocatorText(element) : elementText;
    }

    private static String getLocatorText(WebElement element) {
        String elementDescription = element.toString();
        Matcher matcher = Pattern.compile("->\\s(.*)(?=])").matcher(elementDescription);
        return matcher.find() && matcher.groupCount() > 0
                ? matcher.group(1)
                : elementDescription;
    }

    private static void logEvent(String message) {
        log.info(message);
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        logEvent("Page title is [" + result + "]");
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        logEvent("Opening URL [" + url + "]");
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        logEvent("Navigating to [" + url + "]");
    }

    @Override
    public void beforeClick(WebElement element) {
        String elementName = getElementName(element);
        logEvent("Clicking on " + elementName);
    }

    @Override
    public void beforeClear(WebElement element) {
        logEvent("Clearing " + element.getAttribute(fieldAttribute));
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        log.debug("Entering Text using locator " + getLocatorText(element));

        if (keysToSend != null) {
            Optional<CharSequence> keyChar = Arrays.stream(keysToSend).filter(Keys.class::isInstance).findFirst();

            if (keyChar.isPresent()) {
                Arrays.stream(Keys.values()).filter(key -> key.equals(keyChar.get()))
                        .findFirst().ifPresent(key -> logEvent(key.name() + " Key Pressed"));
            } else {
                logEvent("Entering Text " + Arrays.toString(keysToSend) +
                        " in " + element.getAttribute(fieldAttribute) + " Field");
            }
        }
    }

    @Override
    public void afterQuit(WebDriver driver) {
        logEvent("Browser closed");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        logEvent("Browser Refreshed");
    }

    @Override
    public void afterMaximize(WebDriver.Window window) {
        logEvent("Browser Maximized");
    }

    @Override
    public void afterGetWindowHandle(WebDriver driver, String result) {
        logEvent("Switched to window " + result);
    }
}
