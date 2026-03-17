package org.egor.task.exception;

public class IntArrayRepositoryException extends Exception{
  public IntArrayRepositoryException() {
    super();
  }

  public IntArrayRepositoryException(String message) {
    super(message);
  }

  public IntArrayRepositoryException(String message, Throwable cause) {
    super(message, cause);
  }

  public IntArrayRepositoryException(Throwable cause) {
    super(cause);
  }
}