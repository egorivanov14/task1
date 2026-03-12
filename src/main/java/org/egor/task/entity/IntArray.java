package org.egor.task.entity;

import org.egor.task.exception.IntArrayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class IntArray {

  private static final Logger logger = LoggerFactory.getLogger(IntArray.class);
  public final static Random random = new Random();

  private final String id;
  private final int[] intArray;

  public IntArray(int size) {
    this.id = UUID.randomUUID().toString();
    this.intArray = new int[size];
    logger.info("IntArray created.");
  }

  public IntArray(int[] array) {
    this.id = UUID.randomUUID().toString();
    this.intArray = new int[array.length];
    System.arraycopy(array, 0, this.intArray, 0, array.length);
    logger.info("IntArray created and copied.");
  }

  public IntArray() {
    this.id = UUID.randomUUID().toString();
    this.intArray = new int[0];
  }

  public IntArray(String name) {
    this.id = UUID.randomUUID().toString();
    this.intArray = new int[0];
  }

  public String getId() {
    return id;
  }

  public int[] getIntArray() {
    int[] arrayCopy = new int[this.getLength()];
    System.arraycopy(this.intArray, 0, arrayCopy, 0, this.getLength());
    return arrayCopy;
  }

  public int getElement(int index) throws IntArrayException {
    if (index >= this.intArray.length || index < 0) {
      logger.error("Index {} in getElement() is out of intArray", index);
      throw new IntArrayException("Index in getElement() is out of array.");
    } else {
      return this.intArray[index];
    }
  }

  public void setElement(int index, int value) throws IntArrayException {
    if (index > 0 && index < this.getLength()) {
      this.intArray[index] = value;
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
      logger.error("Empty object in equals method.");
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
}