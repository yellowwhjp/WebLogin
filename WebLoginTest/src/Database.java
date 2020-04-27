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

    public void insert(String userName, String userPwd, String userImgName) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("INSERT INTO userdata values (?,?,?)");
        prep.setString(1, userName);
        prep.setString(2, userPwd);
        prep.setString(3, userImgName);
        prep.executeUpdate();
    }

    public void delete(String userName) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("DELETE FROM userdata where user_name=?");
        prep.setString(1,userName);
        prep.executeUpdate();
    }

    public Userdata getUser(String userName) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("SELECT * FROM userdata where user_name=?");
        prep.setString(1,userName);
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        if(resultSet.next())
        {
            String name = resultSet.getString("user_name");
            String pwd = resultSet.getString("user_password");
            return new Userdata(name, pwd);
        }
        else
        {
            return null;
        }
    }

    public ArrayList<Userdata> getAllUser() throws SQLException {
        ArrayList<Userdata> userlist = new ArrayList<Userdata>();
        PreparedStatement prep = connection.prepareStatement("SELECT * FROM userdata");
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        while (resultSet.next()) {
            String name = resultSet.getString("user_name");
            String pwd = resultSet.getString("user_password");
            userlist.add(new Userdata(name, pwd));
        }
        return userlist;
    }

    public void close() throws SQLException {
        connection.close();
    }

    public Userdata check(String name, String userpwd) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("SELECT user_password FROM userdata WHERE user_name=?");
        prep.setString(1,name);
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        if(resultSet.next())
        {
            String pwd = resultSet.getString("user_password");
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
