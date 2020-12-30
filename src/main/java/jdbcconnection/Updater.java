package jdbcconnection;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

public class Updater implements Runnable {
    long _t1_update;
    long _t2_update;


    Vector<Integer> vector;
    Connection connection;
    PreparedStatement statement;

    public Updater(Vector vector, PreparedStatement statement) {
        this.vector = vector;
        this.statement = statement;


    }

    @Override
    public void run() {

        while (vector.size() > 0) {
            try {
//                _t1_update = System.currentTimeMillis();
                int i = vector.remove(0);
                statement.setInt(2, i);
                statement.setString(1, (i) + "--" + System.currentTimeMillis());
                statement.execute();
//                _t2_update = System.currentTimeMillis() - _t1_update;
//                System.out.println(_t2_update);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try{

            statement.getConnection().close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}