package org.egor.task.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.service.SortService;

public class SortServiceImpl implements SortService {
  private static final Logger logger = LoggerFactory.getLogger(SortServiceImpl.class);

  @Override
  public IntArray quickSort(IntArray array) throws IntArrayException {
    logger.info("Start of quick sort.");
    if (array != null && array.getLength() != 0) {
      IntArray sortedArray = quickSortImpl(array, 0, array.getLength() - 1);
      logger.info("IntArray is sorted by quick sort.");
      return sortedArray;
    } else {
      assert array != null;
      if (array.getLength() < 2 && array.getLength() > 0) {
        logger.info("End of quick sort. You do not need sorting. Array is too short.");
        return array;
      } else {
        logger.error("Failed to use quick sort. Array is null.");
        throw new IntArrayException("Array is null.");
      }
    }
  }

  @Override
  public IntArray bubbleSort(IntArray array) throws IntArrayException {
    if (array != null && array.getLength() != 0) {
      logger.info("Start of bubble sort.");
      int permutations = 0;
      int length = array.getLength();
      while (length > 1) {
        for (int i = 1; i < length; i++) {
          int first = array.getElement(i - 1);
          int second = array.getElement(i);
          if (first > second) {
            int temp = first;
            array.setElement(i - 1, second);
            array.setElement(i, temp);
            permutations++;
          }
        }
        if (permutations == 0) {
          logger.info("Successful sorting by bubble sort.");
          return array;
        } else {
          length--;
        }
      }
      logger.info("Successful sorting by bubble sort.");
      return array;
    } else {
      logger.error("Failed to use bubble sort. Array is null or empty.");
      throw new IntArrayException("Array is null or empty.");
    }
  }

  private IntArray quickSortImpl(IntArray array, int low, int high) throws IntArrayException {
    if (low < high) {
      int i = partition(array, low, high);
      quickSortImpl(array, low, i - 1);
      quickSortImpl(array, i + 1, high);
    }

    return array;
  }

  private int partition(IntArray array, int low, int high) throws IntArrayException {
    int pivot = array.getElement(high);
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (array.getElement(j) < pivot) {
        i++;
        swap(array, j, i);
      }
    }
    swap(array, high, i + 1);
    return i + 1;
  }

  private void swap(IntArray array, int firstIndex, int secondIndex) throws IntArrayException {
    int temp = array.getElement(firstIndex);
    array.setElement(firstIndex, array.getElement(secondIndex));
    array.setElement(secondIndex, temp);
  }
}