package jdbcconnection;

import com.sun.rowset.CachedRowSetImpl;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection;
        CachedRowSet cachedRowSet=new CachedRowSetImpl();
        ResultSet rs;
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("smsuser");
        ds.setPassword("adp");
        ds.setUrl("jdbc:mysql://localhost/easysms_simple?autoReconnect=true");
        ds.setMaxActive(8);
        connection=ds.getConnection();
        Statement statement=connection.createStatement();
        rs=  statement.executeQuery("select * from inbound_messages");
        cachedRowSet.populate(rs);
        rs.close();
        connection.close();
        statement.close();
        while(cachedRowSet.next()){
            System.out.println(cachedRowSet.getString(1)+"--"+cachedRowSet.getString(2));
        }
    }


}
