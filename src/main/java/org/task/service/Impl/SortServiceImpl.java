package org.task.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.entity.IntArray;
import org.task.exception.IntArrayException;
import org.task.service.SortService;
import org.task.validator.Impl.CustomValidatorImpl;

public class SortServiceImpl implements SortService {
  private static final Logger logger = LoggerFactory.getLogger(SortServiceImpl.class);
  private static final CustomValidatorImpl validator = new CustomValidatorImpl();

  @Override
  public IntArray quickSort(IntArray array) throws IntArrayException {
    logger.info("Start of quick sort.");
    if (validator.isArrayValid(array.getIntArray())) {
      return quickSortImpl(array, 0, array.getLength() - 1);
    } else if (array.getLength() < 2) {
      logger.info("End of quick sort. You do not need sorting. Array is too short.");
      return array;
    } else {
      logger.error("Failed to sort array. Array is null.");
      throw new IntArrayException("Array is null.");
    }
  }

  @Override
  public IntArray mergeSort(IntArray array) {
    return null;
  }

  private IntArray quickSortImpl(IntArray array, int low, int high) throws IntArrayException {
    if (low < high) {
      int i = partition(array, low, high);
      quickSortImpl(array, low, i - 1);
      quickSortImpl(array, i + 1, high);
    }

    logger.info("Array is sorted by quick sort.");
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
