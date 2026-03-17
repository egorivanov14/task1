package org.egor.task.parser;

import org.egor.task.exception.CustomIntArrayParserException;

public interface CustomIntArrayParser {
  int[] parseToIntArray(String lineOfInts) throws CustomIntArrayParserException;
}