package org.egor.task.specification.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.specification.Specification;

public class IdSpecification implements Specification<IntArray> {
  private final String id;

  public IdSpecification(String id) {
    this.id = id;
  }

  @Override
  public boolean isSatisfiedBy(IntArray candidate) {
    return candidate.getId().equals(id);
  }
}