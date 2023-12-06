package org.dmiit3iy.model;

import java.time.LocalDateTime;

public abstract class Log  {
    protected LocalDateTime timeMark;

    public Log(LocalDateTime timeMark) {
        this.timeMark = timeMark;
    }

    public LocalDateTime getTimeMark() {
        return timeMark;
    }
}
