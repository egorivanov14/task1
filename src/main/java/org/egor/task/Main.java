package org.egor.task;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.factory.CustomIntArrayFactory;
import org.egor.task.factory.impl.CustomIntArrayFactoryImpl;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException, IntArrayException {
    CustomIntArrayFactory intArrayFactory = new CustomIntArrayFactoryImpl();
    IntArray intArray = intArrayFactory.createRandomIntArray(, 10);
  }
}