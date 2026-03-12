package org.egor.task.validator;

import java.util.regex.Pattern;

public interface CustomValidator {
  boolean isElementValid(String element, Pattern pattern);

  boolean isLineOfIntsValid(String lineOfInts);
}