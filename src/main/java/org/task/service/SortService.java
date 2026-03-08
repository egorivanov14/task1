package org.task.service;

import org.task.entity.IntArray;
import org.task.exception.IntArrayException;

public interface SortService {
  IntArray quickSort(IntArray array) throws IntArrayException;

  IntArray bubbleSort(IntArray array) throws IntArrayException;
}