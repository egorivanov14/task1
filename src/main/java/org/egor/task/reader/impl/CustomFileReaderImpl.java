package org.egor.task.reader.impl;

import org.egor.task.exception.CustomIntArrayReaderException;
import org.egor.task.reader.CustomFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
  private static final Logger logger = LoggerFactory.getLogger(CustomFileReaderImpl.class);

  @Override
  public List<String> readWithPath(Path path, String name) throws CustomIntArrayReaderException {
    List<String> content;
    try {
      logger.info("Reading file {}.", path);
      content = Files.readAllLines(path);
    } catch (IOException e) {
      logger.error("Failed to read file {}.", path);
      throw new CustomIntArrayReaderException("Failed to read data from file.", e);
    }
    return content;
  }
}