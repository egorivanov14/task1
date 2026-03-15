package org.egor.task.specification.impl;

import org.egor.task.specification.SearchType;
import org.egor.task.specification.Specification;
import org.egor.task.warehouse.IntArrayStats;

public class MaxSpecification implements Specification<IntArrayStats> {
  private final int max;
  private final SearchType searchType;

  public MaxSpecification(int max, SearchType searchType) {
    this.max = max;
    this.searchType = searchType;
  }

  @Override
  public boolean isSatisfiedBy(IntArrayStats candidate) {
    int candidateMax = candidate.getMax();
    return switch (searchType) {
      case GRATER -> candidateMax > max;
      case LESS -> candidateMax < max;
      case EQUALS -> candidateMax == max;
    };
  }
}