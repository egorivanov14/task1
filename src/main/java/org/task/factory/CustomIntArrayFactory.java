package org.task.factory;

import org.task.entity.IntArray;
import org.task.exception.IntArrayException;

public interface CustomIntArrayFactory {
  IntArray createIntArrayBySize(int size);

  IntArray createEmptyIntArray();

  IntArray createIntArray(int[] array) throws IntArrayException;

  IntArray createRandomIntArray(int size) throws IntArrayException;
}