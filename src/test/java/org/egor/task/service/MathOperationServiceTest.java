package org.egor.task.service;

import org.egor.task.service.impl.MathOperationsServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalInt;

import static org.egor.task.TestVariable.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathOperationServiceTest {
  private final MathOperationsService mathService = new MathOperationsServiceImpl();

  @Test
  void shouldFindMinElementInIntArray(){
    OptionalInt actual = mathService.min(ARRAY_TO_TEST.getIntArray());
    int excepted = Arrays.stream(ARRAY_TO_TEST.getIntArray()).min().getAsInt();
    assertEquals(excepted, actual.getAsInt());
  }

  @Test
  void shouldFindMaxElementInIntArray(){
    OptionalInt actual = mathService.max(ARRAY_TO_TEST.getIntArray());
    int excepted = Arrays.stream(ARRAY_TO_TEST.getIntArray()).max().getAsInt();
    assertEquals(excepted, actual.getAsInt());
  }

  @Test
  void shouldFindSumOfElementsOfInIntArray(){
    OptionalInt actual = mathService.sum(ARRAY_TO_TEST.getIntArray());
    int excepted = Arrays.stream(ARRAY_TO_TEST.getIntArray()).sum();
    assertEquals(excepted, actual.getAsInt());
  }
}
