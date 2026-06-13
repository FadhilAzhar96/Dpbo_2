package com.lgcns.model;

/**
 * Representasi pengguna spesifik yang berperan sebagai petugas admin
 * pendaftaran. Mewarisi (inheritance) seluruh atribut dan metode dari
 * {@link Pengguna} serta mengimplementasikan metode abstrak getPeranSistem().
 */
public class AdminPetugas extends Pengguna {

    private String kodeAkses;

    // Konstruktor default (overloading konstruktor)
    public AdminPetugas() {
        super();
        this.kodeAkses = "";
    }

    // Konstruktor berparameter, memanggil konstruktor superclass dengan super()
    public AdminPetugas(String idPetugas, String namaLengkap, String kodeAkses) {
        super(idPetugas, namaLengkap);
        this.kodeAkses = kodeAkses;
    }

    public String getKodeAkses() {
        return kodeAkses;
    }

    public void setKodeAkses(String kodeAkses) {
        this.kodeAkses = kodeAkses;
    }

    // Implementasi (overriding) metode abstrak dari kelas induk Pengguna
    @Override
    public String getPeranSistem() {
        return "Admin";
    }
}
