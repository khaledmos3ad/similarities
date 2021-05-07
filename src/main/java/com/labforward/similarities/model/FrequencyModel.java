package com.labforward.similarities.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FrequencyModel {

  private String word;
  private long frequency;
  private List<String> similarities;
}
