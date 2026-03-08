package org.task.factory;

import org.task.entity.IntArray;
import org.task.exception.IntArrayException;

public interface CustomIntArrayFactory {
  IntArray createEmptyIntArray(int size);

  IntArray createIntArray(int[] array);

  IntArray createRandomIntArray(int size) throws IntArrayException;
}
