package org.egor.task.comparator;

import org.egor.task.entity.IntArray;

import java.util.Comparator;

public class SortByLength implements Comparator<IntArray> {
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

    int length1 = intArray1.getLength();
    int length2 = intArray2.getLength();
    if (length1 > length2) {
      return 1;
    } else if (length1 < length2) {
      return -1;
    } else {
      return 0;
    }
  }
}