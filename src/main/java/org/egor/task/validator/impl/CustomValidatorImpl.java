package org.egor.task.validator.impl;

import org.egor.task.validator.CustomValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class CustomValidatorImpl implements CustomValidator {
  private static final Logger logger = LoggerFactory.getLogger(CustomValidatorImpl.class);
  private static final String SYMBOLS = "[\\p{L}\\p{M}]+";
  public static final String CORRECT_NUMBER = "^[+-]?[1-9]\\d*$";

  @Override
  public boolean isElementValid(String element, Pattern pattern) {
    return pattern.matcher(element).matches();
  }

  @Override
  public boolean isLineOfIntsValid(String lineOfInts) {
    return !lineOfInts.contains(SYMBOLS);
  }
}