package org.task.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.entity.IntArray;
import org.task.exception.IntArrayException;
import org.task.service.MathOperationsService;
import org.task.validator.Impl.CustomValidatorImpl;

public class MathOperationsServiceImpl implements MathOperationsService {
  private static final Logger logger = LoggerFactory.getLogger(MathOperationsServiceImpl.class);
  private static final CustomValidatorImpl validator = new CustomValidatorImpl();

  @Override
  public int min(IntArray array) throws IntArrayException {
    if (validator.isArrayValid(array.getIntArray())) {
      logger.info("Trying to find min element.");
      int min = array.getElement(0);
      int element;
      for (int i = 1; i < array.getLength(); i++) {
        element = array.getElement(i);
        if (element < min) {
          min = element;
        }
      }
      logger.info("Min element is find.");
      return min;
    } else {
      logger.error("Failed to find min element. Array is null");
      throw new IntArrayException("Array is null.");
    }
  }

  @Override
  public int max(IntArray array) throws IntArrayException {
    if (validator.isArrayValid(array.getIntArray())) {
      logger.info("Trying to find max element.");
      int max = array.getElement(0);
      int element;
      for (int i = 1; i < array.getLength(); i++) {
        element = array.getElement(i);
        if (element > max) {
          max = element;
        }
      }
      logger.info("Max element is find.");
      return max;
    } else {
      logger.error("Failed to find max element. Array is null.");
      throw new IntArrayException("Array is null.");
    }
  }

  @Override
  public int sum(IntArray array) throws IntArrayException {
    if (validator.isArrayValid(array.getIntArray())) {
      int sum = 0;
      for (int i : array.getIntArray()) {
        sum += i;
      }
      return sum;
    } else {
      logger.error("Failed to find sum of an array. Array is null.");
      throw new IntArrayException("Array is null.");
    }
  }
}