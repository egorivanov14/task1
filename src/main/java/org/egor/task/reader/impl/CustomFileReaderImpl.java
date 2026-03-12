package org.egor.task.reader.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.egor.task.exception.IntArrayException;
import org.egor.task.reader.CustomFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
  private static final Logger logger = LoggerFactory.getLogger(CustomFileReaderImpl.class);

  @Override
  public List<String> readWithPath(Path path, String name) throws IntArrayException {
    List<String> content;
    try {
      logger.info("Reading file {}.", path);
      content = Files.readAllLines(path);
    } catch (IOException e) {
      logger.error("Failed to read file {}.", path);
      throw new IntArrayException("Failed to read data from file " + path);
    }
    return content;
  }
}