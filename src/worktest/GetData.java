package worktest;

import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 
 public class GetData
 {     //jdbc驱动类名
     String driverStr="com.mysql.cj.jdbc.Driver";
     //数据库url
     String dataStr="jdbc:mysql://192.168.31.158:3306/user?";
     //访问数据库的用户名
     String username="root";
     //访问数据库的密码
     String password="L123456";
     //数据库连接对象
     private Connection conn;
     //构造方法
     public GetData(){
         try {
             //加载驱动类
             Class.forName(driverStr);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
     //获得数据库连接对象的方法
     public Connection getConnection(){
         
         try {
             conn = (Connection) DriverManager.getConnection(dataStr,username,password);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return conn;
     }
     //关闭数据库连接
     public void close(){
         if (conn!=null) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     }
 }