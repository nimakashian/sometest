package jdbcconnection;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdate {
    public static void main(String[] args) throws SQLException {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final int ROWSIZE = 1000000;
        final int BATCHSIZE = 100;
        final int SUBSIZE = 1000;

        long _t1_update;
        long _t2_update;

        System.out.println("START");
        Connection connection;
        Connection connection2;
        Connection connection3;


/*
        //simple batch
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(DRIVER);
        ds.setUsername("smsuser");
        ds.setPassword("adp");
        ds.setUrl("jdbc:mysql://localhost/test_morteza?autoReconnect=true"); //rewriteBatchedStatements=true&
        ds.setMaxActive(8);
        connection = ds.getConnection();
        System.out.println("update no rewrite");
        _t1_update = System.currentTimeMillis();
        PreparedStatement statement = connection.prepareStatement("update table_name set column_1 = ? where id = ?");
        for (int i = 0; i < SUBSIZE; i++) {
            statement.setInt(2, i);
            statement.setString(1, (i) + "--" + System.currentTimeMillis());
            statement.addBatch();
//            if (i % BATCHSIZE == 0) {
//                statement.executeBatch();
//                long _t_batch_update = System.currentTimeMillis() - _t1_update;
//                System.out.println("row " + i + "-- " + _t_batch_update);
//            }
        }
        statement.executeBatch();
        _t2_update = System.currentTimeMillis() - _t1_update;
        System.out.println(_t2_update);
        connection.close();
        statement.close();
        ds.close();

        //rewrite
        BasicDataSource ds2 = new BasicDataSource();
        ds2.setDriverClassName(DRIVER);
        ds2.setUsername("smsuser");
        ds2.setPassword("adp");
        ds2.setUrl("jdbc:mysql://localhost/test_morteza?rewriteBatchedStatements=true&autoReconnect=true"); //rewriteBatchedStatements=true&
        ds2.setMaxActive(8);
        connection2 = ds2.getConnection();
        System.out.println("update with rewrite");
        _t1_update = System.currentTimeMillis();
        PreparedStatement statement2 = connection2.prepareStatement("update table_name set column_1 = ? where id = ?");
        for (int i = 0; i < SUBSIZE; i++) {
            statement2.setInt(2, i);
            statement2.setString(1, (i) + "--" + System.currentTimeMillis());
            statement2.addBatch();
//            if (i % BATCHSIZE == 0) {
//                statement2.executeBatch();
//                long _t_batch_update = System.currentTimeMillis() - _t1_update;
//                System.out.println("row " + i + "-- " + _t_batch_update);
//            }
        }
        statement2.executeBatch();
        _t2_update = System.currentTimeMillis() - _t1_update;
        System.out.println(_t2_update);
        connection2.close();
        statement2.close();
        ds2.close();

*/
        //no batch
        BasicDataSource ds3 = new BasicDataSource();
        ds3.setDriverClassName(DRIVER);
        ds3.setUsername("smsuser");
        ds3.setPassword("adp");
        ds3.setUrl("jdbc:mysql://localhost/test_morteza?autoReconnect=true"); //rewriteBatchedStatements=true&
        ds3.setMaxActive(8);
        connection3 = ds3.getConnection();

        System.out.println("update no batch");
        _t1_update = System.currentTimeMillis();
        connection3.setAutoCommit(false);
        PreparedStatement statement3 = connection3.prepareStatement("update table_name set column_1 = ? where id = ?");

        for (int i = 0; i < 50; i++) {
            try {
                statement3.setInt(2, i);
                statement3.setString(1, (i==5? 0: i) + "--" + "45345353 4353535353");
                statement3.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
//            if (i % BATCHSIZE == 0) {
//                long _t_batch_update = System.currentTimeMillis() - _t1_update;
//                System.out.println("row " + i + "-- " + _t_batch_update);
//            }
        }
        connection3.commit();
        _t2_update = System.currentTimeMillis() - _t1_update;

        System.out.println(_t2_update);
        connection3.close();
        statement3.close();
        ds3.close();

//        statement.close();
        System.out.println("END");
    }
}
