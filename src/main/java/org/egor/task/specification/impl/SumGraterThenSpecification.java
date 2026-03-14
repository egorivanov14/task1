package org.egor.task.specification.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.service.MathOperationsService;
import org.egor.task.service.impl.MathOperationsServiceImpl;
import org.egor.task.specification.Specification;

public class SumGraterThenSpecification implements Specification<IntArray> {
  private final MathOperationsService mathService;
  private int value;

  public SumGraterThenSpecification(int value){
    this.value = value;
    mathService = new MathOperationsServiceImpl();
  }

  @Override
  public boolean isSatisfiedBy(IntArray candidate) {
    return false;
  }
}