package com.lgcns.model;

/**
 * Kelas dasar (induk) yang merepresentasikan entitas pengguna dalam sistem.
 * Bersifat abstract sehingga tidak dapat diinstansiasi secara langsung; objek
 * hanya dapat dibuat melalui kelas turunannya (lihat {@link AdminPetugas}).
 */
public abstract class Pengguna {

    // Atribut protected agar dapat diwariskan dan diakses oleh subclass
    protected String idPetugas;
    protected String namaLengkap;

    public Pengguna() {
        this.idPetugas = "";
        this.namaLengkap = "";
    }

    public Pengguna(String idPetugas, String namaLengkap) {
        this.idPetugas = idPetugas;
        this.namaLengkap = namaLengkap;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getIdPetugas() {
        return idPetugas;
    }

    // Metode abstrak yang wajib diimplementasikan oleh kelas turunannya
    public abstract String getPeranSistem();
}
