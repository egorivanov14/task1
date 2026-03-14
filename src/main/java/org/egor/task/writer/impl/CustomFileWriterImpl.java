package org.egor.task.writer.impl;

import org.egor.task.exception.IntArrayException;
import org.egor.task.writer.CustomFileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CustomFileWriterImpl implements CustomFileWriter {
  private static final Logger logger = LoggerFactory.getLogger(CustomFileWriterImpl.class);
  private final Path WRONG_DATA_PATH = Path.of("data", "wrongData.txt");

  @Override
  public void writeWrongValues(String value) throws IntArrayException {
    try {
      logger.info("Writing an invalid value '{}' to the file 'wrongData.txt'.", value);
      Files.writeString(WRONG_DATA_PATH, value, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    } catch (IOException e) {
      logger.error("Failed to write an invalid value '{}' to the file 'wrongData.txt'.", value);
      throw new IntArrayException("Failed to write wring values to file " + WRONG_DATA_PATH);
    }
  }
}