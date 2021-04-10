package com.mobile.element.check;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class IOSElementCheck implements ElementCheck {
  private final AppiumDriver<MobileElement> driver;

  public IOSElementCheck(AppiumDriver<MobileElement> driver) {
    this.driver = driver;
  }

  public boolean isPresent(By by) {
    return driver.findElement(by) != null;
  }

  public boolean isVisible(By by) {
    return driver.findElement(by).isDisplayed();
  }

  public boolean isEnabled(By by) {
    return driver.findElement(by).isEnabled();
  }

  public boolean hasText(By by, String text) {
    return driver.findElement(by).getText().equals(text);
  }

  public boolean hasAttribute(By by, String attribute, String value) {
    return driver.findElement(by).getAttribute(attribute).equals(value);
  }
}
