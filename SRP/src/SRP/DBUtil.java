package SRP;
import java.sql.*;
public class DBUtil {
    /*
     * 负责数据库的连接，该类可以提供多个数据库操作类重用
     * */
    private Connection connection=null;
    private String urlDb;//数据库
    private String username;//用户名
    private String password;//密码
    public DBUtil() {

    }
    Connection getConnection()
    {
        urlDb="jdbc:mysql://localhost:3306/srp";//srp是数据库名字
        username="root";
        password="123456";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }
        try
        {
            connection=DriverManager.getConnection(urlDb, username, password);//连接数据库
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}