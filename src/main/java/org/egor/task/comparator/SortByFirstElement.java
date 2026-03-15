package org.egor.task.comparator;

import java.util.Comparator;

public class SortByFirstElement implements Comparator<Integer> {
  @Override
  public int compare(Integer element1, Integer element2) {
    if (element1 > element2) {
      return 1;
    } else if (element1 < element2) {
      return -1;
    }
    return 0;
  }
}