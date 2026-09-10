package com.mycompany.manajemen_jadwal_kegiatan_gereja;

import java.util.ArrayList;

public class ManajemenKegiatan {
    public ArrayList<Kegiatan> listKegiatan = new ArrayList<>();
    public ArrayList<Petugas> listPetugas = new ArrayList<>();
    public ArrayList<Tempat> listTempat = new ArrayList<>();

    public ManajemenKegiatan() {
        // Data Awal Khas Gereja Katolik
        listPetugas.add(new Petugas("P01", "Darius", "Prodiakon", "08123456789"));
        listTempat.add(new Tempat("T01", "Gereja Utama", "Lantai 1", 500));
        listKegiatan.add(new Kegiatan("K01", "Misa OMK", "15-08-2026", "17:00", "Ibadah", "Misa Pemuda", "P01", "T01"));
    }

    // --- READ ---
    public void tampilPetugas() {
        if (listPetugas.isEmpty()) {
            System.out.println("Data petugas kosong.");
            return;
        }
        for (Petugas p : listPetugas) {
            System.out.println("[" + p.getId() + "] " + p.getNama() + " - Peran: " + p.getPeran() + " (" + p.getNoHp() + ")");
        }
    }

    public void tampilTempat() {
        if (listTempat.isEmpty()) {
            System.out.println("Data tempat kosong.");
            return;
        }
        for (Tempat t : listTempat) {
            System.out.println("[" + t.getId() + "] " + t.getNama() + " - " + t.getLokasi() + " (Kapasitas: " + t.getKapasitas() + ")");
        }
    }

    public void tampilKegiatan() {
        if (listKegiatan.isEmpty()) {
            System.out.println("Data kegiatan kosong.");
            return;
        }
        for (Kegiatan k : listKegiatan) {
            System.out.println("[" + k.getId() + "] " + k.getNama() + " | " + k.getTanggal() + " " + k.getJam() + " | Kategori: " + k.getKategori());
        }
    }

    // --- UPDATE ---
    public boolean editPetugas(String id, String nama, String peran, String hp) {
        for (Petugas p : listPetugas) {
            if (p.getId().equalsIgnoreCase(id)) {
                p.setNama(nama);
                p.setPeran(peran);
                p.setNoHp(hp);
                return true;
            }
        }
        return false;
    }

    public boolean editTempat(String id, String nama, String lokasi, int kapasitas) {
        for (Tempat t : listTempat) {
            if (t.getId().equalsIgnoreCase(id)) {
                t.setNama(nama);
                t.setLokasi(lokasi);
                t.setKapasitas(kapasitas);
                return true;
            }
        }
        return false;
    }

    public boolean editKegiatan(String id, String nama, String tgl, String jam, String kat, String desk) {
        for (Kegiatan k : listKegiatan) {
            if (k.getId().equalsIgnoreCase(id)) {
                k.setNama(nama);
                k.setTanggal(tgl);
                k.setJam(jam);
                k.setKategori(kat);
                k.setDeskripsi(desk);
                return true;
            }
        }
        return false;
    }

    // --- DELETE (DENGAN CEK RELASI) ---
    public boolean hapusPetugas(String id) {
        for (Kegiatan k : listKegiatan) {
            if (k.getIdPetugas().equalsIgnoreCase(id)) {
                System.out.println("Gagal! Petugas masih terikat di kegiatan.");
                return false;
            }
        }
        return listPetugas.removeIf(p -> p.getId().equalsIgnoreCase(id));
    }

    public boolean hapusTempat(String id) {
        for (Kegiatan k : listKegiatan) {
            if (k.getIdTempat().equalsIgnoreCase(id)) {
                System.out.println("Gagal! Tempat masih dipakai di kegiatan.");
                return false;
            }
        }
        return listTempat.removeIf(t -> t.getId().equalsIgnoreCase(id));
    }
}