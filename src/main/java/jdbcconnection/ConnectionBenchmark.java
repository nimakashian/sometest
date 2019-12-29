package jdbcconnection;


import com.sun.rowset.CachedRowSetImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class ConnectionBenchmark {

    BasicDataSource ds;


    public Object cache() {
        Connection connection;
        CachedRowSet cachedRowSet;
        ResultSet rs;
        Statement statement;
        try {
            cachedRowSet = new CachedRowSetImpl();
            connection = ds.getConnection();
            cachedRowSet.setCommand("select * from inbound_messages");
            cachedRowSet.execute(connection);
            connection.close();
            while (cachedRowSet.next()) {
                cachedRowSet.getString(1) ;
                cachedRowSet.getString(2);
            }
            cachedRowSet.close();
//            System.out.println("end cache");
        } catch (Exception e) {
            System.out.println("cache:"+e.getMessage());


        }
        return null;
    }

    public Object nocache()  {
        Connection connection;
        CachedRowSet cachedRowSet;
        ResultSet rs;
        Statement statement;
        try {
            connection = ds.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from inbound_messages");
            while (rs.next()) {
                rs.getString(1);
            rs.getString(2);
            }
            rs.close();
            statement.close();
            connection.close();
//            System.out.println("end nocache");
        } catch (Exception e) {
            System.out.println("no cache:"+e.getMessage());
        }
        return null;
    }

    @Setup
    public void setupCollections() throws Exception {

        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("smsuser");
        ds.setPassword("adp");
        ds.setUrl("jdbc:mysql://localhost/easysms_simple?autoReconnect=true");
        ds.setMaxActive(8);


    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void cacheTest(Blackhole blackhole) {
//            System.out.println(i);
        blackhole.consume(cache());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void nocacheTest(Blackhole blackhole) {
//            System.out.println(j);
        blackhole.consume(nocache());
    }
}
