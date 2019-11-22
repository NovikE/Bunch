package flowers.dao.bd;

import flowers.bean.Bunch;
import flowers.bean.Flower;

import java.sql.*;
import java.util.*;

public class BunchDaoMySqlImpl {

    private static final String SQL_SELECT_BUNCH = "SELECT * FROM bunches";
    private static final String SQL_INSERT_BUNCH = "insert into bunches(id, flower_id, quantity, ribbon_id) values(?, ?, ?, ?)";
    private static final String SQL_SELECT_BUNCH_MAX_ID = "SELECT * FROM bunches where id = (select max(id) from bunches);";

    {
        try {
            Class.forName(getConnectionValues()[3]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void create(Bunch bunch) {
        if (bunch != null) {

            String url = getConnectionValues()[0];
            String login = getConnectionValues()[1];
            String pass = getConnectionValues()[2];
            String driver = getConnectionValues()[3];

            try (Connection cn = DriverManager.getConnection(url, login, pass)) {
                System.out.println("connected");
                Iterator<Map.Entry<Integer, Integer>> it = bunch.getRequest().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    PreparedStatement ps = cn.prepareStatement(SQL_INSERT_BUNCH);

                    ps.setInt(1, bunch.getId());
                    ps.setInt(2, entry.getKey());
                    ps.setInt(3, entry.getValue());
                    ps.setInt(4, bunch.getRibbonId());
                    ps.executeUpdate();

                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public Bunch read(int id) {
        // TODO Auto-generated method stub
        return null;
    }


    public void update(Bunch entity) {
        // TODO Auto-generated method stub

    }


    public void delete(int id) {
        // TODO Auto-generated method stub

    }


    private String[] getConnectionValues() {

        ResourceBundle rb = ResourceBundle.getBundle("db_config");
        String dbURL = rb.getString("db.url");
        String user = rb.getString("db.login");
        String pass = rb.getString("db.pass");
        String driver = rb.getString("db.driver.name");

        return new String[]{dbURL, user, pass, driver};
    }

    public int getMaxId(){
        Connection cn = null;

        String url = getConnectionValues()[0];
        String login = getConnectionValues()[1];
        String pass = getConnectionValues()[2];
        String driver = getConnectionValues()[3];

        int max_id = 0;

        try {
            cn = DriverManager.getConnection(url, login, pass);
            System.out.println("connected");

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_BUNCH_MAX_ID);
            while (rs.next()) {
                if (rs != null) {
                    max_id = rs.getInt("ID");
                }
                break;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {

                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return max_id;}

}
