package org.task.reader;

import java.io.IOException;
import java.util.List;

public interface CustomFileReader {
  List<String> read() throws IOException;

  List<String> read(String directory, String name) throws IOException;
}