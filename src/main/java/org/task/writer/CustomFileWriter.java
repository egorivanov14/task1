package org.task.writer;

import java.io.IOException;
import java.nio.file.Path;

public interface CustomFileWriter {
  void writeToDefault(String line) throws IOException;

  void writeWithPath(Path path, String line) throws IOException;

  void writeLog(String log) throws IOException;
}
