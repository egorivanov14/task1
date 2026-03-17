package org.egor.task.service;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayMathException;

public interface SortService {
  IntArray quickSort(IntArray array) throws IntArrayMathException;

  IntArray bubbleSort(IntArray array) throws IntArrayMathException;
}