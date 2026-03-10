package org.task;

import org.junit.jupiter.api.Test;
import org.task.entity.IntArray;
import org.task.exception.IntArrayException;
import org.task.parser.CustomIntArrayParser;
import org.task.parser.Impl.CustomIntArrayParserImpl;
import org.task.service.Impl.MathOperationsServiceImpl;
import org.task.service.Impl.SortServiceImpl;
import org.task.service.MathOperationsService;
import org.task.service.SortService;
import org.task.validator.CustomValidator;
import org.task.validator.Impl.CustomValidatorImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class IntArrayTest {
  private final CustomIntArrayParser intArrayParser = new CustomIntArrayParserImpl();
  private final SortService sortService = new SortServiceImpl();
  private final MathOperationsService mathOperationsService = new MathOperationsServiceImpl();
  private final CustomValidator validator = new CustomValidatorImpl();

  @Test
  void shouldParseLineToIntArray() throws IOException, IntArrayException {
    String line = "1,2,3,4,5,6,7,8,9,0";
    int[] correctArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int[] array = intArrayParser.parseToIntArray(line);
    assertArrayEquals(correctArray, array);
  }

  @Test
  void shouldCountSumOfIntArray() throws IntArrayException {
    IntArray intArray = getRandomIntArray(50);
    int correctSum = Arrays.stream(intArray.getIntArray()).sum();
    int sum = mathOperationsService.sum(intArray);
    assertEquals(correctSum, sum);
  }

  @Test
  void shouldSortIntArrayByQuickSort() throws IntArrayException {
    IntArray array = getRandomIntArray(50);
    int[] correctSortArray = array.getIntArray();
    Arrays.sort(correctSortArray);
    array = sortService.quickSort(array);
    assertArrayEquals(correctSortArray, array.getIntArray());
  }

  @Test
  void shouldSortIntArrayByBubbleSort() throws IntArrayException {
    IntArray array = getRandomIntArray(50);
    int[] correctSortArray = array.getIntArray();
    Arrays.sort(correctSortArray);
    array = sortService.bubbleSort(array);
    assertArrayEquals(correctSortArray, array.getIntArray());
  }

  @Test
  void shouldAcceptElement() {
    String element = "123";
    assertTrue(validator.isElementValid(element, validator.getCompilePattern()));
  }

  @Test
  void shouldAcceptLineOfInts() {
    String lineOfInts = "1,2,3,4,5,6:7;8.9-0";
    assertTrue(validator.isLineOfIntsValid(lineOfInts));
  }

  private IntArray getRandomIntArray(int size) throws IntArrayException {
    Random random = new Random();
    IntArray randomArray = new IntArray(size);
    for (int i = 0; i < size; i++) {
      randomArray.setElement(i, random.nextInt());
    }
    return randomArray;
  }
}
