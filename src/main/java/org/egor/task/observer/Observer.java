package org.egor.task.observer;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;

public interface Observer {
  void update(String id, int[] array) throws IntArrayException;

  void add(IntArray array) throws IntArrayException;

  void remove(String id);
}