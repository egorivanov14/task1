package org.task;

import org.junit.jupiter.api.Test;
import org.task.entity.IntArray;
import org.task.exception.IntArrayException;
import org.task.factory.CustomIntArrayFactory;
import org.task.factory.Impl.CustomIntArrayFactoryImpl;
import org.task.parser.CustomIntArrayParser;
import org.task.parser.Impl.CustomIntArrayParserImpl;
import org.task.reader.CustomFileReader;
import org.task.reader.Impl.CustomFileReaderImpl;
import org.task.service.Impl.MathOperationsServiceImpl;
import org.task.service.Impl.SortServiceImpl;
import org.task.service.MathOperationsService;
import org.task.service.SortService;
import org.task.validator.CustomValidator;
import org.task.validator.Impl.CustomValidatorImpl;
import org.task.writer.CustomFileWriter;
import org.task.writer.Impl.CustomFileWriterImpl;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class IntArrayTest {
  private final CustomIntArrayFactory intArrayFactory = new CustomIntArrayFactoryImpl();
  private final CustomIntArrayParser intArrayParser = new CustomIntArrayParserImpl();
  private final CustomFileReader fileReader = new CustomFileReaderImpl();
  private final SortService sortService = new SortServiceImpl();
  private final MathOperationsService mathOperationsService = new MathOperationsServiceImpl();
  private final CustomValidator validator = new CustomValidatorImpl();
  private final CustomFileWriter fileWriter = new CustomFileWriterImpl();

  @Test
  void shouldCreateNewIntArrayWithMyValues() throws IntArrayException {
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    IntArray intArray = intArrayFactory.createIntArray(array);
    assertArrayEquals(intArray.getIntArray(), array);
  }

  @Test
  void shouldCreateNewEmptyIntArray() {
    IntArray intArray = intArrayFactory.createEmptyIntArray();
    int[] emptyArray = new int[0];
    assertArrayEquals(intArray.getIntArray(), emptyArray);
  }

  @Test
  void shouldCreateNewDefaultIntArrayBySize() {
    int size = 9;
    IntArray intArray = intArrayFactory.createIntArrayBySize(9);
    assertEquals(size, intArray.getLength());
  }

  @Test
  void shouldParseLineToIntArray() throws IOException, IntArrayException {
    String line = "1,2,3,4,5,6,7,8,9,0";
    int[] correctArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int[] array = intArrayParser.parseToIntArray(line);
    assertArrayEquals(correctArray, array);
  }

  @Test
  void shouldCountSumOfIntArray() throws IntArrayException {
    IntArray array = intArrayFactory.createRandomIntArray(10);
    int correctSum = Arrays.stream(array.getIntArray()).sum();
    int sum = mathOperationsService.sum(array);
    assertEquals(correctSum, sum);
  }

  @Test
  void shouldSortIntArrayByQuickSort() throws IntArrayException {
    IntArray array = intArrayFactory.createRandomIntArray(50);
    int[] correctSortArray = array.getIntArray();
    Arrays.sort(correctSortArray);
    array = sortService.quickSort(array);
    assertArrayEquals(correctSortArray, array.getIntArray());
  }

  @Test
  void shouldSortIntArrayByBubbleSort() throws IntArrayException {
    IntArray array = intArrayFactory.createRandomIntArray(50);
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
}
