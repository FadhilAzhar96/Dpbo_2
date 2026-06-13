package com.lgcns.util;

/**
 * Kelas utilitas yang khusus menangani pengecekan keamanan dan keabsahan input
 * pengguna.
 */
public class ValidasiInputSeleksi {

    // Memastikan input nilai berada pada rentang wajar 0 - 100
    public boolean validasiRentangNilaiTes(int nilai) {
        return nilai >= 0 && nilai <= 100;
    }

    // Mencegah nama diisi dengan kosong atau hanya spasi
    public boolean validasiNamaTidakKosong(String nama) {
        return nama != null && !nama.trim().isEmpty();
    }
}
