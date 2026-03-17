package org.egor.task.exception;

public class CustomIntArrayReaderException extends Exception{
  public CustomIntArrayReaderException() {
    super();
  }

  public CustomIntArrayReaderException(String message) {
    super(message);
  }

  public CustomIntArrayReaderException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomIntArrayReaderException(Throwable cause) {
    super(cause);
  }
}
