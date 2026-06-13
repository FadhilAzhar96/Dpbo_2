package com.lgcns.service;

import com.lgcns.model.CalonMahasiswa;
import java.util.ArrayList;

/**
 * Bertugas khusus untuk format keluaran data ke layar, memisahkan urusan
 * mencetak (print) dari urusan data.
 */
public class LayananPelaporanDaftar {

    // Mencetak bagian atas tabel (judul kolom)
    public void cetakHeaderTabel() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-8s %-8s %-7s %-12s%n",
                "Nama", "Jurusan", "Tes1", "Tes2", "Total", "Status");
        System.out.println("---------------------------------------------------------------------------");
    }

    // Mencetak seluruh data list calon mahasiswa dalam format tabular yang rapi
    public void cetakDaftar(ArrayList<CalonMahasiswa> daftar) {
        cetakHeaderTabel();
        if (daftar.isEmpty()) {
            System.out.println("(Belum ada data calon mahasiswa)");
        } else {
            for (CalonMahasiswa calon : daftar) {
                System.out.printf("%-20s %-15s %-8d %-8d %-7d %-12s%n",
                        calon.getNama(), calon.getJurusan(), calon.getNilaiTes1(),
                        calon.getNilaiTes2(), calon.hitungTotalNilai(),
                        calon.getStatusKelulusan());
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
