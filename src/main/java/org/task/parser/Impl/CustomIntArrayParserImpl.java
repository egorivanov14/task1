package org.task.parser.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.parser.CustomIntArrayParser;

public class CustomIntArrayParserImpl implements CustomIntArrayParser {
  private static final Logger logger = LoggerFactory.getLogger(CustomIntArrayParserImpl.class);
  private static final String TRASH_SYMBOLS = "[^\\d\\-]";
  private static final String EMPTY_SPACE_SYMBOL = "\\s{2,}";

  @Override
  public int[] parseToIntArray(String lineOfInts) {
    logger.info("Parsing line to array of integer numbers");
    if(lineOfInts == null || lineOfInts.isEmpty()){
      logger.error("Failed to parse string. Input string is null or empty.");
      return new int[0];
    }

    String cleanLine = lineOfInts.replaceAll(TRASH_SYMBOLS, " ");
    cleanLine = cleanLine.replaceAll(EMPTY_SPACE_SYMBOL, " ");
    String[] strNumbers = cleanLine.split(" ");
    int[] intArray = new int[strNumbers.length];

    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = Integer.parseInt(strNumbers[i]);
    }
    logger.info("Successful parsing.");
    return intArray;
  }
}
