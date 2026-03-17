package org.egor.task.exception;

public class IntArrayFactoryException extends Exception {
  public IntArrayFactoryException() {
    super();
  }

  public IntArrayFactoryException(String message) {
    super(message);
  }

  public IntArrayFactoryException(String message, Throwable cause) {
    super(message, cause);
  }

  public IntArrayFactoryException(Throwable cause) {
    super(cause);
  }
}
