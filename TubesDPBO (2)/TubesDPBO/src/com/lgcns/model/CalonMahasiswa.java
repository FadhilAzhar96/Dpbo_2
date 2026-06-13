package com.lgcns.model;

/**
 * Entity Class utama yang merepresentasikan blueprint data seorang calon
 * mahasiswa. Seluruh atribut bersifat private (data hiding) dan hanya dapat
 * diakses melalui getter dan setter sesuai konsep enkapsulasi.
 */
public class CalonMahasiswa {

    // Definisi atribut (semua private untuk mendukung enkapsulasi)
    private String nama;
    private String jurusan;
    private int nilaiTes1;
    private int nilaiTes2;
    private String statusKelulusan;

    // Konstruktor default (overloading konstruktor)
    public CalonMahasiswa() {
        this.nama = "";
        this.jurusan = "";
        this.nilaiTes1 = 0;
        this.nilaiTes2 = 0;
        this.statusKelulusan = "Belum Dinilai";
    }

    // Konstruktor berparameter (overloading konstruktor)
    public CalonMahasiswa(String nama, String jurusan, int nilaiTes1, int nilaiTes2) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.nilaiTes1 = nilaiTes1;
        this.nilaiTes2 = nilaiTes2;
        this.statusKelulusan = "Belum Dinilai";
    }

    // Menjumlahkan nilaiTes1 dan nilaiTes2
    public int hitungTotalNilai() {
        return nilaiTes1 + nilaiTes2;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public int getNilaiTes1() {
        return nilaiTes1;
    }

    public int getNilaiTes2() {
        return nilaiTes2;
    }

    public String getStatusKelulusan() {
        return statusKelulusan;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setNilaiTes1(int nilaiTes1) {
        this.nilaiTes1 = nilaiTes1;
    }

    public void setNilaiTes2(int nilaiTes2) {
        this.nilaiTes2 = nilaiTes2;
    }

    public void setStatusKelulusan(String statusKelulusan) {
        this.statusKelulusan = statusKelulusan;
    }

    // Override metode dari kelas Object untuk memberi representasi yang berguna
    @Override
    public String toString() {
        return "CalonMahasiswa[nama=" + nama + ", jurusan=" + jurusan
                + ", nilaiTes1=" + nilaiTes1 + ", nilaiTes2=" + nilaiTes2
                + ", total=" + hitungTotalNilai() + ", status=" + statusKelulusan + "]";
    }
}
