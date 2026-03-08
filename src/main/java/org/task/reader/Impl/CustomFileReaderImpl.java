package org.task.reader.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.reader.CustomFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
  private static final Logger logger = LoggerFactory.getLogger(CustomFileReaderImpl.class);
  private final Path DEFAULT_PATH = Path.of("src", "input.txt");

  @Override
  public List<String> read() throws IOException {
    List<String> content;
    try{
      logger.info("Reading from default file 'input.txt'");
      content = Files.readAllLines(DEFAULT_PATH);
    }
    catch (IOException e){
      logger.error("Failed to read default file {}.", DEFAULT_PATH);
      throw new IOException(e.getMessage());
    }
    return content;
  }

  @Override
  public List<String> read(String directory, String name) throws IOException {
    List<String> content;
    Path path = Path.of(directory, name);
    try {
      logger.info("Reading file {}.", path);
      content = Files.readAllLines(path);
    }
    catch (IOException e){
      logger.error("Failed to read file {}.", path);
      throw new IOException(e.getMessage());
    }
    return content;
  }
}