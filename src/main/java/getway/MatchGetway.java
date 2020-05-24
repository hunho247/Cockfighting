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
import model.Match;
import model.Paginate;

/**
 *
 * @author HungS7
 */
public class MatchGetway {

    DBConnection connection = new DBConnection();
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean insert(Match trandau) {
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("insert into trandau values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, null);
            pst.setString(2, trandau.getLoaiga());
            pst.setString(3, trandau.getMauao());
            pst.setString(4, trandau.getMauquan());
            pst.setString(5, trandau.getMaunon());
            pst.setString(6, trandau.getSanchoi());
            pst.setString(7, trandau.getKetqua());
            pst.setString(8, trandau.getThongtinthem());
            pst.setBytes(9, trandau.getHinhanh());
            pst.executeUpdate();
            pst.close();
            con.close();
            connection.con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(Match match) {
        con = connection.geConnection();

        try {
            pst = con.prepareStatement("update trandau set loaiga=?,mauao=?,mauquan=?,maunon=?,sanchoi=?,ketqua=?,thongtinthem=?,hinhanh=? where id=?");

            pst.setString(1, match.getLoaiga());
            pst.setString(2, match.getMauao());
            pst.setString(3, match.getMauquan());
            pst.setString(4, match.getMaunon());
            pst.setString(5, match.getSanchoi());
            pst.setString(6, match.getKetqua());
            pst.setString(7, match.getThongtinthem());
            pst.setBytes(8, match.getHinhanh());

            pst.executeUpdate();
            pst.close();
            con.close();
            connection.con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Match selectedMatch(int id) {
        Match trandau = new Match();
        DBConnection bConnection = new DBConnection();
        Connection nCon = bConnection.geConnection();
        try {
            PreparedStatement nPst = nCon.prepareStatement("select * from trandau where id=?");
            nPst.setInt(1, id);
            ResultSet nRs = nPst.executeQuery();
            if (nRs.next()) {
                trandau.setId(nRs.getInt(1));
                trandau.setLoaiga(nRs.getString(2));
                trandau.setMauao(nRs.getString(3));
                trandau.setMauquan(nRs.getString(4));
                trandau.setMaunon(nRs.getString(5));
                trandau.setSanchoi(nRs.getString(6));
                trandau.setKetqua(nRs.getString(7));
                trandau.setThongtinthem(nRs.getString(8));
                trandau.setHinhanh(nRs.getBytes(9));
            }
            nRs.close();
            nPst.close();
            nCon.close();
            bConnection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trandau;
    }

    public boolean delete(int id) {
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("delete from trandau where id=" + id);
            pst.executeUpdate();
            pst.close();
            con.close();
            connection.con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int totalMatch() {
        int total = 0;
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("select count(id) from trandau");
            rs = pst.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int totalSearchMatch(String loaiga, String mauao, String mauquan, String maunon, String sanchoi, String ketqua) {
        int total = 0;
        String query = "select count(id) from trandau where ";
        
        if (!loaiga.isEmpty()) {
        	query += "loaiga='" + loaiga + "'";
        }
        if (!mauao.isEmpty()) {
        	query += " and mauao='" + mauao + "'";
        }
        if (!mauquan.isEmpty()) {
        	query += " and mauquan='" + mauquan + "'";
        }
        if (!maunon.isEmpty()) {
        	query += " and maunon='" + maunon + "'";
        }
        if (!sanchoi.isEmpty()) {
        	query += " and sanchoi='" + sanchoi + "'";
        }
        if (!ketqua.isEmpty()) {
        	query += " and ketqua='" + ketqua + "'";
        }
        
        con = connection.geConnection();
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public ObservableList<Match> Match(Paginate paginate) {
        ObservableList<Match> listData = FXCollections.observableArrayList();
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("select * from trandau limit " + paginate.getStart() + "," + paginate.getEnd());
            rs = pst.executeQuery();
            while (rs.next()) {
                listData.add(new Match(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBytes(9)));
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }

    public ObservableList<Match> searchMatch(Paginate paginate, String loaiga, String mauao, String mauquan, String maunon, String sanchoi, String ketqua) {
        ObservableList<Match> listData = FXCollections.observableArrayList();
        String query = "select * from trandau where ";
        
        if (!loaiga.isEmpty()) {
        	query += "loaiga='" + loaiga + "'";
        }
        if (!mauao.isEmpty()) {
        	query += " and mauao='" + mauao + "'";
        }
        if (!mauquan.isEmpty()) {
        	query += " and mauquan='" + mauquan + "'";
        }
        if (!maunon.isEmpty()) {
        	query += " and maunon='" + maunon + "'";
        }
        if (!sanchoi.isEmpty()) {
        	query += " and sanchoi='" + sanchoi + "'";
        }
        if (!ketqua.isEmpty()) {
        	query += " and ketqua='" + ketqua + "'";
        }
        
        con = connection.geConnection();
        try {
            pst = con.prepareStatement(query +" limit " + paginate.getStart() + "," + paginate.getEnd());
//            pst.setString(1, query + "%");
//            pst.setString(2, query + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                listData.add(new Match(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBytes(9)));
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }

    public ObservableList<Match> allMatch() {
        ObservableList<Match> listData = FXCollections.observableArrayList();
        con = connection.geConnection();
        try {
            pst = con.prepareStatement("select id, name from trandau order by name");
            rs = pst.executeQuery();
            while (rs.next()) {
                listData.add(new Match(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBytes(9)));
            }
            rs.close();
            pst.close();
            con.close();
            connection.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchGetway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }
}
