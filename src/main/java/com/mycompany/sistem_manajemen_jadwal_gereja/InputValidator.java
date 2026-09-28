package com.mycompany.sistem_manajemen_jadwal_gereja;

import java.util.Scanner;

public class InputValidator {

    public static int inputAngka(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    public static String inputTeksWajib(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input tidak boleh kosong!");
        }
    }

    public static String inputTanggal(Scanner sc, String prompt) {
        return inputTeksWajib(sc, prompt + " (DD-MM-YYYY): ");
    }

    public static String inputJam(Scanner sc, String prompt) {
        return inputTeksWajib(sc, prompt + " (HH:MM): ");
    }

    public static String inputIdPetugas(Scanner sc, ManajemenKegiatan m) {
        String id = inputTeksWajib(sc, "ID Petugas: ");
        if (!m.idPetugasAda(id)) {
            System.out.println("ID Petugas tidak ditemukan!");
            return null;
        }
        return id;
    }

    public static String inputIdTempat(Scanner sc, ManajemenKegiatan m) {
        String id = inputTeksWajib(sc, "ID Tempat: ");
        if (!m.idTempatAda(id)) {
            System.out.println("ID Tempat tidak ditemukan!");
            return null;
        }
        return id;
    }

    public static String cariIdKegiatan(Scanner sc, ManajemenKegiatan m) {
        String id = inputTeksWajib(sc, "Masukkan ID Kegiatan: ");
        if (!m.idKegiatanAda(id)) {
            System.out.println("ID Kegiatan tidak ditemukan!");
            return null;
        }
        return id;
    }

    public static String cariIdPetugas(Scanner sc, ManajemenKegiatan m) {
        String id = inputTeksWajib(sc, "Masukkan ID Petugas: ");
        if (!m.idPetugasAda(id)) {
            System.out.println("ID Petugas tidak ditemukan!");
            return null;
        }
        return id;
    }

    public static String cariIdTempat(Scanner sc, ManajemenKegiatan m) {
        String id = inputTeksWajib(sc, "Masukkan ID Tempat: ");
        if (!m.idTempatAda(id)) {
            System.out.println("ID Tempat tidak ditemukan!");
            return null;
        }
        return id;
    }
}