package org.task;

import org.task.entity.IntArray;
import org.task.exception.IntArrayException;
import org.task.factory.CustomIntArrayFactory;
import org.task.factory.Impl.CustomIntArrayFactoryImpl;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException, IntArrayException {
    CustomIntArrayFactory intArrayFactory = new CustomIntArrayFactoryImpl();
    IntArray intArray = intArrayFactory.createRandomIntArray(10);
  }
}