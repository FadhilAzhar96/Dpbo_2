package com.lgcns.service;

import com.lgcns.model.CalonMahasiswa;
import java.util.ArrayList;

/**
 * Menangani perhitungan analitik agregat seperti jumlah pendaftar dan jumlah
 * calon berdasarkan status kelulusannya.
 */
public class RingkasanStatistikPendaftaran {

    // Mengembalikan total seluruh pendaftar
    public int hitungJumlahTotal(ArrayList<CalonMahasiswa> daftar) {
        return daftar.size();
    }

    // Mengembalikan jumlah calon berdasarkan parameter status
    public int hitungPerStatus(ArrayList<CalonMahasiswa> daftar, String status) {
        int jumlah = 0;
        for (CalonMahasiswa calon : daftar) {
            if (calon.getStatusKelulusan().equalsIgnoreCase(status)) {
                jumlah++;
            }
        }
        return jumlah;
    }
}
