package org.egor.task.repository;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayRepositoryException;
import org.egor.task.exception.ObserverException;
import org.egor.task.observer.Observer;
import org.egor.task.specification.SearchType;
import org.egor.task.specification.impl.*;
import org.egor.task.warehouse.IntArrayStats;
import org.egor.task.warehouse.IntArrayWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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

  public void save(IntArray intArray) throws IntArrayRepositoryException {
    if (intArray != null) {
      logger.info("Saving intArray to repository with id {}", intArray.getId());
      this.intArrays.add(intArray);
      for (Observer observer : observers) {
        intArray.addObserver(observer);
        try {
          observer.add(intArray);
        } catch (ObserverException e) {
          throw new RuntimeException(e);
        }
      }
    } else {
      throw new IntArrayRepositoryException("Failed to save IntArray to repository. Int array is null.");
    }
  }

  public void remove(String id) {
    logger.info("Deleting intArray from repository with id {}", id);
    intArrays.removeIf(intArray -> intArray.getId().equals(id));
    for (Observer observer : observers) {
      observer.remove(id);
    }
  }

  public Optional<IntArray> getById(String id) {
    IdSpecification specification = new IdSpecification(id);
    for (IntArray element : intArrays) {
      if (specification.isSatisfiedBy(element)) {
        return Optional.of(element);
      }
    }
    return Optional.empty();
  }

  public List<IntArray> findByName(String name) {
    List<IntArray> intArrayList = new ArrayList<>();
    NameSpecification specification = new NameSpecification(name);
    for (IntArray element : intArrays) {
      if (specification.isSatisfiedBy(element)) {
        intArrayList.add(element);
      }
    }
    return intArrayList;
  }

  public List<IntArray> getAllBySum(int sum, SearchType searchType) {
    List<IntArray> intArrayList = new ArrayList<>();
    IntArrayWarehouse warehouse = IntArrayWarehouse.getIntArrayWarehouse();
    SumSpecification specification = new SumSpecification(sum, searchType);

    for (IntArray element : intArrays) {
      String elementId = element.getId();
      IntArrayStats candidate = warehouse.getStatsById(elementId);
      if (specification.isSatisfiedBy(candidate)) {
        intArrayList.add(element);
      }
    }
    return intArrayList;
  }

  public List<IntArray> getAllByAverage(int average, SearchType searchType) {
    List<IntArray> intArrayList = new ArrayList<>();
    IntArrayWarehouse warehouse = IntArrayWarehouse.getIntArrayWarehouse();
    AverageSpecification specification = new AverageSpecification(average, searchType);

    for (IntArray element : intArrays) {
      String elementId = element.getId();
      IntArrayStats candidate = warehouse.getStatsById(elementId);
      if (specification.isSatisfiedBy(candidate)) {
        intArrayList.add(element);
      }
    }
    return intArrayList;
  }

  public List<IntArray> getAllByMax(int max, SearchType searchType) {
    List<IntArray> intArrayList = new ArrayList<>();
    IntArrayWarehouse warehouse = IntArrayWarehouse.getIntArrayWarehouse();
    MaxSpecification specification = new MaxSpecification(max, searchType);

    for (IntArray element : intArrays) {
      String elementId = element.getId();
      IntArrayStats candidate = warehouse.getStatsById(elementId);
      if (specification.isSatisfiedBy(candidate)) {
        intArrayList.add(element);
      }
    }
    return intArrayList;
  }

  public List<IntArray> getAllByMin(int min, SearchType searchType) {
    List<IntArray> intArrayList = new ArrayList<>();
    IntArrayWarehouse warehouse = IntArrayWarehouse.getIntArrayWarehouse();
    MinSpecification specification = new MinSpecification(min, searchType);

    for (IntArray element : intArrays) {
      String elementId = element.getId();
      IntArrayStats candidate = warehouse.getStatsById(elementId);
      if (specification.isSatisfiedBy(candidate)) {
        intArrayList.add(element);
      }
    }
    return intArrayList;
  }

  public List<IntArray> getAllByLength(int length, SearchType searchType) {
    List<IntArray> intArrayList = new ArrayList<>();
    LengthSpecification specification = new LengthSpecification(length, searchType);
    for (IntArray element : intArrays) {
      if (specification.isSatisfiedBy(element)) {
        intArrayList.add(element);
      }
    }
    return intArrayList;
  }
}