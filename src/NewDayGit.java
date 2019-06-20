import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewDayGit {
    static Connection connection = null;

    public static void main(String[] args) {
        //通过反射加载驱动.减少耦合度,扩展性强,方便以后对数据库的改变,只加载一次
        //而通过mysql的deriver加载,底层已经通过static加载了,再用,就加载两次了,依赖于mysqljar包不利于扩展,耦合度也高

        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/huangquanxin", "root", "123456");
            //通过返回的对象,创建Statement对象,去执行sql语句
            Statement statement = connection.createStatement();
            //放入sql语句
            statement.executeUpdate("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
