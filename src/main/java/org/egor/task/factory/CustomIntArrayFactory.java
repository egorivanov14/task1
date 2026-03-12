package org.egor.task.factory;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;

public interface CustomIntArrayFactory {
  IntArray createIntArrayBySize(int size);

  IntArray createEmptyIntArray();

  IntArray createIntArray(int[] array) throws IntArrayException;

  IntArray createRandomIntArray(int size) throws IntArrayException;
}