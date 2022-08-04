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

    public static String of(WebElement element) {
        String eleText = element.toString();
        Matcher matcher = Pattern.compile("->\\s(.*)(?=])")
                .matcher(eleText);
        return matcher.find() && matcher.groupCount() > 0
                ? matcher.group(1)
                : eleText;
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        log.info(String.format("Page title is [%s]", result));
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        log.info(String.format("Opening URL[%s]", url));
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        log.info(String.format("Navigating to [%s]", url));
    }

    @Override
    public void beforeClick(WebElement element) {
        String elementName = element.getText();
        log.info("Clicking on " + (elementName.isBlank() ? of(element) : elementName));
    }

    @Override
    public void beforeClear(WebElement element) {
        log.info("Clearing " + element.getAttribute(fieldAttribute));
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        log.debug("Entering Text using locator " + of(element));
        if (keysToSend != null) {
            Optional<CharSequence> keyChar = Arrays.stream(keysToSend).filter(Keys.class::isInstance).findFirst();

            if (keyChar.isPresent()) {
                Arrays.stream(Keys.values()).filter(key -> key.equals(keyChar.get()))
                        .findFirst().ifPresent(key -> log.info(key.name() + " Key Pressed"));
            } else {
                log.info((String.format("Entering Text %s in %s Field", Arrays.toString(keysToSend),
                        element.getAttribute(fieldAttribute))));
            }
        }
    }

    @Override
    public void afterQuit(WebDriver driver) {
        log.info("Browser closed");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        log.info("Browser Refreshed");
    }

    @Override
    public void afterMaximize(WebDriver.Window window) {
        log.info("Browser Maximized");
    }

    @Override
    public void afterGetWindowHandle(WebDriver driver, String result) {
        log.info("Switched to window " + result);
    }
}
