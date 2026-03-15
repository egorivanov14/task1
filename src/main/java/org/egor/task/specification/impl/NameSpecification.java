package org.egor.task.specification.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.specification.Specification;

public class NameSpecification implements Specification<IntArray> {
  private final String name;

  public NameSpecification(String name) {
    this.name = name;
  }

  @Override
  public boolean isSatisfiedBy(IntArray candidate) {
    return name.equals(candidate.getName());
  }
}