package org.egor.task.factory.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.factory.CustomIntArrayFactory;
import org.egor.task.factory.IntArrayParameters;
import org.egor.task.validator.impl.CustomValidatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomIntArrayFactoryImpl implements CustomIntArrayFactory {
  private static final Logger logger = LoggerFactory.getLogger(CustomIntArrayFactoryImpl.class);
  private static final CustomValidatorImpl validator = new CustomValidatorImpl();

  @Override
  public IntArray createIntArrayBySizeAndName(String name, int size) {
    logger.info("Creating IntArray by size.");
    return new IntArray(name, size);
  }

  @Override
  public IntArray createEmptyIntArray() {
    logger.info("Creating empty IntArray.");
    return new IntArray();
  }

  @Override
  public IntArray createIntArray(String name, int[] array) throws IntArrayException {
    if (array != null && array.length != 0) {
      logger.info("Creating IntArray.");
      return new IntArray(name, array);
    } else {
      logger.error("Failed to create IntArray. Input array is null or  empty.");
      throw new IntArrayException("Input array is null or empty.");
    }
  }

  @Override
  public IntArray createRandomIntArray(String name, int size) throws IntArrayException {
    logger.info("Creating RANDOM IntArray.");
    IntArray newArray = new IntArray(name, size);

    for (int i = 0; i < size; i++) {
      newArray.setElement(i, IntArrayParameters.RANDOM.nextInt());
    }
    return newArray;
  }
}