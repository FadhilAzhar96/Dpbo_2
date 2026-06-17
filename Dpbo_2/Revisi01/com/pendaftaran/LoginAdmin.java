package com.pendaftaran;

import com.pendaftaran.auth.AuthService;
import com.pendaftaran.repository.CalonRepository;
import com.pendaftaran.service.PendaftaranService;
import com.pendaftaran.service.PenilaiService;
import com.pendaftaran.ui.MenuUtama;
import java.util.Scanner;

public class LoginAdmin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalonRepository repository = new CalonRepository();
        PenilaiService penilaiService = new PenilaiService();
        PendaftaranService pendaftaranService = new PendaftaranService(repository, penilaiService);
        AuthService authService = new AuthService(pendaftaranService);
        MenuUtama menuUtama = new MenuUtama(authService, pendaftaranService, scanner);

        menuUtama.tampilkan();
        scanner.close();
    }
}
