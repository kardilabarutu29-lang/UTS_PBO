package com.mycompany.sistem_manajemen_jadwal_gereja;

import java.util.ArrayList;

public class ManajemenKegiatan {

    final ArrayList<Kegiatan> listKegiatan = new ArrayList<>();
    private final ArrayList<Petugas> listPetugas = new ArrayList<>();
    private final ArrayList<Tempat> listTempat = new ArrayList<>();

    public ManajemenKegiatan() {

        listPetugas.add(
                new Petugas("P01", "Darius", "Prodiakon", "08123456789")
        );

        listTempat.add(
                new Tempat("T01", "Gereja Utama", "Lantai 1", 500)
        );

        listKegiatan.add(
                new KegiatanIbadah("K01", "Misa OMK", "15-08-2026", "17:00", "Ibadah", "Misa Pemuda", "P01", "T01")
        );

        listKegiatan.add(
                new KegiatanSosial("K02", "Bakti Sosial OMK", "20-08-2026", "09:00", "Sosial", "Pembagian bantuan kepada masyarakat", "P01", "T01")
        );
    }

    // DENGAN PENERAPAN POLYMORPHISM (OVERRIDING)
    public void tampilKegiatan() {
        if (listKegiatan.isEmpty()) {
            System.out.println("Data kegiatan kosong.");
            return;
        }

        for (Kegiatan k : listKegiatan) {
            // Memanggil cetakRingkasan() sesuai tipe objek spesifiknya (KegiatanIbadah/KegiatanSosial)
            k.cetakRingkasan(); 
        }
    }

    // IMPLEMENTASI POLYMORPHISM (METHOD OVERLOADING) - Varian 1 (Cari berdasar ID)
    public void cariKegiatan(String id) {
        boolean ketemu = false;
        for (Kegiatan k : listKegiatan) {
            if (k.getId().equalsIgnoreCase(id)) {
                System.out.print("Ditemukan: ");
                k.cetakRingkasan();
                ketemu = true;
                break;
            }
        }
        if (!ketemu) System.out.println("Kegiatan tidak ditemukan.");
    }

    // IMPLEMENTASI POLYMORPHISM (METHOD OVERLOADING) - Varian 2 (Cari berdasar Kategori)
    public void cariKegiatan(String kategori, boolean filterKategori) {
        boolean ketemu = false;
        for (Kegiatan k : listKegiatan) {
            if (k.getKategori().equalsIgnoreCase(kategori)) {
                k.cetakRingkasan();
                ketemu = true;
            }
        }
        if (!ketemu) System.out.println("Tidak ada kegiatan dengan kategori " + kategori);
    }

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

    public boolean idKegiatanAda(String id) {
        for (Kegiatan k : listKegiatan) {
            if (k.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    public boolean idPetugasAda(String id) {
        for (Petugas p : listPetugas) {
            if (p.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    public boolean idTempatAda(String id) {
        for (Tempat t : listTempat) {
            if (t.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    public void tambahPetugas(String id, String nama, String peran, String noHp) {
        listPetugas.add(new Petugas(id, nama, peran, noHp));
    }

    public void tambahTempat(String id, String nama, String lokasi, int kapasitas) {
        listTempat.add(new Tempat(id, nama, lokasi, kapasitas));
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

    public boolean hapusKegiatan(String id) {
        return listKegiatan.removeIf(k -> k.getId().equalsIgnoreCase(id));
    }

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