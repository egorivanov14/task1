package org.egor.task.specification;

public interface Specification<T> {
  boolean isSatisfiedBy(T candidate);
}
