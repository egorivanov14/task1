package org.egor.task.service.impl;

import org.egor.task.exception.IntArrayException;
import org.egor.task.service.MathOperationsService;
import org.egor.task.validator.impl.CustomValidatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathOperationsServiceImpl implements MathOperationsService {
  private static final Logger logger = LoggerFactory.getLogger(MathOperationsServiceImpl.class);
  private final CustomValidatorImpl validator = new CustomValidatorImpl();

  @Override
  public int min(int[] array) throws IntArrayException {
    if (array != null && array.length != 0) {
      logger.info("Trying to find min element.");
      int min = array[0];
      int element;
      for (int i = 1; i < array.length; i++) {
        element = array[i];
        if (element < min) {
          min = element;
        }
      }
      logger.info("Min element is find.");
      return min;
    } else {
      logger.error("Failed to find min element. Array is null or empty");
      throw new IntArrayException("Array is null or empty.");
    }
  }

  @Override
  public int max(int[] array) throws IntArrayException {
    if (array != null && array.length != 0) {
      logger.info("Trying to find max element.");
      int max = array[0];
      int element;
      for (int i = 1; i < array.length; i++) {
        element = array[i];
        if (element > max) {
          max = element;
        }
      }
      logger.info("Max element is find.");
      return max;
    } else {
      logger.error("Failed to find max element. Array is null or empty.");
      throw new IntArrayException("Array is null or empty.");
    }
  }

  @Override
  public int sum(int[] array) throws IntArrayException {
    if (array != null && array.length != 0) {
      int sum = 0;
      for (int element : array) {
        sum += element;
      }
      return sum;
    } else {
      logger.error("Failed to find sum of an array. Array is null or empty.");
      throw new IntArrayException("Array is null or empty.");
    }
  }
}