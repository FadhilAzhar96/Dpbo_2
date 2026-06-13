package com.lgcns.ui;

import java.util.Scanner;

/**
 * Menangani seluruh urusan antarmuka pengguna (UI) berbasis konsol: menampilkan
 * teks dan membaca input dari keyboard.
 */
public class MenuKonsol {

    private Scanner scanner;

    public MenuKonsol() {
        this.scanner = new Scanner(System.in);
    }

    // Mencetak daftar opsi ke layar
    public void tampilkanMenuUtama() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("   SISTEM PENDAFTARAN CALON MAHASISWA");
        System.out.println("========================================");
        System.out.println("1. Input Calon Mahasiswa Baru");
        System.out.println("2. Tampilkan Semua Calon");
        System.out.println("3. Cari Calon (berdasarkan nama)");
        System.out.println("4. Ubah Nilai Tes Calon");
        System.out.println("5. Hapus Calon");
        System.out.println("6. Tampilkan Calon Nilai Tertinggi");
        System.out.println("7. Ringkasan Statistik Pendaftaran");
        System.out.println("0. Keluar");
        System.out.println("----------------------------------------");
        System.out.print("Pilih menu: ");
    }

    // Menangkap input teks dari pengguna
    public String bacaString() {
        return scanner.nextLine();
    }

    // Overloading: menampilkan prompt terlebih dahulu sebelum membaca teks
    public String bacaString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Menangkap input angka dari pengguna dengan penanganan exception agar
    // program tidak berhenti ketika pengguna salah memasukkan data
    public int bacaInt() {
        while (true) {
            String masukan = scanner.nextLine();
            try {
                return Integer.parseInt(masukan.trim());
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka. Coba lagi: ");
            }
        }
    }

    // Overloading: menampilkan prompt terlebih dahulu sebelum membaca angka
    public int bacaInt(String prompt) {
        System.out.print(prompt);
        return bacaInt();
    }
}
