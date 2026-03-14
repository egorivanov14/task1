package org.egor.task.comparator;

import org.egor.task.entity.IntArray;

import java.util.Comparator;

public class SortByName implements Comparator<IntArray> {
  @Override
  public int compare(IntArray intArray1, IntArray intArray2) {
    String name1 = intArray1.getName();
    String name2 = intArray2.getName();
    return name1.compareTo(name2);
  }
}