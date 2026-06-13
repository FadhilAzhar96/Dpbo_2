package com.lgcns.service;

import com.lgcns.model.CalonMahasiswa;
import java.util.ArrayList;

/**
 * Kelas utilitas untuk mencari nilai tertinggi (top score) dari kumpulan data
 * calon mahasiswa.
 */
public class LayananAnalisisNilaiTertinggi {

    // Melakukan perulangan untuk mencari nilai total maksimal dan
    // mengembalikan objek mahasiswa dengan nilai terbaik
    public CalonMahasiswa ambilCalonTertinggi(ArrayList<CalonMahasiswa> daftar) {
        if (daftar == null || daftar.isEmpty()) {
            return null;
        }
        CalonMahasiswa tertinggi = daftar.get(0);
        for (CalonMahasiswa calon : daftar) {
            if (calon.hitungTotalNilai() > tertinggi.hitungTotalNilai()) {
                tertinggi = calon;
            }
        }
        return tertinggi;
    }
}
