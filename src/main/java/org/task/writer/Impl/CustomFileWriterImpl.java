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
  private final Path DEFAULT_PATH = Path.of("src", "output.txt");
  private final Path LOG_PATH = Path.of("src", "log.txt");

  @Override
  public void writeToDefault(String line) throws IOException {
    try {
      logger.info("Writing data in default file. ");
      Files.writeString(DEFAULT_PATH, line);
    }
    catch (IOException e){
      logger.error("Failed to write data to default file. ");
      throw new IOException(e.getMessage());
    }
  }

  @Override
  public void writeWithPath(Path path, String line) throws IOException {
    try{
      logger.info("Writing line to path: {}. ", path);
      Files.writeString(path, line);
    } catch (IOException e) {
      logger.error("Failed to write data to this path: {}. ", path);
      throw new IOException(e.getMessage());
    }
  }

  @Override
  public void writeLog(String log) throws IOException {
    try {
      logger.info("Writing log to path: {}. ", LOG_PATH);
      Files.writeString(LOG_PATH, log, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }
    catch (IOException e){
      throw new IOException(e.getMessage());
    }
  }
}
