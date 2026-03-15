package org.egor.task.parser;

import org.egor.task.exception.IntArrayException;
import org.egor.task.parser.impl.CustomIntArrayParserImpl;
import org.junit.jupiter.api.Test;

import static org.egor.task.TestVariable.LINE_OF_INTS;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CustomArrayParserTest {
  private final CustomIntArrayParser parser = new CustomIntArrayParserImpl();

  @Test
  void shouldParseLineOfInts() throws IntArrayException {
    int[] actual = parser.parseToIntArray(LINE_OF_INTS);
    int[] excepted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    assertArrayEquals(excepted, actual);
  }
}