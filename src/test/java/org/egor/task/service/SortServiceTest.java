package org.egor.task.service;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.service.impl.SortServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.egor.task.TestVariable.ARRAY_TO_TEST;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortServiceTest {
  private final SortService sortService = new SortServiceImpl();

  @Test
  void shouldSortIntArrayByQuickSort() throws IntArrayException {
    IntArray array = ARRAY_TO_TEST;
    int[] correctSortArray = array.getIntArray();
    Arrays.sort(correctSortArray);
    array = sortService.quickSort(array);
    assertArrayEquals(correctSortArray, array.getIntArray());
  }

  @Test
  void shouldSortIntArrayByBubbleSort() throws IntArrayException {
    IntArray array = ARRAY_TO_TEST;
    int[] correctSortArray = array.getIntArray();
    Arrays.sort(correctSortArray);
    array = sortService.bubbleSort(array);
    assertArrayEquals(correctSortArray, array.getIntArray());
  }
}
