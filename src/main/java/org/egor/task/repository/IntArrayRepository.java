package org.egor.task.repository;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;

import java.util.List;
import java.util.Optional;

public interface IntArrayRepository {
  void save(IntArray intArray) throws IntArrayException;
  void delete(String id);
  Optional<IntArray> findById(String id);
  List<IntArray> findAll();
}
