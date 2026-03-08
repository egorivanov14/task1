package org.task.factory.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.entity.IntArray;
import org.task.exception.IntArrayException;
import org.task.factory.CustomIntArrayFactory;
import org.task.validator.Impl.CustomValidatorImpl;

import java.util.Random;

public class CustomIntArrayFactoryImpl implements CustomIntArrayFactory {
  private static final Logger logger = LoggerFactory.getLogger(CustomIntArrayFactoryImpl.class);
  private static final CustomValidatorImpl validator = new CustomValidatorImpl();

  @Override
  public IntArray createEmptyIntArray(int size) {
    logger.info("Creating empty IntArray.");
    return new IntArray(size);
  }

  @Override
  public IntArray createIntArray(int[] array) throws IntArrayException {
    if (validator.isArrayValid(array)) {
      logger.info("Creating IntArray.");
      return new IntArray(array);
    } else {
      logger.error("Failed to create IntArray. Input array is null.");
      throw new IntArrayException("Input array is null.");
    }
  }

  @Override
  public IntArray createRandomIntArray(int size) throws IntArrayException {
    logger.info("Creating random IntArray.");
    IntArray newArray = new IntArray(size);
    Random random = new Random();

    for (int i = 0; i < size; i++) {
      newArray.setElement(i, random.nextInt());
    }
    return newArray;
  }
}
