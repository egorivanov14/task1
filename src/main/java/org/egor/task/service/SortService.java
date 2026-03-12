package org.egor.task.service;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;

public interface SortService {
  IntArray quickSort(IntArray array) throws IntArrayException;

  IntArray bubbleSort(IntArray array) throws IntArrayException;
}