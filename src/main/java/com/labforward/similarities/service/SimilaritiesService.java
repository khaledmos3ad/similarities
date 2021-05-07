package com.labforward.similarities.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.labforward.similarities.helper.LevenshteinDistance;
import com.labforward.similarities.model.FrequencyModel;

@Service
public class SimilaritiesService {

  private NotebookEntryService notebookEntryService;
  private LevenshteinDistance levenshteinDistance;

  private static final int LEVENSHETEIN_DISTANCE_LIMIT = 1;
  private static final String SENTENCE_SPLITTER = "\\s+";

  public SimilaritiesService(
      NotebookEntryService notebookEntryService, LevenshteinDistance levenshteinDistance) {
    this.levenshteinDistance = levenshteinDistance;
    this.notebookEntryService = notebookEntryService;
  }

  public FrequencyModel getFrequencyOfWord(String targettedWord) {
    List<String> splittedWords =
        Arrays.asList(
            Optional.ofNullable(notebookEntryService.getText())
                .orElseThrow()
                .split(SENTENCE_SPLITTER));
    return FrequencyModel.builder()
        .word(targettedWord)
        .frequency(splittedWords.stream().filter(word -> word.equals(targettedWord)).count())
        .similarities(
            splittedWords
                .stream()
                .filter(
                    streamWord ->
                        !streamWord.equals(targettedWord)
                            && (levenshteinDistance.find(targettedWord, streamWord)
                                == LEVENSHETEIN_DISTANCE_LIMIT))
                .collect(Collectors.toList()))
        .build();
  }
}
