package org.egor.task.observer.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.observer.Observer;
import org.egor.task.service.MathOperationsService;
import org.egor.task.service.impl.MathOperationsServiceImpl;
import org.egor.task.warehouse.IntArrayStats;
import org.egor.task.warehouse.IntArrayWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntArrayObserver implements Observer {
  private static final Logger logger = LoggerFactory.getLogger(IntArrayObserver.class);
  private final IntArrayWarehouse intArrayWarehouse = IntArrayWarehouse.getIntArrayWarehouse();
  private final MathOperationsService mathService = new MathOperationsServiceImpl();

  @Override
  public void update(String id, int[] array) throws IntArrayException {
    logger.info("IntArrayObserver is updating array with id {}", id);
    IntArrayStats newIntArrayStats = getStats(array);
    intArrayWarehouse.changeIntArrayStats(id, newIntArrayStats);
  }

  @Override
  public void add(IntArray array) throws IntArrayException {
    logger.info("IntArrayObserver is adding array.");
    IntArrayStats intArrayStats = getStats(array.getIntArray());
    intArrayWarehouse.putIntArrayStats(array.getId(), intArrayStats);
  }

  @Override
  public void delete(String id) {
    logger.info("IntArrayObserver is deleting array with id {}", id);
    intArrayWarehouse.removeIntArrayStats(id);
  }

  private IntArrayStats getStats(int[] array) throws IntArrayException {
    logger.info("Creating IntArrayStats.");
    int min = mathService.min(array);
    int max = mathService.max(array);
    int sum = mathService.sum(array);
    double average = (double) sum / array.length;

    return new IntArrayStats(min, max, sum, average);
  }
}