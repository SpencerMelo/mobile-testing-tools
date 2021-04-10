package com.mobile.element.action;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ElementAction {

  protected final AppiumDriver<MobileElement> driver;

  protected ElementAction(AppiumDriver<MobileElement> driver) {
    this.driver = driver;
  }

  protected boolean click(By by) {
    try {
      MobileElement element = driver.findElement(by);

      element.click();
      if (element.isSelected()) {
        return true;
      }
    } catch (Exception exception) {
      return false;
    }
    return false;
  }

  protected boolean input(By by, String value) {
    try {
      MobileElement element = driver.findElement(by);

      element.click();
      element.sendKeys(value);
      if (element.getText().equals(value) || elementWithTextExists(value)) {
        return true;
      } else {
        element.clear();
        String[] letters = value.split("");
        for (String letter : letters) {
          element.sendKeys(letter);
        }
      }
      return element.getText().equals(value);
    } catch (Exception exception) {
      return false;
    }
  }

  protected boolean clear(By by) {
    try {
      MobileElement element = driver.findElement(by);

      element.click();
      element.clear();

      if (element.getText().isEmpty()) {
        return true;
      } else {
        for (int i = 0; i < element.getText().length(); i++) {
          element.sendKeys(Keys.DELETE);
          driver.getKeyboard().sendKeys(Keys.DELETE);
        }
      }
      return element.getText().isEmpty();
    } catch (Exception exception) {
      return false;
    }
  }

  protected boolean elementWithTextExists(String text) {
    MobileElement element = driver.findElement(MobileBy.xpath("//*[contains(@text, '" + text + "')]"));
    return element != null;
  }

}
