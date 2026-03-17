package org.egor.task.exception;

public class ObserverException extends Exception {
  public ObserverException() {
    super();
  }

  public ObserverException(String message) {
    super(message);
  }

  public ObserverException(String message, Throwable cause) {
    super(message, cause);
  }

  public ObserverException(Throwable cause) {
    super(cause);
  }
}