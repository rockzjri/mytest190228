package cn.itcast.test;

import java.sql.*;

public class CostomerJDBCtest {

    public static void main(String[] args) throws Exception {

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "root");

        String sql = "select * from cst_customer";

        PreparedStatement statm = conn.prepareStatement(sql);

        ResultSet rs = statm.executeQuery();

        while (rs.next()) {

            System.out.println("用户ID：" + rs.getInt("cust_id") + "用户姓名：" + rs.getString("cust_name"));

        }
        if (rs != null) rs.close();
        if (statm != null) statm.close();
        if (conn != null) conn.close();

    }
}
