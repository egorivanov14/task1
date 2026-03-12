package org.egor.task.factory.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.factory.CustomIntArrayFactory;
import org.egor.task.validator.impl.CustomValidatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.egor.task.entity.IntArray.random;

public class CustomIntArrayFactoryImpl implements CustomIntArrayFactory {
  private static final Logger logger = LoggerFactory.getLogger(CustomIntArrayFactoryImpl.class);
  private static final CustomValidatorImpl validator = new CustomValidatorImpl();

  @Override
  public IntArray createIntArrayBySize(int size) {
    logger.info("Creating IntArray by size.");
    return new IntArray(size);
  }

  @Override
  public IntArray createEmptyIntArray() {
    logger.info("Creating empty IntArray.");
    return new IntArray();
  }

  @Override
  public IntArray createIntArray(int[] array) throws IntArrayException {
    if (array != null && array.length != 0) {
      logger.info("Creating IntArray.");
      return new IntArray(array);
    } else {
      logger.error("Failed to create IntArray. Input array is null or  empty.");
      throw new IntArrayException("Input array is null or empty.");
    }
  }

  @Override
  public IntArray createRandomIntArray(int size) throws IntArrayException {
    logger.info("Creating random IntArray.");
    IntArray newArray = new IntArray(size);

    for (int i = 0; i < size; i++) {
      newArray.setElement(i, random.nextInt());
    }
    return newArray;
  }
}