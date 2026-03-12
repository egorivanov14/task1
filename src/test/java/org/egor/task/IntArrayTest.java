package org.egor.task;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.parser.CustomIntArrayParser;
import org.egor.task.parser.impl.CustomIntArrayParserImpl;
import org.egor.task.service.MathOperationsService;
import org.egor.task.service.SortService;
import org.egor.task.service.impl.MathOperationsServiceImpl;
import org.egor.task.service.impl.SortServiceImpl;
import org.egor.task.validator.CustomValidator;
import org.egor.task.validator.impl.CustomValidatorImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

import static org.egor.task.validator.impl.CustomValidatorImpl.CORRECT_NUMBER;
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
    int sum = mathOperationsService.sum(intArray.getIntArray());
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
    Pattern pattern = Pattern.compile(CORRECT_NUMBER);
    assertTrue(validator.isElementValid(element, pattern));
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
