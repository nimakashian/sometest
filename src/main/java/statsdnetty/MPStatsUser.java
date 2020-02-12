package statsdnetty;

public class MPStatsUser  {
    MPStats mpStats=MPStats.getInstance();
    public static void main(String[] args) {
        new MPStatsUser();
        new MPStatsUser();
        new MPStatsUser1();
        new MPStatsUser1();
        new MPStatsUser1();
        new MPStatsUser2();
        new MPStatsUser2();
        new MPStatsUser2();
        new MPStatsUser2();
        new MPStatsUser2();
        new MPStatsUser2();
        MPStats.getAgentsUsers();
    }
}
