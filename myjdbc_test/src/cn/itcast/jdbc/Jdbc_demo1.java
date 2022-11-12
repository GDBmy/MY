package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_demo1 {
    public static void main(String[] args) throws Exception {
        //z注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库的链接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studinfor", "root", "G2002@D0101B");
        //新增Tom信息
        //String sql="insert into studentinf_1(id,name,birthday,grade) values(20211170,'Tom','2003.12.01',1);";
        //定义SQL语句:改变小明的等级为4
        //String sql="update studentinf_1 set  grade=4 where id=20211101";
        //删除20211105对应的信息
        //String sql="delete from studentinf_1 where id=20211105";
        //获取执行sql的对象
        //Statement stmt = conn.createStatement();
        //执行sql
        //int count = stmt.executeUpdate(sql);
        //处理结果
        //System.out.println(count);
        //释放资源
        Statement stmt = conn.createStatement();
        //执行sql
        //int count = stmt.executeUpdate(sql);
        //处理结果
        //System.out.println(count);
        //释放资源
        String sql = "select * from studentinf_1";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            System.out.print("姓名:" + rs.getString("name"));
            System.out.print("; ");
            System.out.print("生日:" + rs.getString("birthday"));
            System.out.print("; ");
            System.out.print("等级:" + rs.getInt("grade"));
            System.out.println(". ");
        }
        stmt.close();
        conn.close();
        rs.close();
    }
}