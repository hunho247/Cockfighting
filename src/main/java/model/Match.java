/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HungS7
 */
public class Match {
    private int id;
    private String loaiga;
    private String mauao;
    private String mauquan;
    private String maunon;
    private String sanchoi;
    private String ketqua;
    private String thongtinthem;
    private byte[] hinhanh;
    
    public Match() {
    }

    public Match(String loaiga, String mauao, String mauquan, String maunon, String sanchoi, String ketqua, String thongtinthem, byte[] hinhanh) {
        this.loaiga = loaiga;
        this.mauao = mauao;
        this.mauquan = mauquan;
        this.maunon = maunon;
        this.sanchoi = sanchoi;
        this.ketqua = ketqua;
        this.thongtinthem = thongtinthem;
        this.hinhanh = hinhanh;
    }
    
    public Match(int id, String loaiga, String mauao, String mauquan, String maunon, String sanchoi, String ketqua, String thongtinthem, byte[] hinhanh) {
        this.id = id;
        this.loaiga = loaiga;
        this.mauao = mauao;
        this.mauquan = mauquan;
        this.maunon = maunon;
        this.sanchoi = sanchoi;
        this.ketqua = ketqua;
        this.thongtinthem = thongtinthem;
        this.hinhanh = hinhanh;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the loaiga
     */
    public String getLoaiga() {
        return loaiga;
    }

    /**
     * @param loaiga the loaiga to set
     */
    public void setLoaiga(String loaiga) {
        this.loaiga = loaiga;
    }

    /**
     * @return the mauao
     */
    public String getMauao() {
        return mauao;
    }

    /**
     * @param mauao the mauao to set
     */
    public void setMauao(String mauao) {
        this.mauao = mauao;
    }

    /**
     * @return the mauquan
     */
    public String getMauquan() {
        return mauquan;
    }

    /**
     * @param mauquan the mauquan to set
     */
    public void setMauquan(String mauquan) {
        this.mauquan = mauquan;
    }

    /**
     * @return the maunon
     */
    public String getMaunon() {
        return maunon;
    }

    /**
     * @param maunon the maunon to set
     */
    public void setMaunon(String maunon) {
        this.maunon = maunon;
    }

    /**
     * @return the sanchoi
     */
    public String getSanchoi() {
        return sanchoi;
    }

    /**
     * @param sanchoi the sanchoi to set
     */
    public void setSanchoi(String sanchoi) {
        this.sanchoi = sanchoi;
    }

    /**
     * @return the ketqua
     */
    public String getKetqua() {
        return ketqua;
    }

    /**
     * @param ketqua the ketqua to set
     */
    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    /**
     * @return the thongtinthem
     */
    public String getThongtinthem() {
        return thongtinthem;
    }

    /**
     * @param thongtinthem the thongtinthem to set
     */
    public void setThongtinthem(String thongtinthem) {
        this.thongtinthem = thongtinthem;
    }

    /**
     * @return the hinhanh
     */
    public byte[] getHinhanh() {
        return hinhanh;
    }

    /**
     * @param hinhanh the hinhanh to set
     */
    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }
}
