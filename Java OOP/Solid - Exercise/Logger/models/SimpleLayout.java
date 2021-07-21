package SolidExercise.models;

import SolidExercise.ReportLevel;
import SolidExercise.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel.toString(), message);
    }
}
