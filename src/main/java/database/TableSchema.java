/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HungS7
 */
public class TableSchema {

    public static void connect() {
        Connection conn = null;
        Statement stmt = null;

        String url = "jdbc:sqlite:cockfighting_store.db";

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS `user` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`user_name`	TEXT,\n"
                    + "	`password`	TEXT NOT NULL\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `trandau` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`loaiga`        TEXT NOT NULL,\n"
                    + "	`mauao`         TEXT NOT NULL,\n"
                    + "	`mauquan`       TEXT NOT NULL,\n"
                    + "	`maunon`        TEXT NOT NULL,\n"
                    + "	`sanchoi`       TEXT NOT NULL,\n"
                    + "	`ketqua`        TEXT NOT NULL,\n"
                    + " `thongtinthem`  TEXT,\n"
                    + "	`hinhanh`       BLOB\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `loaiga` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`          TEXT NOT NULL UNIQUE\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `mauao` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`          TEXT NOT NULL UNIQUE\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `mauquan` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`          TEXT NOT NULL UNIQUE\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `maunon` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`          TEXT NOT NULL UNIQUE\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `sanchoi` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`          TEXT NOT NULL UNIQUE\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `ketqua` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`          TEXT NOT NULL UNIQUE\n"
                    + ");"
                    + "CREATE TABLE IF NOT EXISTS `thongtinthem` (\n"
                    + "	`id`            INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	`name`          TEXT NOT NULL UNIQUE\n"
                    + ");";
            
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TableSchema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
