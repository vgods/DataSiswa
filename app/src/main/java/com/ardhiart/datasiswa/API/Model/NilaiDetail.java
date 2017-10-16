package com.ardhiart.datasiswa.API.Model;

/**
 * Created by Hinata on 10/16/2017.
 */
public class NilaiDetail {
    String score = "";
    String id = "";
    String siswaId = "";
    String tugasId = "";
    Tugas tugas = new Tugas();

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiswaId() {
        return siswaId;
    }

    public void setSiswaId(String siswaId) {
        this.siswaId = siswaId;
    }

    public String getTugasId() {
        return tugasId;
    }

    public void setTugasId(String tugasId) {
        this.tugasId = tugasId;
    }

    public Tugas getTugas() {
        return tugas;
    }

    public void setTugas(Tugas tugas) {
        this.tugas = tugas;
    }
}
