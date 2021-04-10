package com.mobile.element.action;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.Set;
import org.openqa.selenium.By;

public class WebviewElementAction extends ElementAction {

  public WebviewElementAction(AppiumDriver<MobileElement> driver) {
    super(driver);
  }

  public boolean click(By by) {
    switchToContext("WEBVIEW");
    boolean result = super.click(by);
    switchToContext("NATIVE");
    return result;
  }

  public boolean input(By by, String value) {
    switchToContext("WEBVIEW");
    boolean result = super.input(by, value);
    switchToContext("NATIVE");
    return result;
  }

  public boolean clear(By by) {
    switchToContext("WEBVIEW");
    boolean result = super.clear(by);
    switchToContext("NATIVE");
    return result;
  }

  private void switchToContext(String targetContext) {
    Set<String> contexts = driver.getContextHandles();
    for (String context : contexts) {
      if (context.contains(targetContext)) {
        driver.context(context);
      }
    }
  }
}
