package com.pendaftaran.ui;

import com.pendaftaran.model.Admin;
import com.pendaftaran.model.CalonMahasiswa;
import com.pendaftaran.service.PendaftaranService;
import com.pendaftaran.util.InputReader;
import com.pendaftaran.util.ValidationUtil;
import java.util.Scanner;

public class AdminMenu {

    private final PendaftaranService pendaftaranService;
    private final Scanner scanner;

    public AdminMenu(PendaftaranService pendaftaranService, Scanner scanner) {
        this.pendaftaranService = pendaftaranService;
        this.scanner = scanner;
    }

    public void tampilkan(Admin admin) {
        System.out.println("\nHalo " + admin.getNama() + ", Anda masuk sebagai " + admin.getRole() + ".");
        while (true) {
            System.out.println();
            System.out.println("== Menu Admin ==");
            System.out.println("1. Tampilkan semua calon");
            System.out.println("2. Cari calon");
            System.out.println("3. Ubah total nilai calon");
            System.out.println("4. Hapus calon");
            System.out.println("0. Logout");

            int pilihan = InputReader.bacaInt("Pilih menu admin: ", scanner, 0, 4);
            switch (pilihan) {
                case 1 -> tampilkanSemuaCalon();
                case 2 -> cariCalon();
                case 3 -> ubahTotalNilaiCalon();
                case 4 -> hapusCalon();
                case 0 -> {
                    System.out.println("Logout berhasil. Kembali ke menu utama.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    private void tampilkanSemuaCalon() {
        System.out.println("\n== Daftar Calon Mahasiswa ==");
        pendaftaranService.tampilkanSemuaCalon();
    }

    private void cariCalon() {
        System.out.println("\n== Cari Calon Mahasiswa ==");
        String nama = InputReader.bacaString("Masukkan nama calon: ", scanner);
        if (!ValidationUtil.isNotBlank(nama)) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }
        CalonMahasiswa calon = pendaftaranService.cariCalon(nama);
        if (calon == null) {
            System.out.println("Calon mahasiswa tidak ditemukan.");
        } else {
            System.out.println(calon.ringkasan());
        }
    }

    private void ubahTotalNilaiCalon() {
        System.out.println("\n== Ubah Total Nilai Calon ==");
        String nama = InputReader.bacaString("Masukkan nama calon: ", scanner);
        if (!ValidationUtil.isNotBlank(nama)) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }
        int totalNilai = InputReader.bacaInt("Total nilai baru: ", scanner, 0, 300);
        boolean berhasil = pendaftaranService.ubahTotalNilai(nama, totalNilai);
        if (berhasil) {
            System.out.println("Total nilai berhasil diperbarui.");
        } else {
            System.out.println("Calon mahasiswa tidak ditemukan.");
        }
    }

    private void hapusCalon() {
        System.out.println("\n== Hapus Calon Mahasiswa ==");
        String nama = InputReader.bacaString("Masukkan nama calon yang akan dihapus: ", scanner);
        if (!ValidationUtil.isNotBlank(nama)) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }
        boolean berhasil = pendaftaranService.hapusCalon(nama);
        if (berhasil) {
            System.out.println("Calon mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Calon mahasiswa tidak ditemukan.");
        }
    }
}
