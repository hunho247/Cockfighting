/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getway;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author HungS7
 */
public class AuthGetway {

    DBConnection connection = new DBConnection();
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean save(User user) {
        boolean saved = false;
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("insert into user values(?,?,?)");
            
            pst.setString(1, null);
            pst.setString(2, user.getUserName());
            pst.setString(3, user.getPassword());
            pst.executeUpdate();
            pst.close();
            con.close();
            connection.con.close();
            saved = true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saved;
    }

    public boolean updateUser(User user) {
        boolean saved = false;
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("update user set user_name=?,password=? where id=?");
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setInt(3, 1);

            pst.executeUpdate();
            pst.close();
            con.close();
            connection.con.close();
            saved = true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saved;
    }

    public User getUser() {
        User user = new User();
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("select * from user where id=1");
            rs = pst.executeQuery();
            if (rs.next()) {
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public int totalUser() {
        int total = 0;
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("select count(id) from user");
            rs = pst.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public boolean authenticate(String userName, String password) {
        boolean isAuthenticate = false;
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("select * from user where user_name=? and password=?");
            pst.setString(1, userName);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                isAuthenticate = true;
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isAuthenticate;
    }

}
