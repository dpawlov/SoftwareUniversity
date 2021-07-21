package SolidExercise.models;

import SolidExercise.ReportLevel;
import SolidExercise.interfaces.Appender;
import SolidExercise.interfaces.Layout;

public abstract class AppenderImpl implements Appender {

    public static final ReportLevel REPORT_LEVEL_DEFAULT = ReportLevel.INFO;

    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesCount;

    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = AppenderImpl.REPORT_LEVEL_DEFAULT;
        this.messagesCount = 0;
    }

    public AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.reportLevel = reportLevel;
    }


    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public Layout getLayout() {
        return layout;
    }

    @Override
    public abstract void append(String time, String message, ReportLevel reportLevel);

    protected boolean canAppend(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }
}
