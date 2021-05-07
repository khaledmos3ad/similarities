package com.labforward.similarities.exception.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
  private String error;
  private List<String> details;
}
