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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Information;

/**
 *
 * @author HungG7
 */
public class InformationGetway {

    DBConnection connection = new DBConnection();
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ObservableList<Information> select(String table) {
        ObservableList<Information> listData = FXCollections.observableArrayList();

        con = connection.geConnection();
        try {
            pst = con.prepareStatement("select * from " + table);
            rs = pst.executeQuery();
            while (rs.next()) {
                listData.add(new Information(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(InformationGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }

    public boolean insert(String table, String data) {
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("insert into " + table + " values(?,?)");
            pst.setString(1, null);
            pst.setString(2, data);
            pst.executeUpdate();
            pst.close();
            con.close();
            connection.con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InformationGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(String table, String name) {
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("delete from " + table + " where name='" + name + "'");
            pst.executeUpdate();
            pst.close();
            con.close();
            connection.con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(InformationGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
