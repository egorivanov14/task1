package org.task.validator;

import java.util.regex.Pattern;

public interface CustomValidator {
  boolean isElementValid(String element, Pattern pattern);

  Pattern getCompilePattern();

  boolean isArrayValid(int[] array);
}