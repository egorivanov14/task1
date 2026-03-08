package org.task.validator.Impl;

import org.task.validator.CustomValidator;

import java.util.regex.Pattern;

public class CustomValidatorImpl implements CustomValidator {
  private static final String REGEX = "^[+-]?[1-9]\\d*$";

  @Override
  public boolean isElementValid(String element, Pattern pattern) {
    return pattern.matcher(REGEX).matches();
  }

  @Override
  public Pattern getCompilePattern() {
    return Pattern.compile(REGEX);
  }

  @Override
  public boolean isArrayValid(int[] array) {
    return array != null;
  }
}
