package com.labforward.similarities.exception;

import java.util.List;

import lombok.Getter;

public class LabforwardException extends RuntimeException {

  @Getter 
  private final List<String> details;

  public LabforwardException(final String messsage) {
    this(messsage, null);
  }

  public LabforwardException(final String message, final List<String> details) {
    super(message);
    this.details = details;
  }
}
