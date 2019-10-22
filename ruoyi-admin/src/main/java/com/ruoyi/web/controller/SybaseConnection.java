package com.ruoyi.web.controller;

import java.sql.*;

public class SybaseConnection {

    private Connection conn = null;

    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance(); // 通过jtds方式连接
            String url = "jdbc:jtds:sybase://135.148.52.159:2640/dwhdb";// 通过jtds方式连接，test为数据库名
            conn = DriverManager.getConnection(url, "dcbo", "dcbo");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void close(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
