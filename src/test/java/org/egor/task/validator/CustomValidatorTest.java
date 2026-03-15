package org.egor.task.validator;

import org.egor.task.validator.impl.CustomValidatorImpl;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.egor.task.TestVariable.LINE_OF_INTS;
import static org.egor.task.TestVariable.TEST_ELEMENT;
import static org.egor.task.validator.impl.CustomValidatorImpl.CORRECT_NUMBER;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomValidatorTest {
  private final CustomValidator validator = new CustomValidatorImpl();
  private final Pattern pattern = Pattern.compile(CORRECT_NUMBER);

  @Test
  void shouldValidateElement() {
    boolean actual = validator.isElementValid(TEST_ELEMENT, pattern);
    assertTrue(actual);
  }

  @Test
  void shouldValidateLineOfInts() {
    boolean actual = validator.isLineOfIntsValid(LINE_OF_INTS);
    assertTrue(actual);
  }
}
