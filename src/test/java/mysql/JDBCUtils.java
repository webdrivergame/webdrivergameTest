package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

//提供获取连接的方法

    private static Connection conn=null;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/goods?characterEncoding=utf-8";
            String username="root";
            String password="123456";
            conn=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e+"数据库连接失败");
        }

    }
    //获取数据库连接对象
    public static Connection getConnection(){
        return conn;
    }
    //关闭数据库的方法
    public static void close(ResultSet rs,Statement sta,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(sta!=null){
            try {
                sta.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement sta,Connection conn){
        if(sta!=null){
            try {
                sta.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
