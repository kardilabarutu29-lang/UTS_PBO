package com.mycompany.sistem_manajemen_jadwal_gereja;

public class KegiatanSosial extends Kegiatan {

    public KegiatanSosial(String id, String nama, String tanggal, String jam, String kategori, String deskripsi, String idPetugas, String idTempat) {
        super(id, nama, tanggal, jam, kategori, deskripsi, idPetugas, idTempat);
    }

    // IMPLEMENTASI POLYMORPHISM (OVERRIDING)
    @Override
    public void cetakRingkasan() {
        System.out.println("[" + getId() + "] " + getNama() + " | " + getTanggal() + " " + getJam() 
                + " | [SOSIAL] - Catatan: Terbuka untuk umum & partisipasi jemaat.");
    }
}