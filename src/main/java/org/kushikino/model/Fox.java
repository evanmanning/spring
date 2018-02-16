package org.kushikino.model;

import java.util.Map;

public class Fox {

  FoxColor color;

  Map<FoxColor, Integer> childrenColorCounts;

  public FoxColor getColor() {
    return color;
  }

  public void setColor(FoxColor color) {
    this.color = color;
  }

  public Map<FoxColor, Integer> getChildrenColorCounts() {
    return childrenColorCounts;
  }

  public void setChildrenColorCounts(Map<FoxColor, Integer> childrenColorCounts) {
    this.childrenColorCounts = childrenColorCounts;
  }

}