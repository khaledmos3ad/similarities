package com.labforward.similarities.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.labforward.similarities.exception.LabforwardException;
import com.labforward.similarities.model.FrequencyModel;
import com.labforward.similarities.service.SimilaritiesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SimilaritiesController {

  private SimilaritiesService similaritiesService;

  public SimilaritiesController(SimilaritiesService similaritiesService) {
    this.similaritiesService = similaritiesService;
  }

  @ResponseStatus(code = HttpStatus.OK)
  @GetMapping(value = "/frequency", produces = MediaType.APPLICATION_JSON_VALUE)
  public FrequencyModel getWordFrequency(
      @RequestParam(name = "word", required = true) String word) {
    log.info("Received a frequency request of {}", word);
    word = Optional.ofNullable(word).orElseThrow().trim();
    if (word.isBlank() || word.contains(" ")) {
      throw new LabforwardException("Word should not be empty or contain any spaces.");
    }
    return similaritiesService.getFrequencyOfWord(word);
  }
}
