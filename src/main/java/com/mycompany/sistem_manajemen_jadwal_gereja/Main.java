package com.mycompany.sistem_manajemen_jadwal_gereja;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ManajemenKegiatan m = new ManajemenKegiatan();
            
            int pilih = -1;
            
            while (pilih != 0) {
                System.out.println("\n=== SISTEM MANAJEMEN GEREJA ===");
                System.out.println("1. Kelola Kegiatan");
                System.out.println("2. Kelola Petugas");
                System.out.println("3. Kelola Tempat");
                System.out.println("0. Keluar");
                
                pilih = InputValidator.inputAngka(sc, "Pilih: ");
                
                switch (pilih) {
                    case 1 -> {
                        System.out.println("\n--- DATA KEGIATAN ---");
                        System.out.println("1. Lihat | 2. Tambah | 3. Ubah | 4. Hapus | 0. Kembali");
                        
                        int sub = InputValidator.inputAngka(sc, "Pilih: ");
                        
                        switch (sub) {
                            case 1 -> m.tampilKegiatan();
                            
                            case 2 -> {
                                String id = InputValidator.inputTeksWajib(sc, "ID Kegiatan: ");
                                if (m.idKegiatanAda(id)) {
                                    System.out.println("ID Kegiatan sudah digunakan!");
                                    break;
                                }
                                
                                String nama = InputValidator.inputTeksWajib(sc, "Nama: ");
                                String tanggal = InputValidator.inputTanggal(sc, "Tanggal");
                                String jam = InputValidator.inputJam(sc, "Jam");
                                String kategori = InputValidator.inputTeksWajib(sc, "Kategori (Ibadah/Sosial): ");
                                
                                if (!kategori.equalsIgnoreCase("Ibadah") && !kategori.equalsIgnoreCase("Sosial")) {
                                    System.out.println("Kategori harus Ibadah atau Sosial!");
                                    break;
                                }
                                
                                String deskripsi = InputValidator.inputTeksWajib(sc, "Deskripsi: ");
                                String idPetugas = InputValidator.inputIdPetugas(sc, m);
                                if (idPetugas == null) break;
                                
                                String idTempat = InputValidator.inputIdTempat(sc, m);
                                if (idTempat == null) break;
                                
                                if (kategori.equalsIgnoreCase("Ibadah")) {
                                    m.listKegiatan.add(new KegiatanIbadah(id, nama, tanggal, jam, kategori, deskripsi, idPetugas, idTempat));
                                } else {
                                    m.listKegiatan.add(new KegiatanSosial(id, nama, tanggal, jam, kategori, deskripsi, idPetugas, idTempat));
                                }
                                
                                System.out.println("Kegiatan berhasil ditambahkan!");
                            }
                            
                            case 3 -> {
                                String id = InputValidator.cariIdKegiatan(sc, m);
                                if (id == null) break;
                                String nama = InputValidator.inputTeksWajib(sc, "Nama Baru: ");
                                String tanggal = InputValidator.inputTanggal(sc, "Tanggal Baru");
                                String jam = InputValidator.inputJam(sc, "Jam Baru");
                                String kategori = InputValidator.inputTeksWajib(sc, "Kategori Baru: ");
                                String deskripsi = InputValidator.inputTeksWajib(sc, "Deskripsi Baru: ");
                                
                                if (m.editKegiatan(id, nama, tanggal, jam, kategori, deskripsi)) {
                                    System.out.println("Data berhasil diubah!");
                                }
                            }
                            
                            case 4 -> {
                                String id = InputValidator.cariIdKegiatan(sc, m);
                                if (id == null) break;
                                if (m.hapusKegiatan(id)) {
                                    System.out.println("Data berhasil dihapus!");
                                }
                            }
                        }
                    }
                    
                    case 2 -> {
                        System.out.println("\n--- DATA PETUGAS ---");
                        System.out.println("1. Lihat | 2. Tambah | 3. Ubah | 4. Hapus | 0. Kembali");
                        
                        int sub = InputValidator.inputAngka(sc, "Pilih: ");
                        switch (sub) {
                            case 1 -> m.tampilPetugas();
                            
                            case 2 -> {
                                String idP = InputValidator.inputTeksWajib(sc, "ID Petugas: ");
                                if (m.idPetugasAda(idP)) {
                                    System.out.println("ID Petugas sudah digunakan!");
                                    break;
                                }
                                String namaP = InputValidator.inputTeksWajib(sc, "Nama: ");
                                String peran = InputValidator.inputTeksWajib(sc, "Peran: ");
                                String noHp = InputValidator.inputTeksWajib(sc, "No HP: ");
                                
                                m.tambahPetugas(idP, namaP, peran, noHp);
                                System.out.println("Petugas berhasil ditambahkan!");
                            }
                            
                            case 3 -> {
                                String idP = InputValidator.cariIdPetugas(sc, m);
                                if (idP == null) break;
                                String namaP = InputValidator.inputTeksWajib(sc, "Nama Baru: ");
                                String peran = InputValidator.inputTeksWajib(sc, "Peran Baru: ");
                                String noHp = InputValidator.inputTeksWajib(sc, "No HP Baru: ");
                                
                                if (m.editPetugas(idP, namaP, peran, noHp)) {
                                    System.out.println("Data berhasil diubah!");
                                }
                            }
                            
                            case 4 -> {
                                String idP = InputValidator.cariIdPetugas(sc, m);
                                if (idP == null) break;
                                if (m.hapusPetugas(idP)) {
                                    System.out.println("Data berhasil dihapus!");
                                }
                            }
                        }
                    }
                    
                    case 3 -> {
                        System.out.println("\n--- DATA TEMPAT ---");
                        System.out.println("1. Lihat | 2. Tambah | 3. Ubah | 4. Hapus | 0. Kembali");
                        
                        int sub = InputValidator.inputAngka(sc, "Pilih: ");
                        switch (sub) {
                            case 1 -> m.tampilTempat();
                            
                            case 2 -> {
                                String idT = InputValidator.inputTeksWajib(sc, "ID Tempat: ");
                                if (m.idTempatAda(idT)) {
                                    System.out.println("ID Tempat sudah digunakan!");
                                    break;
                                }
                                String namaT = InputValidator.inputTeksWajib(sc, "Nama: ");
                                String lokasi = InputValidator.inputTeksWajib(sc, "Lokasi: ");
                                int kapasitas = InputValidator.inputAngka(sc, "Kapasitas: ");
                                
                                m.tambahTempat(idT, namaT, lokasi, kapasitas);
                                System.out.println("Tempat berhasil ditambahkan!");
                            }
                            
                            case 3 -> {
                                String idT = InputValidator.cariIdTempat(sc, m);
                                if (idT == null) break;
                                String namaT = InputValidator.inputTeksWajib(sc, "Nama Baru: ");
                                String lokasi = InputValidator.inputTeksWajib(sc, "Lokasi Baru: ");
                                int kapasitas = InputValidator.inputAngka(sc, "Kapasitas Baru: ");
                                
                                if (m.editTempat(idT, namaT, lokasi, kapasitas)) {
                                    System.out.println("Data berhasil diubah!");
                                }
                            }
                            
                            case 4 -> {
                                String idT = InputValidator.cariIdTempat(sc, m);
                                if (idT == null) break;
                                if (m.hapusTempat(idT)) {
                                    System.out.println("Data berhasil dihapus!");
                                }
                            }
                        }
                    }
                    
                    case 0 -> System.out.println("Program selesai. Berkah Dalem!");
                    default -> System.out.println("Pilihan tidak valid!");
                }
            }
        }
    }
}