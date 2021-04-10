package com.mobile.element.check;

import org.openqa.selenium.By;

public interface ElementCheck {
  boolean isPresent(By by);

  boolean isVisible(By by);

  boolean isEnabled(By by);

  boolean hasText(By by, String text);

  boolean hasAttribute(By by, String attribute, String value);
}
