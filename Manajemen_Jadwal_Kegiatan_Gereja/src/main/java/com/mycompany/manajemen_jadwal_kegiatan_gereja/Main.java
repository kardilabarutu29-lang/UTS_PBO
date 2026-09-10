package com.mycompany.manajemen_jadwal_kegiatan_gereja;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManajemenKegiatan m = new ManajemenKegiatan();
        int pilih = -1;

        while (pilih != 0) {
            System.out.println("\n=== MANAJEMEN GEREJA (OMK) ===");
            System.out.println("1. Kelola Kegiatan\n2. Kelola Petugas\n3. Kelola Tempat\n0. Keluar");
            pilih = InputValidator.inputAngka(sc, "Pilih: ");

            switch (pilih) {
                case 1:
                    System.out.println("\n--- DATA KEGIATAN ---");
                    System.out.println("1. Lihat | 2. Tambah | 3. Ubah | 4. Hapus | 0. Kembali");
                    int sub1 = InputValidator.inputAngka(sc, "Pilih: ");
                    if (sub1 == 1) {
                        m.tampilKegiatan();
                    } else if (sub1 == 2) {
                        String id = InputValidator.inputTeks(sc, "ID: ");
                        String nama = InputValidator.inputTeks(sc, "Nama: ");
                        String tgl = InputValidator.inputTanggal(sc, "Tanggal");
                        String jam = InputValidator.inputJam(sc, "Jam");
                        String kat = InputValidator.inputTeks(sc, "Kategori: ");
                        String desk = InputValidator.inputTeks(sc, "Deskripsi: ");
                        String idP = InputValidator.inputTeks(sc, "ID Petugas: ");
                        String idT = InputValidator.inputTeks(sc, "ID Tempat: ");
                        m.listKegiatan.add(new Kegiatan(id, nama, tgl, jam, kat, desk, idP, idT));
                        System.out.println("Berhasil ditambahkan!");
                    } else if (sub1 == 3) {
                        String id = InputValidator.inputTeks(sc, "Masukkan ID Kegiatan yang diubah: ");
                        String nama = InputValidator.inputTeks(sc, "Nama Baru: ");
                        String tgl = InputValidator.inputTanggal(sc, "Tanggal Baru");
                        String jam = InputValidator.inputJam(sc, "Jam Baru");
                        String kat = InputValidator.inputTeks(sc, "Kategori Baru: ");
                        String desk = InputValidator.inputTeks(sc, "Deskripsi Baru: ");
                        if (m.editKegiatan(id, nama, tgl, jam, kat, desk)) System.out.println("Data berhasil diubah!");
                        else System.out.println("ID tidak ditemukan!");
                    } else if (sub1 == 4) {
                        String id = InputValidator.inputTeks(sc, "ID Kegiatan dihapus: ");
                        m.listKegiatan.removeIf(k -> k.getId().equalsIgnoreCase(id));
                        System.out.println("Data berhasil dihapus!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DATA PETUGAS ---");
                    System.out.println("1. Lihat | 2. Tambah | 3. Ubah | 4. Hapus | 0. Kembali");
                    int sub2 = InputValidator.inputAngka(sc, "Pilih: ");
                    if (sub2 == 1) {
                        m.tampilPetugas();
                    } else if (sub2 == 2) {
                        String id = InputValidator.inputTeks(sc, "ID: ");
                        String nama = InputValidator.inputTeks(sc, "Nama: ");
                        String peran = InputValidator.inputTeks(sc, "Peran: ");
                        String hp = InputValidator.inputTeks(sc, "No HP: ");
                        m.listPetugas.add(new Petugas(id, nama, peran, hp));
                        System.out.println("Berhasil ditambahkan!");
                    } else if (sub2 == 3) {
                        String id = InputValidator.inputTeks(sc, "Masukkan ID Petugas yang diubah: ");
                        String nama = InputValidator.inputTeks(sc, "Nama Baru: ");
                        String peran = InputValidator.inputTeks(sc, "Peran Baru: ");
                        String hp = InputValidator.inputTeks(sc, "No HP Baru: ");
                        if (m.editPetugas(id, nama, peran, hp)) System.out.println("Data berhasil diubah!");
                        else System.out.println("ID tidak ditemukan!");
                    } else if (sub2 == 4) {
                        String id = InputValidator.inputTeks(sc, "ID Petugas dihapus: ");
                        if (m.hapusPetugas(id)) System.out.println("Data berhasil dihapus!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- DATA TEMPAT ---");
                    System.out.println("1. Lihat | 2. Tambah | 3. Ubah | 4. Hapus | 0. Kembali");
                    int sub3 = InputValidator.inputAngka(sc, "Pilih: ");
                    if (sub3 == 1) {
                        m.tampilTempat();
                    } else if (sub3 == 2) {
                        String id = InputValidator.inputTeks(sc, "ID: ");
                        String nama = InputValidator.inputTeks(sc, "Nama: ");
                        String lok = InputValidator.inputTeks(sc, "Lokasi: ");
                        int kap = InputValidator.inputAngka(sc, "Kapasitas: ");
                        m.listTempat.add(new Tempat(id, nama, lok, kap));
                        System.out.println("Berhasil ditambahkan!");
                    } else if (sub3 == 3) {
                        String id = InputValidator.inputTeks(sc, "Masukkan ID Tempat yang diubah: ");
                        String nama = InputValidator.inputTeks(sc, "Nama Baru: ");
                        String lok = InputValidator.inputTeks(sc, "Lokasi Baru: ");
                        int kap = InputValidator.inputAngka(sc, "Kapasitas Baru: ");
                        if (m.editTempat(id, nama, lok, kap)) System.out.println("Data berhasil diubah!");
                        else System.out.println("ID tidak ditemukan!");
                    } else if (sub3 == 4) {
                        String id = InputValidator.inputTeks(sc, "ID Tempat dihapus: ");
                        if (m.hapusTempat(id)) System.out.println("Data berhasil dihapus!");
                    }
                    break;

                case 0:
                    System.out.println("Program selesai. Berkah Dalem!");
                    break;
            }
        }
        sc.close();
    }
}