package org.egor.task.observer;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.ObserverException;

public interface Observer {
  void update(String id, int[] array) throws ObserverException;

  void add(IntArray array) throws ObserverException;

  void remove(String id);
}