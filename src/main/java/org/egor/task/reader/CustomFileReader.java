package org.egor.task.reader;

import org.egor.task.exception.CustomIntArrayReaderException;

import java.nio.file.Path;
import java.util.List;

public interface CustomFileReader {
  List<String> readWithPath(Path path) throws CustomIntArrayReaderException;
}