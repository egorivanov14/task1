package org.egor.task.parser;

import org.egor.task.TestVariable;
import org.egor.task.exception.CustomIntArrayParserException;
import org.egor.task.exception.IntArrayException;
import org.egor.task.parser.impl.CustomIntArrayParserImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CustomArrayParserTest {
  private final CustomIntArrayParser parser = new CustomIntArrayParserImpl();

  @Test
  void shouldParseLineOfInts() throws IntArrayException {
    int[] actual = null;
    try {
      actual = parser.parseToIntArray(TestVariable.LINE_OF_INTS);
    } catch (CustomIntArrayParserException e) {
      throw new RuntimeException(e);
    }
    int[] excepted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    assertArrayEquals(excepted, actual);
  }
}