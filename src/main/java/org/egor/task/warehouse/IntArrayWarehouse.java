package org.egor.task.warehouse;

import org.egor.task.entity.IntArray;
import org.egor.task.exception.IntArrayException;
import org.egor.task.observer.Observer;
import org.egor.task.repository.impl.IntArrayRepositoryImpl;
import org.egor.task.service.MathOperationsService;
import org.egor.task.service.impl.MathOperationsServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class IntArrayWarehouse implements Observer {
  private static IntArrayWarehouse intArrayWarehouse;
  private Map<String, IntArrayStats> arraysStatsMap;
  private final MathOperationsService mathService = new MathOperationsServiceImpl();

  private IntArrayWarehouse() {
    this.arraysStatsMap = new HashMap<>();
    IntArrayRepositoryImpl repository = IntArrayRepositoryImpl.getIntArrayRepository();
    repository.setObserver(intArrayWarehouse);
  }

  public static IntArrayWarehouse getIntArrayWarehouse() {
    if (intArrayWarehouse == null) {
      intArrayWarehouse = new IntArrayWarehouse();
    }
    return intArrayWarehouse;
  }

  @Override
  public void update(String id, int[] array) throws IntArrayException {
    arraysStatsMap.replace(id, getStats(array));
  }

  @Override
  public void add(IntArray array) throws IntArrayException {
    arraysStatsMap.put(array.getId(), getStats(array.getIntArray()));
  }

  @Override
  public void delete(String id) {
    arraysStatsMap.remove(id);
  }

  private IntArrayStats getStats(int[] array) throws IntArrayException {
    IntArrayStats arrayStats = new IntArrayStats();
    arrayStats.setMin(mathService.min(array));
    arrayStats.setMax(mathService.max(array));
    arrayStats.getAverage((double) mathService.sum(array) / array.length);
    return arrayStats;
  }
}