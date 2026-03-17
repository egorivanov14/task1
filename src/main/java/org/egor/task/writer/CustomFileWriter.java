package org.egor.task.writer;

import org.egor.task.exception.CustomIntArrayWriterException;

public interface CustomFileWriter {
  void writeWrongValues(String value) throws CustomIntArrayWriterException;
}