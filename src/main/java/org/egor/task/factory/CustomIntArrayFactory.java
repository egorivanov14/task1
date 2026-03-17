package org.egor.task.factory;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayFactoryException;

public interface CustomIntArrayFactory {
  IntArray createIntArrayBySizeAndName(String name , int size);

  IntArray createEmptyIntArray();

  IntArray createIntArray(String name ,int[] array) throws IntArrayFactoryException;

  IntArray createRandomIntArray(String name ,int size) throws IntArrayFactoryException;
}