package statsdnetty;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class MPStats  {


    static private List<MPStats> allStats = new ArrayList<>();



    public static MPStats getInstance() {
        MPStats stats = new MPStats();
        allStats.add(stats);

        return stats;
    }


    public static int getAgentsCount() {
        return allStats.size();
    }

    public static void main(String[] args) {
        new MPStatsUser();
        new MPStatsUser();
    }
}
