package org.task.service;

import org.task.entity.IntArray;
import org.task.exception.IntArrayException;

public interface MathOperationsService { //назвать по другому
  int min(IntArray array) throws IntArrayException;

  int max(IntArray array) throws IntArrayException;

  int sum(IntArray array) throws IntArrayException;
}