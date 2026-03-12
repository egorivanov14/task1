package org.egor.task.parser;

import org.egor.task.exception.IntArrayException;

public interface CustomIntArrayParser {
  int[] parseToIntArray(String lineOfInts) throws IntArrayException;
}