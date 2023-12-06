package org.dmiit3iy.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class SimpleLog extends Log implements Comparable<SimpleLog> {

    private String description;


    public String getDescription() {
        return description;
    }

    public SimpleLog(LocalDateTime timeMark, String description) {
        super(timeMark);
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleLog log)) return false;
        return Objects.equals(timeMark, log.timeMark) && Objects.equals(description, log.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeMark, description);
    }

    @Override
    public int compareTo(SimpleLog o) {
        return this.timeMark.compareTo(o.getTimeMark());
    }

    @Override
    public String toString() {
        return timeMark+" "+description+";";
    }
}
