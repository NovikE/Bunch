package flowers.dao.bd;

import flowers.bean.Flower;
import flowers.bean.Stem;
import flowers.dao.FlowerDao;
import flowers.exceptions.MyExceptionNegVal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FlowerDaoMySqlImpl implements FlowerDao {

    private static final String SQL_SELECT_FLOWERS = "SELECT * FROM flowers";

    {
        try {
            Class.forName(getConnectionValues()[3]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Flower> readAll() {

        List<Flower> list = new ArrayList<>();

        String url = getConnectionValues()[0];
        String login = getConnectionValues()[1];
        String pass = getConnectionValues()[2];
        String driver = getConnectionValues()[3];

        Connection cn = null;

        try {
            cn = DriverManager.getConnection(url, login, pass);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_FLOWERS);
            System.out.println("connected flowers");
            while (rs.next()) {
                Flower fl = new Flower();
                //Stem stem = new Stem(rs.getInt("STEMH"), rs.getInt("STEMW"));
                fl.setId(rs.getInt("ID"));
                fl.setTitle(rs.getString("TITLE"));
                fl.setPrice(rs.getDouble("PRICE"));
                fl.setQuantity(rs.getInt("QUANTITY"));
                fl.setFreshness(rs.getInt("FRESHNESS"));
                fl.setStem(new Stem(rs.getInt("STEMH"), rs.getInt("STEMW")));
                //fl.setStem(stem);
                //fl.setFreshness(rs.getInt("STEMW"));

                list.add(fl);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MyExceptionNegVal myExceptionNegVal) {
            myExceptionNegVal.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void create(Flower entity) {

    }

    @Override
    public Flower read(int id) {
        return null;
    }

    @Override
    public void update(Flower entity) {

    }

    @Override
    public void delete(int id) {

    }

    private String[] getConnectionValues() {

        ResourceBundle rb = ResourceBundle.getBundle("db_config");
        String dbURL = rb.getString("db.url");
        String user = rb.getString("db.login");
        String pass = rb.getString("db.pass");
        String driver = rb.getString("db.driver.name");

        return new String[]{dbURL, user, pass, driver};
    }
}
