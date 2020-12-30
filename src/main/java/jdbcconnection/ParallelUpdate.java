package jdbcconnection;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelUpdate {

    public static void main(String[] args) throws Exception {
        System.out.println("START");
        final int SUBSIZE = 50;
        final int MAXTHREADS = 10;
        long _t1_update;
        long _t2_update;
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String update = "update table_name set column_1 = ? where id = ?";


        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(DRIVER);
        ds.setUsername("smsuser");
        ds.setPassword("adp");
        ds.setUrl("jdbc:mysql://localhost/test_morteza?rewriteBatchedStatements=true&autoReconnect=true"); //
        ds.setMaxActive(8);

        Integer[] original = new Integer[SUBSIZE];
        for (int i = 0; i < SUBSIZE; i++) original[i] = i;
        Vector<Integer> vector = new Vector<>(Arrays.asList(original));

        ExecutorService executorService = Executors.newFixedThreadPool(MAXTHREADS);

        _t1_update = System.currentTimeMillis();
        for (int i = 0; i < MAXTHREADS; i++) {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(update);
            Runnable worker = new Updater(vector, statement);
            executorService.execute(worker);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("terminated");
        }
        _t2_update = System.currentTimeMillis() - _t1_update;
        System.out.println(_t2_update);
        System.out.println("after thread");

        System.out.println("END");

    }


}
