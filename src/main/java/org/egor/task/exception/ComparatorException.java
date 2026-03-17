package org.egor.task.exception;

public class ComparatorException extends Exception {

  public ComparatorException() {
    super();
  }

  public ComparatorException(String message) {
    super(message);
  }

  public ComparatorException(String message, Throwable cause) {
    super(message, cause);
  }

  public ComparatorException(Throwable cause) {
    super(cause);
  }
}