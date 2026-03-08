package org.task.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface CustomFileReader {
  List<String> readFromDefault() throws IOException;

  List<String> readWithPath(Path path, String name) throws IOException;
}