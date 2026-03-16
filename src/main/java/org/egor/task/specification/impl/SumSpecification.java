package org.egor.task.specification.impl;

import org.egor.task.specification.SearchType;
import org.egor.task.specification.Specification;
import org.egor.task.warehouse.IntArrayStats;

public class SumSpecification implements Specification<IntArrayStats> {
  private final int sum;
  private final SearchType searchType;

  public SumSpecification(int value, SearchType searchType) {
    this.sum = value;
    this.searchType = searchType;
  }

  @Override
  public boolean isSatisfiedBy(IntArrayStats candidate) {
    int sum = candidate.getSum();
    return switch (searchType) {
      case LESS -> sum < this.sum;
      case EQUALS -> sum == this.sum;
      case GREATER  -> sum > this.sum;
    };
  }
}