package others.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class WorkloadSplitter extends RecursiveAction {
    private final long workload;

    public WorkloadSplitter(long workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload > 16) {
            System.out.println("Workload too big! Thus splitting : " + workload);
            long first = workload/2;
            long second = workload - first;

            WorkloadSplitter workloadSplitter1 = new WorkloadSplitter(first);
            WorkloadSplitter workloadSplitter2 = new WorkloadSplitter(second);

            workloadSplitter1.fork();
            workloadSplitter2.fork();
        } else {
            System.out.println("Workload within limits! Task being executed for workload : " + workload);
        }
    }
}

class WorkloadSplitDemo {
    public static void main(String[] args) {
        try(ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors())) {
            WorkloadSplitter splitter = new WorkloadSplitter(128);
            pool.invoke(splitter);
        }
    }
}
