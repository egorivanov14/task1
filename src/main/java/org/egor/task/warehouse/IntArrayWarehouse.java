package org.egor.task.warehouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class IntArrayWarehouse {
  private static final Logger logger = LoggerFactory.getLogger(IntArrayWarehouse.class);
  private static IntArrayWarehouse intArrayWarehouse;
  private final Map<String, IntArrayStats> arraysStatsMap;

  private IntArrayWarehouse() {
    logger.info("Creating new IntArrayWarehouse.");
    this.arraysStatsMap = new HashMap<>();
  }

  public static IntArrayWarehouse getIntArrayWarehouse() {
    logger.info("getIntArrayWarehouse() is called.");
    if (intArrayWarehouse == null) {
      intArrayWarehouse = new IntArrayWarehouse();
    }
    return intArrayWarehouse;
  }

  public void changeIntArrayStats(String id, IntArrayStats newIntArrayStats){
    logger.info("Changing IntArrayStats with id {} from IntArrayWarehouse.", id);
    arraysStatsMap.replace(id, newIntArrayStats);
  }

  public void putIntArrayStats(String id, IntArrayStats intArrayStats) {
    logger.info("Putting IntArrayStats with id {} into IntArrayWarehouse.", id);
    arraysStatsMap.put(id, intArrayStats);
  }

  public void removeIntArrayStats(String id) {
    logger.info("Removing IntArrayStats with id {} from IntArrayWarehouse.", id);
    arraysStatsMap.remove(id);
  }

  public IntArrayStats getStatsById(String id){
    return arraysStatsMap.get(id);
  }

  public Map<String, IntArrayStats> getAllStats(){
    return new HashMap<>(arraysStatsMap);
  }
}