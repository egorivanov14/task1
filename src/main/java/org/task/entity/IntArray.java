package org.task.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.exception.IntArrayException;
import java.util.Arrays;

public class IntArray {

  private static final Logger logger = LoggerFactory.getLogger(IntArray.class);
  private final int[] intArray;

  public IntArray(int size){
    this.intArray = new int[size];
    logger.info("IntArray created.");
  }

  public IntArray(int[] array){
    this.intArray = new int[array.length];
    System.arraycopy(array, 0, this.intArray, 0, array.length);
    logger.info("IntArray created and copied.");
  }

  public int[] getIntArray(){
    return intArray;
  }

  public int getElement(int index) throws IntArrayException {
    if(index >= this.intArray.length){
      logger.error("Index {} is out of intArray", index);
      throw new IntArrayException("Index is out of array.");
    }
    else{
      return this.intArray[index];
    }
  }

  public void setElement(int index, int value) throws IntArrayException {
    if(index >= getLength() && index < 0){
      logger.error("Invalid index : {}. There are no such indexes in array.", index);
      throw new IntArrayException("Invalid index");
    }
    else{
      this.intArray[index] = value;
    }
  }

  public int getLength(){
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
