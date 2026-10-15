package controller;

import Model.Petugas;
import Manajemenkegiatan.dao.PetugasDAO;
import Manajemenkegiatan.dao.PetugasDAOImpl;
import Model.Kegiatan;
import java.util.List;

public class ManajemenKegiatan {

    private final PetugasDAO petugasDAO = new PetugasDAOImpl();

    
    public void tampilPetugas() {
        List<Petugas> list = petugasDAO.getAllPetugas();
        if (list.isEmpty()) {
            System.out.println("Data petugas kosong.");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("ID \t| NAMA \t\t| PERAN \t| NO HP");
            System.out.println("--------------------------------------------------");
            for (Petugas p : list) {
                System.out.println(p.getId() + " \t| " + p.getNama() + " \t| " + p.getPeran() + " \t| " + p.getNoHp());
            }
            System.out.println("--------------------------------------------------");
        }
    }


    public void tambahPetugas(String id, String nama, String peran, String noHp) {
        Petugas p = new Petugas(id, nama, peran, noHp);
        petugasDAO.tambahPetugas(p);
        System.out.println("Petugas berhasil disimpan menggunakan Hibernate ORM!");
    }

    public boolean idTempatAda(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean idPetugasAda(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean idKegiatanAda(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean hapusPetugas(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void tampilTempat() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void tambahTempat(String id, String nama, String lokasi, int kapasitas) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean editTempat(String id, String nama, String lokasi, int kapasitas) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean hapusTempat(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean editPetugas(String id, String nama, String peran, String noHp) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean hapusKegiatan(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean editKegiatan(String id, String nama, String tanggal, String jam, String kategori, String deskripsi) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void tambahKegiatan(Kegiatan kegiatan) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void tampilKegiatan() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}