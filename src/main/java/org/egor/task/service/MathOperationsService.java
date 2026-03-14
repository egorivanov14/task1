package org.egor.task.service;

import org.egor.task.exception.IntArrayException;

public interface MathOperationsService {
  int min(int[] array) throws IntArrayException;

  int max(int[] array) throws IntArrayException;

  int sum(int[] array) throws IntArrayException;
}