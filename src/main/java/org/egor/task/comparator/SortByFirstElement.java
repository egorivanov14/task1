package org.egor.task.comparator;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.ComparatorException;
import org.egor.task.exception.IntArrayException;

import java.util.Comparator;

public class SortByFirstElement implements Comparator<IntArray> {

  @Override
  public int compare(IntArray intArray1, IntArray intArray2) {
    if (intArray1 == null && intArray2 == null) {
      return 0;
    }
    if (intArray1 == null) {
      return -1;
    }
    if (intArray2 == null) {
      return 1;
    }

    try {
      int firstElement1 = getFirstElement(intArray1);
      int firstElement2 = getFirstElement(intArray2);
      if (firstElement1 > firstElement2) {
        return 1;
      } else if (firstElement1 < firstElement2) {
        return -1;
      } else {
        return 0;
      }
    } catch (ComparatorException e) {
      return 0;
    }
  }

  private int getFirstElement(IntArray array) throws ComparatorException {
    try {
      return array.getElement(0);
    } catch (IntArrayException e) {
      throw new ComparatorException("Failed to get first element of array.", e);
    }
  }
}