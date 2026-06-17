package com.pendaftaran.auth;

import com.pendaftaran.model.Admin;
import com.pendaftaran.model.CalonMahasiswa;
import com.pendaftaran.service.PendaftaranService;
import com.pendaftaran.util.InputReader;
import java.util.Scanner;

public class AuthService {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private final PendaftaranService pendaftaranService;

    public AuthService(PendaftaranService pendaftaranService) {
        this.pendaftaranService = pendaftaranService;
    }

    public Admin loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n== Login Admin ==");
        String username = InputReader.bacaString("Username: ", scanner);
        String password = InputReader.bacaString("Password: ", scanner);

        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return new Admin("ADM-001", "Admin Pendaftaran", "ADMIN");
        }
        System.out.println("Login admin gagal. Username atau password salah.");
        return null;
    }

    public CalonMahasiswa loginCalon(String nama) {
        return pendaftaranService.cariCalon(nama);
    }
}
