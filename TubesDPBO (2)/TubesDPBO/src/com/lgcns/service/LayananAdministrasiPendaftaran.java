package com.lgcns.service;

import com.lgcns.model.CalonMahasiswa;
import com.lgcns.repository.ArsipPendaftaranCalon;
import java.util.ArrayList;

/**
 * Kelas Facade (jembatan utama logika bisnis). Menyatukan berbagai operasi
 * pendaftaran dalam satu tempat agar mudah dipanggil oleh
 * {@code KontrolerAplikasi}. Menggunakan {@link ArsipPendaftaranCalon} untuk
 * menyimpan data dan {@link PenilaiSeleksiCalon} untuk menilai kelulusan.
 */
public class LayananAdministrasiPendaftaran {

    private ArsipPendaftaranCalon arsip;
    private PenilaiSeleksiCalon penilai;
    private LayananPencarianCalon pencarian;
    private LayananPelaporanDaftar pelaporan;
    private LayananAnalisisNilaiTertinggi analisis;
    private RingkasanStatistikPendaftaran statistik;

    public LayananAdministrasiPendaftaran() {
        this.arsip = new ArsipPendaftaranCalon();
        this.penilai = new PenilaiSeleksiCalon();
        this.pencarian = new LayananPencarianCalon(arsip);
        this.pelaporan = new LayananPelaporanDaftar();
        this.analisis = new LayananAnalisisNilaiTertinggi();
        this.statistik = new RingkasanStatistikPendaftaran();
    }

    // Operasi dasar pendaftaran (CRUD): menambah calon baru dan langsung menilai
    public boolean inputCalonBaru(String nama, String jurusan, int nilaiTes1, int nilaiTes2) {
        CalonMahasiswa calon = new CalonMahasiswa(nama, jurusan, nilaiTes1, nilaiTes2);
        penilai.terapkanStatus(calon);
        return arsip.tambahCalon(calon);
    }

    // Menghapus calon berdasarkan nama
    public boolean hapusCalon(String nama) {
        return arsip.hapusBerdasarkanNama(nama);
    }

    // Mengubah nilai tes calon lalu mengevaluasi ulang status kelulusannya
    public boolean ubahNilaiTes(String nama, int nilaiTes1, int nilaiTes2) {
        boolean berhasil = arsip.perbaruiNilaiTesBerdasarkanNama(nama, nilaiTes1, nilaiTes2);
        if (berhasil) {
            penilai.evaluasiUlang(arsip.cariBerdasarkanNama(nama));
        }
        return berhasil;
    }

    // Menampilkan seluruh calon dalam bentuk tabel
    public void tampilkanSemuaCalon() {
        pelaporan.cetakDaftar(arsip.dapatkanSemua());
    }

    // Mencari calon berdasarkan nama
    public CalonMahasiswa cariCalon(String nama) {
        return pencarian.cariPersisNama(nama);
    }

    // Menampilkan calon dengan nilai total tertinggi
    public void tampilkanCalonNilaiTotalTertinggi() {
        CalonMahasiswa tertinggi = analisis.ambilCalonTertinggi(arsip.dapatkanSemua());
        if (tertinggi == null) {
            System.out.println("Belum ada data calon mahasiswa untuk dianalisis.");
        } else {
            System.out.println("Calon dengan nilai total tertinggi:");
            System.out.println("  Nama   : " + tertinggi.getNama());
            System.out.println("  Total  : " + tertinggi.hitungTotalNilai());
            System.out.println("  Status : " + tertinggi.getStatusKelulusan());
        }
    }

    // Menampilkan ringkasan statistik pendaftaran
    public void tampilkanRingkasanStatistik() {
        ArrayList<CalonMahasiswa> daftar = arsip.dapatkanSemua();
        System.out.println("Total pendaftar     : " + statistik.hitungJumlahTotal(daftar));
        System.out.println("Jumlah Lulus        : " + statistik.hitungPerStatus(daftar, "Lulus"));
        System.out.println("Jumlah Tidak Lulus  : " + statistik.hitungPerStatus(daftar, "Tidak Lulus"));
    }
}
