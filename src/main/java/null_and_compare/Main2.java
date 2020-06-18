package null_and_compare;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        long[] allThreadIds = threadMXBean.getAllThreadIds();
        List<ThreadInfoEx> threadInfos = new ArrayList<>();
        for (long threadId : allThreadIds) {
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
            if (threadInfo.getThreadState().equals(Thread.State.RUNNABLE)) {
                ThreadInfoEx threadInfoEx = new ThreadInfoEx();
                threadInfoEx.threadInfo = threadInfo;
                threadInfoEx.cpuTime = threadMXBean.getThreadCpuTime(threadId) / 1000;
                threadInfos.add(threadInfoEx);
            }
        }

        Collections.sort(threadInfos, new Comparator<ThreadInfoEx>() {
            @Override
            public int compare(ThreadInfoEx o1, ThreadInfoEx o2) {
                if (o2.threadInfo.getThreadState() == o1.threadInfo.getThreadState())
                    return (int) (o2.cpuTime - o1.cpuTime);
                return o1.threadInfo.getThreadState().ordinal() - o2.threadInfo.getThreadState().ordinal();
            }
        });


        System.out.println(threadInfos.get(0).equals(threadInfos.get(1)));
    }
}
