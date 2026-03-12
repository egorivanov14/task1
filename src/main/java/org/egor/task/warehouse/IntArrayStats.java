package org.egor.task.warehouse;

public class IntArrayStats {
  private int min;
  private int max;
  private double average;
  private int sum;

  IntArrayStats(int min, int max, double average, int sum) {
    this.min = min;
    this.max = max;
    this.average = average;
    this.sum = sum;
  }

  IntArrayStats() {
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public double getAverage(double v) {
    return average;
  }

  public void setAverage(double average) {
    this.average = average;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }
}
