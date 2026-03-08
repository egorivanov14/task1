package org.task.parser;

import java.io.IOException;

public interface CustomIntArrayParser {
  int[] parseToIntArray(String lineOfInts) throws IOException;
}