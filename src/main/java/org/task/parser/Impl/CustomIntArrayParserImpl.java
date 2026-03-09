package org.task.parser.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.parser.CustomIntArrayParser;
import org.task.validator.Impl.CustomValidatorImpl;
import org.task.writer.Impl.CustomFileWriterImpl;

import java.io.IOException;
import java.util.regex.Pattern;

public class CustomIntArrayParserImpl implements CustomIntArrayParser {
  private static final Logger logger = LoggerFactory.getLogger(CustomIntArrayParserImpl.class);
  private static final CustomFileWriterImpl fileWriter = new CustomFileWriterImpl();
  private static final String SPACE_SYMBOL = " ";
  private static final String VALID_SYMBOLS = "[.,!?;:()]";
  private static final CustomValidatorImpl validator = new CustomValidatorImpl();

  @Override
  public int[] parseToIntArray(String lineOfInts) throws IOException {
    logger.info("Parsing line to array of integer numbers");
    if (lineOfInts == null || lineOfInts.isEmpty()) {
      logger.error("Failed to parse string. Input string is null or empty.");
      return new int[0];
    }

    if (validator.isLineOfIntsValid(lineOfInts)) {
      lineOfInts = lineOfInts.replaceAll(VALID_SYMBOLS, SPACE_SYMBOL);
      String[] strNumbers = lineOfInts.split(SPACE_SYMBOL);
      int[] intArray = new int[strNumbers.length];

      Pattern pattern = validator.getCompilePattern();
      for (int i = 0; i < intArray.length; i++) {
        if (validator.isElementValid(strNumbers[i], pattern)) {
          intArray[i] = Integer.parseInt(strNumbers[i]);
        } else {
          fileWriter.writeWrongValues(strNumbers[i] + SPACE_SYMBOL);
        }
      }
      logger.info("Successful parsing.");
      return intArray;
    } else {
      logger.warn("Line from file is not valid. Return empty int array.");
      return new int[0];
    }
  }
}