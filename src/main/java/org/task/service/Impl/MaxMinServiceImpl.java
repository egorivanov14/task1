package org.task.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.entity.IntArray;
import org.task.exception.IntArrayException;
import org.task.service.MaxMinService;

public class MaxMinServiceImpl implements MaxMinService {
  private static final Logger logger = LoggerFactory.getLogger(MaxMinServiceImpl.class);

  @Override
  public int min(IntArray array) throws IntArrayException {
    if (array == null) {
      logger.error("Failed to find min element. Array is null");
      throw new IntArrayException("Array is null.");
    }
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
  }

  @Override
  public int max(IntArray array) throws IntArrayException {
    if (array == null) {
      logger.error("Failed to find max element. Array is null.");
      throw new IntArrayException("Array is null.");
    }

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
  }
}