package org.egor.task.exception;

public class CustomIntArrayWriterException extends Exception{
  public CustomIntArrayWriterException() {
    super();
  }

  public CustomIntArrayWriterException(String message) {
    super(message);
  }

  public CustomIntArrayWriterException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomIntArrayWriterException(Throwable cause) {
    super(cause);
  }
}