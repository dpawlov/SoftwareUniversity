package SolidExercise.interfaces;

import SolidExercise.ReportLevel;

public interface Appender {
    public void append(String time, String message, ReportLevel reportLevel);
}