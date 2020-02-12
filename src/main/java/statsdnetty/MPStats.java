package statsdnetty;

import org.apache.logging.log4j.util.ReflectionUtil;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@SuppressWarnings("unused")
public class MPStats {


    static private List<MPStats> allStats = new ArrayList<>();
    static private Counter<String> statUsers = new Counter<>();
    static private Counter<String> statUsers1 = new Counter<>();
    static private StatSecurityManager statSecurityManager = new StatSecurityManager();


    public static MPStats getInstance() {
        MPStats stats = new MPStats();
        allStats.add(stats);
        long t1 = System.nanoTime();
        statUsers.add(statSecurityManager.getCaller(2));
        long t2 = System.nanoTime();
        System.out.println("sec:" + (t2 - t1));

        t1 = System.nanoTime();
        statUsers1.add(ReflectionUtil.getCallerClass(2).getName());
        t2 = System.nanoTime();
        System.out.println("sun:" + (t2 - t1));


        return stats;
    }


    public static int getAgentsCount() {
        return allStats.size();
    }

    public static String getAgentsUsers() {
        return statUsers.toString();
    }

    static class StatSecurityManager extends SecurityManager {
        String getCaller(int depth) {
            return getClassContext()[depth].getName();
        }
    }

}
