package org.egor.task.specification.impl;

import org.egor.task.specification.SearchType;
import org.egor.task.specification.Specification;
import org.egor.task.warehouse.IntArrayStats;

public class AverageSpecification implements Specification<IntArrayStats> {
  private final double average;
  private final SearchType searchType;

  public AverageSpecification(double valueToCompare, SearchType searchType) {
    this.average = valueToCompare;
    this.searchType = searchType;
  }

  @Override
  public boolean isSatisfiedBy(IntArrayStats candidate) {
    double average = candidate.getAverage();
    return switch (searchType) {
      case GRATER -> average > this.average;
      case LESS -> average < this.average;
      case EQUALS -> average == this.average;
    };
  }
}