package com.ice.sudoku;

public class NotResolvableException extends Exception {

  public NotResolvableException() {
  }

  public NotResolvableException(String message) {
    super(message);
  }

  public NotResolvableException(Throwable cause) {
    super(cause);
  }

  public NotResolvableException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotResolvableException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
