/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author G.A.E Ganhewage
 */
public class DBSearch {
    Statement stmt;
    ResultSet rs;
    public ResultSet searchLogin(String usName){
        try{
            stmt=DBConnection.getStatementConnection();
            String name = usName;
            rs = stmt.executeQuery("SELECT * FROM login WHERE username='" + name +"'");
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return rs;
    }
    
}
