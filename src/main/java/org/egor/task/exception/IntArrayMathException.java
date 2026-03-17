package org.egor.task.exception;

public class IntArrayMathException extends Exception {
  public IntArrayMathException() {
    super();
  }

  public IntArrayMathException(String message) {
    super(message);
  }

  public IntArrayMathException(String message, Throwable cause) {
    super(message, cause);
  }

  public IntArrayMathException(Throwable cause) {
    super(cause);
  }
}