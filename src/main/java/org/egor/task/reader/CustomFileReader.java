package org.egor.task.reader;

import org.egor.task.exception.IntArrayException;

import java.nio.file.Path;
import java.util.List;

public interface CustomFileReader {
  List<String> readWithPath(Path path, String name) throws IntArrayException;
}