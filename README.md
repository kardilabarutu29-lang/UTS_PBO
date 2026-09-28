#  Sistem Manajemen Jadwal Kegiatan Gereja

**Sistem Manajemen Jadwal Kegiatan Gereja** adalah aplikasi berbasis **Java CLI** (*Command Line Interface*) yang dirancang untuk mengelola dan mengorganisasi agenda kegiatan gereja, data petugas, serta lokasi pelaksanaan acara secara terstruktur.

Aplikasi ini dibangun untuk memenuhi kriteria Pemrograman Berorientasi Objek (**OOP**) dengan menerapkan seluruh pilar utama: **Inheritance**, **Polymorphism** (*Overriding & Overloading*), **Encapsulation**, serta alur **Condition & Looping**.

---

##  Fungsi Utama & Kegunaan

* **Kelola Kegiatan** — Menambahkan, mengubah, menghapus, dan menampilkan jadwal kegiatan (**Ibadah** / **Sosial**).
* **Kelola Petugas** — Mengelola data pelayan gereja (Prodiakon, Lektor, Pemusik, dll.) beserta nomor kontak dan peran.
* **Kelola Tempat** — Mengelola lokasi atau ruangan gereja lengkap dengan informasi kapasitasnya.
* **Data Integrity Validation** — Mencegah penghapusan petugas atau tempat yang sedang terikat dalam kegiatan aktif.

---

## Logika Bisnis & Fitur Operasional

Terdapat pilihan operasi standar **CRUD** (*Create, Read, Update, Delete*) dan fungsi pencarian yang berjalan dengan logika bisnis 

* **Lihat Data (Read & Polymorphism):** Menampilkan seluruh entitas data yang tersimpan. Pada modul kegiatan, *output* memanfaatkan pilar **Polymorphism (Overriding)** untuk membedakan format cetak antara entitas **Ibadah** dan **Sosial**.
* **Tambah Data (Create & Relasi):** Menambahkan entitas baru ke dalam memori sistem Khusus penambahan kegiatan, sistem mewajibkan pengikatan **ID Petugas** dan **ID Tempat** yang valid untuk menjaga integritas relasi antar-objek
* **Ubah Data (Update):** Memperbarui informasi spesifik dari data yang sudah ada berdasarkan ID unik entitas tanpa merusak keterhubungan data lainnya.
* **Hapus Data (Delete & Validasi Integritas):** Menghapus data tertentu dari sistem. Sistem dilengkapi dengan **Validasi Integritas Data** yang melarang penghapusan data Petugas atau Tempat jika data tersebut masih digunakan/terikat pada kegiatan aktif.
* **Cari Data (Polymorphism Overloading):** Memungkinkan pencarian data secara fleksibel]. Method pencarian diimplementasikan menggunakan **Overloading** sehingga pengguna dapat mencari kegiatan berdasarkan kriteria berbeda (misalnya via **ID** atau via **Kategori**).

> ** Penanganan Error (Exception Handling):**  
> Sistem dilengkapi dengan penanganan error (`try-catch`) pada setiap menu input. Jika pengguna memasukkan tipe data yang salah (misalnya memasukkan teks saat sistem meminta angka), program tidak akan berhenti secara mendadak (*crash*), melainkan menampilkan pesan peringatan yang ramah dan meminta input ulang.

---

## Alur Program & Petunjuk Eksekusi

### 1. Tampilan Menu Utama
Menampilkan navigasi utama untuk memilih pengelolaan Kegiatan, Petugas, Tempat, atau Keluar dari program[cite: 1].

### 2. Lihat Data Kegiatan (Polymorphism)
Menunjukkan method `@Override` yang mencetak format khusus berdasarkan tipe kegiatan `[IBADAH]` dan `[SOSIAL]`[cite: 1].

Sistem dilengkapi dengan penanganan error (Try-Catch) pada setiap menu input. Jika pengguna memasukkan tipe data yang salah (misalnya memasukkan teks saat sistem meminta angka), program tidak akan berhenti secara mendadak (crash), melainkan menampilkan pesan peringatan ramah pengguna dan meminta input ulang.


**Alur Program & Petunjuk Eksekusi**

<img width="538" height="162" alt="image" src="https://github.com/user-attachments/assets/86ec68ca-1ab9-4409-8097-d90964b29156" />

Tampilan menu utama



<img width="1055" height="273" alt="image" src="https://github.com/user-attachments/assets/677c1e43-6e2b-422c-9f31-4bd2f253eb19" />

Pilih menu 1 (Kelola Kegiatan) lalu menu 1 (Lihat Data). Menunjukkan method @Override mencetak format khas [IBADAH] dan [SOSIAL].



<img width="1103" height="587" alt="image" src="https://github.com/user-attachments/assets/ad71f89f-ba21-46c5-9137-fa484cba84f4" />

Proses memasukkan data kegiatan baru dengan mengaitkan ID Petugas (P01) dan ID Tempat (T01).

<img width="760" height="262" alt="image" src="https://github.com/user-attachments/assets/be6d35b6-3b0f-4347-b0ff-31d0163b2422" />

Menghapus kegiatan jika kegiatan telah selesai


<img width="663" height="257" alt="image" src="https://github.com/user-attachments/assets/16be525b-1ee6-4753-9526-2295d1632c60" />

<img width="640" height="113" alt="image" src="https://github.com/user-attachments/assets/866ac37f-b456-4161-afa6-31be76c2a515" />

Output dari submenu Kelola Petugas -> Lihat Data dan Kelola Tempat -> Lihat Data.



<img width="740" height="348" alt="image" src="https://github.com/user-attachments/assets/2f194c76-c880-4fb8-a378-140fdc0d02ac" />


Proses mengupdate Petugas



<img width="727" height="268" alt="image" src="https://github.com/user-attachments/assets/6027432e-cd65-4693-bdcd-f437d27ad692" />

Output jika ingin menghapus tempat namun tempat masih digunakan


<img width="712" height="133" alt="image" src="https://github.com/user-attachments/assets/916ae642-fd0e-4742-961d-5c9963d09e96" />

<img width="718" height="427" alt="image" src="https://github.com/user-attachments/assets/852dc45f-38d3-4879-9a75-9f3ec5452fb7" />

inputan jika tidak sesuai tipe data

