package org.egor.task.parser.impl;

import org.egor.task.exception.IntArrayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.egor.task.parser.CustomIntArrayParser;
import org.egor.task.validator.impl.CustomValidatorImpl;
import org.egor.task.writer.impl.CustomFileWriterImpl;

import java.util.regex.Pattern;

import static org.egor.task.validator.impl.CustomValidatorImpl.CORRECT_NUMBER;

public class CustomIntArrayParserImpl implements CustomIntArrayParser {
  private static final Logger logger = LoggerFactory.getLogger(CustomIntArrayParserImpl.class);
  private final CustomFileWriterImpl fileWriter = new CustomFileWriterImpl();
  private final CustomValidatorImpl validator = new CustomValidatorImpl();
  private static final String SPACE_SYMBOL = " ";
  private static final String VALID_SYMBOLS = "[.,!?;:()]";

  @Override
  public int[] parseToIntArray(String lineOfInts) throws IntArrayException {
    logger.info("Parsing line to array of integer numbers");
    if (lineOfInts == null || lineOfInts.isEmpty()) {
      logger.error("Failed to parse line. Input line is null or empty.");
      throw new IntArrayException("Failed to parse line to int array. Array is null or empty.");
    }

    if (validator.isLineOfIntsValid(lineOfInts)) {
      lineOfInts = lineOfInts.replaceAll(VALID_SYMBOLS, SPACE_SYMBOL);
      String[] strNumbers = lineOfInts.split(SPACE_SYMBOL);
      int[] intArray = new int[strNumbers.length];

      Pattern pattern = Pattern.compile(CORRECT_NUMBER);
      for (int i = 0; i < intArray.length; i++) {
        if (validator.isElementValid(strNumbers[i], pattern)) {
          intArray[i] = Integer.parseInt(strNumbers[i]);
        } else {
          try {
            fileWriter.writeWrongValues(strNumbers[i] + SPACE_SYMBOL);
          } catch (org.egor.task.exception.IntArrayException e) {
            throw new RuntimeException(e);
          }
        }
      }
      logger.info("Successful parsing to IntArray.");
      return intArray;
    } else {
      logger.warn("Line from file is not valid. Return empty IntArray.");
      return new int[0];
    }
  }
}