package designpatterns.creational_design_pattern.ObjectPool;

public class ExportingProcess {
    private long processNo;

    public ExportingProcess(long processNo) {
        this.processNo = processNo;
        // do some  expensive calls / tasks here in future
        // .........
        System.out.println("Object with process no. " + processNo + " was created");
    }

    public long getProcessNo() {
        return processNo;
    }
}
