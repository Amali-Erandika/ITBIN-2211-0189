/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DBConnection;
import View.Login;
import javax.swing.JOptionPane;
import View.Home;
import Model.DBSearch;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author G.A.E Ganhewage
 */
public class LoginController {
    public static void login(String usName, String pass){
        try{
            String username=null;
            String password=null;
            ResultSet rs=new DBSearch().searchLogin(usName);
            while (rs.next()){
                username=rs.getString("username");
                password=rs.getString("password");
            }
            if(username!=null && password!=null){
                if(password.equals(pass)){
                    System.out.println("Successfull");
                    Login.getFrames()[0].dispose();
                    new Home().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Please check username and password","Error",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Please check username and password","Error",JOptionPane.ERROR_MESSAGE);
            }
            DBConnection.closeCon();
        }catch(SQLException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
