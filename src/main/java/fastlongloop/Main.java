package fastlongloop;

import com.sun.rowset.CachedRowSetImpl;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection;
        CachedRowSet cachedRowSet=new CachedRowSetImpl();
        ResultSet rs;
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("smsuser");
        ds.setPassword("adp");
        ds.setUrl("jdbc:mysql://localhost/easysms_fastlong?autoReconnect=true");
        ds.setMaxActive(8);
        connection=ds.getConnection();
        Statement statement=connection.createStatement();
        for (int i=0;i<2;i++) {

            statement.addBatch("insert into outgoing_message (from_mobile_number, dest_mobile_number,\n" +
                    "                              message_body, due_date, dcs)\n" +
                    "values ('982000090900','98136000','hellooo"+i+"', now(),0)");

            if(i % 1 ==0) {
                statement.executeBatch();
                System.out.println(i);
                statement.close();
                statement=connection.createStatement();
                Thread.sleep(120000);

            }
        }
//        rs.close();
        connection.close();
//        statement.close();

    }
}
