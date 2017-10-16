package com.ardhiart.datasiswa.API.Model;

/**
 * Created by Hinata on 10/16/2017.
 */
public class Tugas {
    String nama = "";
    String mulai = "";
    String selesai = "";
    String id = "";
    String guruId = "";
    String mapelId = "";

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getSelesai() {
        return selesai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getMapelId() {
        return mapelId;
    }

    public void setMapelId(String mapelId) {
        this.mapelId = mapelId;
    }
}
