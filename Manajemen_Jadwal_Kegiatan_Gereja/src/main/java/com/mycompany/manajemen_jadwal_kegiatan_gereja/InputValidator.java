package com.mycompany.manajemen_jadwal_kegiatan_gereja;

import java.util.Scanner;

public class InputValidator {
    public static String inputTeks(Scanner sc, String pesan) {
        System.out.print(pesan);
        return sc.nextLine();
    }

    public static int inputAngka(Scanner sc, String pesan) {
        System.out.print(pesan);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static String inputTanggal(Scanner sc, String pesan) {
        System.out.print(pesan + " (dd-MM-yyyy): ");
        return sc.nextLine();
    }

    public static String inputJam(Scanner sc, String pesan) {
        System.out.print(pesan + " (HH:mm): ");
        return sc.nextLine();
    }
}