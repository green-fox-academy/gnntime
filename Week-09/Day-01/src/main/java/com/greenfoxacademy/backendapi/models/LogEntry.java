package com.greenfoxacademy.backendapi.models;

import java.util.ArrayList;
import java.util.List;

public class LogEntry {
  private List<Log> entries = new ArrayList<>();
  private int entry_count;

  public LogEntry() {
  }

  public List<Log> getEntries() {
    return entries;
  }

  public void setEntries(List<Log> entries) {
    this.entries = entries;
  }

  public int getEntry_count() {
    return entry_count;
  }

  public void setEntry_count(int entry_count) {
    this.entry_count = entry_count;
  }
}
