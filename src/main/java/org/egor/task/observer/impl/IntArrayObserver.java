package org.egor.task.observer.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayMathException;
import org.egor.task.exception.ObserverException;
import org.egor.task.observer.Observer;
import org.egor.task.service.MathOperationsService;
import org.egor.task.service.impl.MathOperationsServiceImpl;
import org.egor.task.warehouse.IntArrayStats;
import org.egor.task.warehouse.IntArrayWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.OptionalInt;

public class IntArrayObserver implements Observer {
  private static final Logger logger = LoggerFactory.getLogger(IntArrayObserver.class);
  private final IntArrayWarehouse intArrayWarehouse = IntArrayWarehouse.getIntArrayWarehouse();
  private final MathOperationsService mathService = new MathOperationsServiceImpl();

  @Override
  public void update(String id, int[] array) throws ObserverException {
    try{
      logger.info("IntArrayObserver is updating array with id {}", id);
      IntArrayStats newIntArrayStats = getStats(array);
      intArrayWarehouse.changeIntArrayStats(id, newIntArrayStats);
    }catch(IntArrayMathException e){
      throw new ObserverException("failed to update IntArrayWarehouse.", e);
    }
  }

  @Override
  public void add(IntArray array) throws ObserverException {
    try{
      logger.info("IntArrayObserver is adding array.");
      IntArrayStats intArrayStats = getStats(array.getIntArray());
      intArrayWarehouse.putIntArrayStats(array.getId(), intArrayStats);
    }catch (IntArrayMathException e){
      throw new ObserverException("Failed to add IntArrayStats to warehouse.", e);
    }
  }

  @Override
  public void remove(String id) {
    logger.info("IntArrayObserver is deleting array with id {}", id);
    intArrayWarehouse.removeIntArrayStats(id);
  }

  private IntArrayStats getStats(int[] array) throws IntArrayMathException {
    logger.info("Creating IntArrayStats.");
    OptionalInt min = mathService.min(array);
    OptionalInt max = mathService.max(array);
    OptionalInt sum = mathService.sum(array);
    if (min.isPresent() && max.isPresent() && sum.isPresent()) {
      double average = (double) sum.getAsInt() / array.length;
      return new IntArrayStats(min.getAsInt(), max.getAsInt(), sum.getAsInt(), average);
    } else {
      logger.error("Failed to calculate statistic of array.");
      throw new IntArrayMathException("Failed to get statistic of array.");
    }
  }
}