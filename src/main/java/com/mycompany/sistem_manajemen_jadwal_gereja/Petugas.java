package com.mycompany.sistem_manajemen_jadwal_gereja;


public class Petugas {
    private String id, nama, peran, noHp;

    public Petugas(String id, String nama, String peran, String noHp) {
        this.id = id;
        this.nama = nama;
        this.peran = peran;
        this.noHp = noHp;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getPeran() { return peran; }
    public String getNoHp() { return noHp; }

    public void setNama(String nama) { this.nama = nama; }
    public void setPeran(String peran) { this.peran = peran; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
}
