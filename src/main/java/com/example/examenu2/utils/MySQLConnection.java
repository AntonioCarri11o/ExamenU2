package com.example.examenu2.utils;

import java.sql.*;

public class MySQLConnection {
    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void close(Connection connection, PreparedStatement pstm, ResultSet rs){
        try{
            if(connection!=null)
                connection.close();
            if(pstm!=null)
                connection.close();
            if(rs!=null)
                connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void main (String args[]){
        Connection conexion= MySQLConnection.getConnection();
        if(conexion!= null) {
            System.out.println("Conectado");
        }else{
            System.out.println("No conectado");
        }
    }
}
