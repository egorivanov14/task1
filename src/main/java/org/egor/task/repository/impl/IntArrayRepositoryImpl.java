package org.egor.task.repository.impl;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.observer.Observer;
import org.egor.task.repository.IntArrayRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IntArrayRepositoryImpl implements IntArrayRepository {
  private static IntArrayRepositoryImpl intArrayRepository;
  private Observer observer;
  private List<IntArray> intArrays;

  private IntArrayRepositoryImpl() {
    this.intArrays = new ArrayList<>();
  }

  public static IntArrayRepositoryImpl getIntArrayRepository() {
    if (intArrayRepository == null) {
      intArrayRepository = new IntArrayRepositoryImpl();
    }
    return intArrayRepository;
  }

  public void setObserver(Observer observer) {
    if (observer != null) {
      this.observer = observer;
    }
  }

  @Override
  public void save(IntArray intArray) throws IntArrayException {
    if (intArray != null) {
      this.intArrays.add(intArray);
      observer.add(intArray);
    }
  }

  @Override
  public void delete(String id) {
    for (IntArray intArray : intArrays) {
      if (intArray.getId().equals(id)) {
        intArrays.remove(intArray);
        observer.delete(id);
      }
    }
  }

  @Override
  public Optional<IntArray> findById(String id) {
    Optional<IntArray> intArray = Optional.empty();
    for (IntArray element : intArrays) {
      if (element.getId().equals(id)) {
        intArray = Optional.of(element);
        return intArray;
      }
    }
    return intArray;
  }

  @Override
  public List<IntArray> findAll() {
    return intArrays;
  }
}