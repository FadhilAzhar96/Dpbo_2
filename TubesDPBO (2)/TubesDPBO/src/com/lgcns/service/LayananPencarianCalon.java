package com.lgcns.service;

import com.lgcns.model.CalonMahasiswa;
import com.lgcns.repository.ArsipPendaftaranCalon;

/**
 * Kelas khusus yang menangani algoritma pencarian calon mahasiswa. Tidak
 * menyimpan data sendiri, melainkan membaca langsung dari
 * {@link ArsipPendaftaranCalon}.
 */
public class LayananPencarianCalon {

    private ArsipPendaftaranCalon arsip;

    public LayananPencarianCalon(ArsipPendaftaranCalon arsip) {
        this.arsip = arsip;
    }

    // Algoritma pencarian berdasarkan exact match nama
    public CalonMahasiswa cariPersisNama(String nama) {
        for (CalonMahasiswa calon : arsip.dapatkanSemua()) {
            if (calon.getNama().equalsIgnoreCase(nama)) {
                return calon;
            }
        }
        return null;
    }
}
