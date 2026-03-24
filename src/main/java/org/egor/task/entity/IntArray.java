package org.egor.task.entity;

import org.egor.task.exception.IntArrayException;
import org.egor.task.factory.IntArrayParameters;
import org.egor.task.observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class IntArray {
  private static final Logger logger = LoggerFactory.getLogger(IntArray.class);
  private final List<Observer> observers = new ArrayList<>();

  private final UUID id;
  private final String name;
  private final int[] intArray;

  public IntArray(String name, int size) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.intArray = new int[size];
    logger.info("IntArray created.");
  }

  public IntArray(String name, int[] array) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.intArray = new int[array.length];
    System.arraycopy(array, 0, this.intArray, 0, array.length);
    logger.info("IntArray created and copied.");
  }

  public IntArray() {
    this.id = UUID.randomUUID();
    this.name = IntArrayParameters.DEFAULT_NAME;
    this.intArray = new int[0];
  }

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public String getId() {
    return id.toString();
  }

  public int[] getIntArray() {
    return intArray.clone();
  }

  public int getElement(int index) throws IntArrayException {
    if (index < this.intArray.length && index >= 0) {
      return this.intArray[index];
    } else {
      logger.error("Index {} in getElement() is out of intArray", index);
      throw new IntArrayException("Index in getElement() is out of array.");
    }
  }

  public void setElement(int index, int value) throws IntArrayException {
    if (index >= 0 && index < this.getLength()) {
      this.intArray[index] = value;
      for (Observer observer : observers) {
        try {
          observer.update(getId(), getIntArray());
        } catch (org.egor.task.exception.ObserverException e) {
          throw new RuntimeException(e);
        }
      }
    } else {
      logger.error("Invalid index {} in setElement(). Index is out of array or less then 0.", index);
      throw new IntArrayException("Invalid index.");
    }
  }

  public int getLength() {
    return this.intArray.length;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null) {
      return false;
    }

    if (o.getClass().equals(this.getClass())) {
      IntArray array = (IntArray) o;
      if (this.getLength() == array.getLength()) {
        for (int i = 0; i < array.getLength(); i++) {
          if (this.intArray[i] != array.intArray[i]) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.intArray);
  }

  @Override
  public String toString() {
    return Arrays.toString(this.intArray);
  }

  public String getName() {
    return name;
  }
}