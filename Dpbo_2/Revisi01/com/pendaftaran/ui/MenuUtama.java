package com.pendaftaran.ui;

import com.pendaftaran.auth.AuthService;
import com.pendaftaran.model.Admin;
import com.pendaftaran.service.PendaftaranService;
import com.pendaftaran.util.InputReader;
import java.util.Scanner;

public class MenuUtama {

    private final AuthService authService;
    private final PendaftaranService pendaftaranService;
    private final Scanner scanner;
    private final AdminMenu adminMenu;
    private final CalonMenu calonMenu;

    public MenuUtama(AuthService authService, PendaftaranService pendaftaranService, Scanner scanner) {
        this.authService = authService;
        this.pendaftaranService = pendaftaranService;
        this.scanner = scanner;
        this.adminMenu = new AdminMenu(pendaftaranService, scanner);
        this.calonMenu = new CalonMenu(pendaftaranService, authService, scanner);
    }

    public void tampilkan() {
        while (true) {
            System.out.println();
            System.out.println("========================================");
            System.out.println("   SISTEM PENDAFTARAN CALON MAHASISWA");
            System.out.println("========================================");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Menu Calon Mahasiswa");
            System.out.println("0. Keluar");

            int pilihan = InputReader.bacaInt("Pilih menu utama: ", scanner, 0, 2);
            switch (pilihan) {
                case 1 -> {
                    Admin admin = authService.loginAdmin();
                    if (admin != null) {
                        adminMenu.tampilkan(admin);
                    }
                }
                case 2 -> calonMenu.tampilkan();
                case 0 -> {
                    System.out.println("Terima kasih telah menggunakan aplikasi pendaftaran.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
