package org.egor.task.exception;

public class IntArrayException extends Exception {
  public IntArrayException() {
    super();
  }

  public IntArrayException(String message) {
    super(message);
  }

  public IntArrayException(String message, Throwable cause) {
    super(message, cause);
  }

  public IntArrayException(Throwable cause) {
    super(cause);
  }
}