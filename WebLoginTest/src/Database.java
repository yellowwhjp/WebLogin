import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection connection = null;
    public Database(String name, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection =  DriverManager.getConnection("jdbc:mysql://localhost/logintest?serverTimezone=JST",name,password);

    }

    public void showConnect(){
        System.out.println(this.connection);
    }

    public void insert(String userName, String userPwd) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("INSERT INTO webuser values (?,?)");
        prep.setString(1,userName);
        prep.setString(2,userPwd);
        prep.executeUpdate();
    }

    public void delete(String userName) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("DELETE FROM webuser where user=?");
        prep.setString(1,userName);
        prep.executeUpdate();
    }

    public Userdata getUser(String userName) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("SELECT * FROM webuser where user=?");
        prep.setString(1,userName);
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        if(resultSet.next())
        {
            String name = resultSet.getString("user");
            String pwd = resultSet.getString("password");
            return new Userdata(name, pwd);
        }
        else
        {
            return null;
        }
    }

    public ArrayList<Userdata> getAllUser() throws SQLException {
        ArrayList<Userdata> userlist = new ArrayList<Userdata>();
        PreparedStatement prep = connection.prepareStatement("SELECT * FROM webuser");
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        while (resultSet.next()) {
            String name = resultSet.getString("user");
            String pwd = resultSet.getString("password");
            userlist.add(new Userdata(name, pwd));
        }
        return userlist;
    }

    public void close() throws SQLException {
        connection.close();
    }

    public Userdata check(String name, String userpwd) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("SELECT password FROM webuser WHERE user=?");
        prep.setString(1,name);
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        if(resultSet.next())
        {
            String pwd = resultSet.getString("password");
            if(userpwd.equals(pwd))
            {
                return getUser(name);
            }
            else
                return null;
        }
        else
            return null;
    }
}
