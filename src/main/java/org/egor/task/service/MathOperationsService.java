package org.egor.task.service;

import java.util.OptionalInt;

public interface MathOperationsService {
  OptionalInt min(int[] array);

  OptionalInt max(int[] array);

  OptionalInt sum(int[] array);
}