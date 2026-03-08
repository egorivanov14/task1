package org.task.validator.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.validator.CustomValidator;

import java.util.regex.Pattern;

public class CustomValidatorImpl implements CustomValidator {
  private static final Logger logger = LoggerFactory.getLogger(CustomValidatorImpl.class);
  private static final String REGEX = "^[+-]?[1-9]\\d*$";

  @Override
  public boolean isElementValid(String element, Pattern pattern) {
    return pattern.matcher(element).matches();
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