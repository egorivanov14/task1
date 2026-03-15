package org.egor.task.service.impl;

import org.egor.task.service.MathOperationsService;
import org.egor.task.validator.impl.CustomValidatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.OptionalInt;

public class MathOperationsServiceImpl implements MathOperationsService {
  private static final Logger logger = LoggerFactory.getLogger(MathOperationsServiceImpl.class);
  private final CustomValidatorImpl validator = new CustomValidatorImpl();

  @Override
  public OptionalInt min(int[] array) {
    try {
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
      return OptionalInt.of(min);
    } catch (Exception e) {
      logger.warn("Failed to fined min element. Return empty OptionalInt.");
      return OptionalInt.empty();
    }
  }

  @Override
  public OptionalInt max(int[] array) {
    try {
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
      return OptionalInt.of(max);
    } catch (Exception e) {
      logger.warn("Failed to fined max element. Return empty OptionalInt.");
      return OptionalInt.empty();
    }
  }

  @Override
  public OptionalInt sum(int[] array) {
    try {
      int sum = 0;
      for (int element : array) {
        sum += element;
      }
      return OptionalInt.of(sum);
    } catch (Exception e) {
      logger.warn("Failed to fined sum of array. Return empty OptionalInt.");
      return OptionalInt.empty();
    }
  }
}