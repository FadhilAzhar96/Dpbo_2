package com.pendaftaran.ui;

import com.pendaftaran.auth.AuthService;
import com.pendaftaran.model.CalonMahasiswa;
import com.pendaftaran.service.PendaftaranService;
import com.pendaftaran.util.InputReader;
import com.pendaftaran.util.ValidationUtil;
import java.util.Scanner;

public class CalonMenu {

    private final PendaftaranService pendaftaranService;
    private final AuthService authService;
    private final Scanner scanner;

    public CalonMenu(PendaftaranService pendaftaranService, AuthService authService, Scanner scanner) {
        this.pendaftaranService = pendaftaranService;
        this.authService = authService;
        this.scanner = scanner;
    }

    public void tampilkan() {
        while (true) {
            System.out.println();
            System.out.println("== Menu Calon Mahasiswa ==");
            System.out.println("1. Daftar calon mahasiswa");
            System.out.println("2. Login calon mahasiswa");
            System.out.println("0. Kembali ke menu utama");

            int pilihan = InputReader.bacaInt("Pilih menu calon: ", scanner, 0, 2);
            switch (pilihan) {
                case 1 -> daftarCalon();
                case 2 -> loginCalon();
                case 0 -> {
                    System.out.println("Kembali ke menu utama.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    private void daftarCalon() {
        System.out.println("\n== Pendaftaran Calon Mahasiswa ==");
        String fakultas = InputReader.bacaString("Masukkan fakultas: ", scanner);
        if (!ValidationUtil.isNotBlank(fakultas)) {
            System.out.println("Fakultas tidak boleh kosong.");
            return;
        }
        CalonMahasiswa calon = pendaftaranService.daftarCalon(fakultas);
        System.out.println("Pendaftaran berhasil. Nama calon Anda: " + calon.getNama());
        System.out.println("Silakan login menggunakan nama tersebut pada menu Calon Mahasiswa.");
    }

    private void loginCalon() {
        System.out.println("\n== Login Calon Mahasiswa ==");
        String nama = InputReader.bacaString("Masukkan nama calon: ", scanner);
        if (!ValidationUtil.isNotBlank(nama)) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }
        CalonMahasiswa calon = authService.loginCalon(nama);
        if (calon == null) {
            System.out.println("Calon mahasiswa tidak ditemukan. Pastikan nama sudah benar.");
            return;
        }
        tampilkanPanelCalon(calon);
    }

    private void tampilkanPanelCalon(CalonMahasiswa calon) {
        System.out.println("\nHalo " + calon.getNama() + ", Anda telah login sebagai calon mahasiswa.");
        while (true) {
            System.out.println();
            System.out.println("== Panel Calon Mahasiswa ==");
            System.out.println("1. Lihat data diri");
            System.out.println("2. Lihat status kelulusan");
            System.out.println("0. Logout");

            int pilihan = InputReader.bacaInt("Pilih menu: ", scanner, 0, 2);
            switch (pilihan) {
                case 1 -> System.out.println(calon.ringkasan());
                case 2 -> System.out.println("Status kelulusan: " + calon.getStatusKelulusan().getLabel());
                case 0 -> {
                    System.out.println("Logout calon mahasiswa.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
