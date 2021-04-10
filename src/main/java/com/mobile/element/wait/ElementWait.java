package com.mobile.element.wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ElementWait {
  private final WebDriverWait wait;

  public ElementWait(AppiumDriver<MobileElement> driver, long timeout) {
    this.wait = new WebDriverWait(driver, timeout);
  }

  public abstract void waitPresence(MobileElement element);

  public abstract void waitVisibility(MobileElement element);

  public abstract void waitToBeEnabled(MobileElement element);

  public abstract void waitAttributeToBe(MobileElement element, String attribute, String value);

}
