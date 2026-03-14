package org.egor.task.factory;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;

public interface CustomIntArrayFactory {
  IntArray createIntArrayBySizeAndName(String name , int size);

  IntArray createEmptyIntArray();

  IntArray createIntArray(String name ,int[] array) throws IntArrayException;

  IntArray createRandomIntArray(String name ,int size) throws IntArrayException;
}