package org.egor.task;

import org.egor.task.entity.IntArray;
import org.egor.task.factory.IntArrayParameters;

public class TestVariable {
  public static final String TEST_ELEMENT = "-123";
  public static final String LINE_OF_INTS = "1,2!3?4,5,6:7;8.9,0";
  public static final IntArray ARRAY_TO_TEST = new IntArray(IntArrayParameters.DEFAULT_NAME, new int[]{12,34,1,32,12,245,125,43,123,12,252,342,35,64, 1234});
}
