package com.lgcns.repository;

import com.lgcns.model.CalonMahasiswa;
import java.util.ArrayList;

/**
 * Tempat penyimpanan data (database in-memory) yang menyimpan daftar seluruh
 * calon mahasiswa menggunakan Collection berupa {@link ArrayList}. Kelas ini
 * melakukan komposisi terhadap {@link CalonMahasiswa}: jika arsip dihancurkan,
 * seluruh data calon di dalamnya ikut hilang.
 */
public class ArsipPendaftaranCalon {

    private ArrayList<CalonMahasiswa> daftarCalon;

    public ArsipPendaftaranCalon() {
        this.daftarCalon = new ArrayList<>();
    }

    // Menambah data calon ke dalam list
    public boolean tambahCalon(CalonMahasiswa calon) {
        if (calon == null) {
            return false;
        }
        return daftarCalon.add(calon);
    }

    // Menghapus data calon dari list berdasarkan nama
    public boolean hapusBerdasarkanNama(String nama) {
        CalonMahasiswa target = cariBerdasarkanNama(nama);
        if (target == null) {
            return false;
        }
        return daftarCalon.remove(target);
    }

    // Mengambil satu data calon dari list berdasarkan nama
    public CalonMahasiswa cariBerdasarkanNama(String nama) {
        for (CalonMahasiswa calon : daftarCalon) {
            if (calon.getNama().equalsIgnoreCase(nama)) {
                return calon;
            }
        }
        return null;
    }

    // Mengambil seluruh data calon dari list
    public ArrayList<CalonMahasiswa> dapatkanSemua() {
        return daftarCalon;
    }

    // Memperbarui nilai tes calon yang sudah ada berdasarkan nama
    public boolean perbaruiNilaiTesBerdasarkanNama(String nama, int nilaiTes1, int nilaiTes2) {
        CalonMahasiswa target = cariBerdasarkanNama(nama);
        if (target == null) {
            return false;
        }
        target.setNilaiTes1(nilaiTes1);
        target.setNilaiTes2(nilaiTes2);
        return true;
    }
}
