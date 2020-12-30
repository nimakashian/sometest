package jdbcconnection;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.PreparedStatement;

public class Initializer {
    public static void main(String[] args) throws Exception {
        System.out.println("START");
        final int SUBSIZE = 50;
        final int MAXTHREADS = 10;
        final int ROWSIZE = 1000000;
        long _t1_update;
        long _t2_update;
        final String DRIVER = "com.mysql.cj.jdbc.Driver";


        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(DRIVER);
        ds.setUsername("morteza");
        ds.setPassword("morteza");
        ds.setUrl("jdbc:mysql://10.10.101.31/test_morteza?rewriteBatchedStatements=true&autoReconnect=true"); //
        ds.setMaxActive(8);


        long _t1_insert = System.currentTimeMillis();
        PreparedStatement insertSample = ds.getConnection().prepareStatement("insert into table_name (column_1, id) values(?,?)");
        for (int i = 0; i <ROWSIZE ; i++) {
            insertSample.setInt(2, i);
            insertSample.setString(1, (i) + " row");
            insertSample.addBatch();
            if (i % 10000 == 0) {
                insertSample.executeBatch();
                long _t_batch_insert = System.currentTimeMillis() - _t1_insert;
                System.out.println("row " + i + "-- " + _t_batch_insert);
            }
        }
        insertSample.executeBatch();
        long _t2_insert = System.currentTimeMillis() - _t1_insert;
        System.out.println(_t2_insert);

        System.out.println("END");

    }
}
