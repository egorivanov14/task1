package org.egor.task.specification.impl;

import org.egor.task.specification.SearchType;
import org.egor.task.specification.Specification;
import org.egor.task.warehouse.IntArrayStats;

public class MinSpecification implements Specification<IntArrayStats> {
  private final int min;
  private final SearchType searchType;

  public MinSpecification(int min, SearchType searchType) {
    this.min = min;
    this.searchType = searchType;
  }

  @Override
  public boolean isSatisfiedBy(IntArrayStats candidate) {
    int candidateMin = candidate.getMin();
    return switch (searchType) {
      case GREATER  -> candidateMin > min;
      case LESS -> candidateMin < min;
      case EQUALS -> candidateMin == min;
    };
  }
}