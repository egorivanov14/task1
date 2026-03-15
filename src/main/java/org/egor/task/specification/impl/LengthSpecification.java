package org.egor.task.specification.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.specification.SearchType;
import org.egor.task.specification.Specification;

public class LengthSpecification implements Specification<IntArray> {
  private final int length;
  private final SearchType searchType;

  public LengthSpecification(int quantity, SearchType searchType) {
    this.length = quantity;
    this.searchType = searchType;
  }

  @Override
  public boolean isSatisfiedBy(IntArray candidate) {
    int candidateLength = candidate.getLength();
    return switch (searchType) {
      case GRATER -> candidateLength > length;
      case LESS -> candidateLength < length;
      case EQUALS -> candidateLength == length;
    };
  }
}