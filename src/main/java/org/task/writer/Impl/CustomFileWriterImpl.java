package org.task.writer.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.writer.CustomFileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CustomFileWriterImpl implements CustomFileWriter {
  private static final Logger logger = LoggerFactory.getLogger(CustomFileWriterImpl.class);
  private final Path DEFAULT_PATH = Path.of("src/data", "output.txt");
  private final Path WRONG_DATA_PATH = Path.of("src/data", "wrongData.txt");

  @Override
  public void writeToDefault(String line) throws IOException {
    try {
      logger.info("Writing data to default file 'output.txt'. ");
      Files.writeString(DEFAULT_PATH, line, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    } catch (IOException e) {
      logger.error("Failed to write data to default file 'output.txt'. ");
      throw new IOException(e.getMessage());
    }
  }

  @Override
  public void writeWithPath(Path path, String line) throws IOException {
    try {
      logger.info("Writing line to path: {}. ", path);
      Files.writeString(path, line);
    } catch (IOException e) {
      logger.error("Failed to write data to this path: {}. ", path);
      throw new IOException(e.getMessage());
    }
  }

  @Override
  public void writeWrongValues(String value) throws IOException {
    try {
      logger.info("Writing an invalid value to the file 'wrongData.txt'.");
      Files.writeString(WRONG_DATA_PATH, value, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    } catch (IOException e) {
      logger.error("Failed to write an invalid value to the file 'wrongData.txt'.");
      throw new IOException(e.getMessage());
    }
  }
}