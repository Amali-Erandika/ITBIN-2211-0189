/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;





/**
 *
 * @author G.A.E Ganhewage
 */
public class DBConnection {
    static Connection conn;
    static Statement stat = null;
    public static Connection getCon()
    {
        try 
            
        {
            String url="jdbc:mysql://localhost:3306/lms";
            conn=DriverManager.getConnection(url,"root","");
            stat = conn.createStatement();
            System.out.println("Successfully Connected with the DB");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public static Statement getStatementConnection(){
        try{
            if(conn==null||conn.isClosed()){
                getCon();
            }
            stat=conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        return stat;
    }
public static void closeCon() throws SQLException{
    if(conn!=null && !conn.isClosed()){
conn.close();
    }
}
}
        
        
        
        
    
 
 




