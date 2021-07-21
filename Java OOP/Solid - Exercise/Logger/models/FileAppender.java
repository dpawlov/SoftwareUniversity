package SolidExercise.models;

import SolidExercise.ReportLevel;
import SolidExercise.interfaces.File;
import SolidExercise.interfaces.Layout;

public class FileAppender extends AppenderImpl{

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (this.file == null) {
            throw new IllegalArgumentException("File not set!");
        }
        if (this.canAppend(reportLevel)) {
            file.append(this.getLayout().format(time, message, reportLevel));
        }
    }
}
