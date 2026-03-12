package org.egor.task.writer;

import org.egor.task.exception.IntArrayException;

public interface CustomFileWriter {
  void writeWrongValues(String value) throws IntArrayException;
}