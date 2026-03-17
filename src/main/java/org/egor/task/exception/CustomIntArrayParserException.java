package org.egor.task.exception;

public class CustomIntArrayParserException extends Exception {
  public CustomIntArrayParserException() {
    super();
  }

  public CustomIntArrayParserException(String message) {
    super(message);
  }

  public CustomIntArrayParserException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomIntArrayParserException(Throwable cause) {
    super(cause);
  }
}
