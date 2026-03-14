package org.egor.task.repository;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class IntArrayRepository {
  private static final Logger logger = LoggerFactory.getLogger(IntArrayRepository.class);
  private static IntArrayRepository intArrayRepository;
  private final List<Observer> observers;
  private final List<IntArray> intArrays;

  private IntArrayRepository() {
    logger.info("Creating new IntArrayRepository.");
    this.observers = new ArrayList<>();
    this.intArrays = new ArrayList<>();
  }

  public static IntArrayRepository getIntArrayRepository() {
    logger.info("getIntArrayRepository() is called.");
    if (intArrayRepository == null) {
      intArrayRepository = new IntArrayRepository();
    }
    return intArrayRepository;
  }

  public void setObserver(Observer observer) {
    logger.info("Setting new observer to IntArrayRepository.");
    if (observer != null) {
      this.observers.add(observer);
    }
  }

  public void save(IntArray intArray) throws IntArrayException {
    if (intArray != null) {
      logger.info("Saving intArray to repository with id {}", intArray.getId());
      this.intArrays.add(intArray);
      for (Observer observer : observers) {
        intArray.addObserver(observer);
        observer.add(intArray);
      }
    }
    else {
      throw new IntArrayException("Int array is null.");
    }
  }

  public void delete(String id) {
    logger.info("Deleting intArray from repository with id {}", id);
    for (IntArray intArray : intArrays) {
      if (intArray.getId().equals(id)) {
        intArrays.remove(intArray);
        for (Observer observer : observers) {
          observer.delete(id);
        }
      }
    }
  }
}