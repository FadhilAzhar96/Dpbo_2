package com.lgcns.service;

import com.lgcns.model.CalonMahasiswa;

/**
 * Bertanggung jawab atas logika bisnis kelulusan. Kelas ini menentukan apakah
 * seorang calon pantas diterima berdasarkan {@link AturanKelulusanInstitusi}.
 */
public class PenilaiSeleksiCalon {

    // Referensi bertipe interface (interface polymorphism): implementasi
    // konkretnya dapat ditukar tanpa mengubah kode kelas ini.
    private AturanKelulusan aturan;

    public PenilaiSeleksiCalon() {
        this.aturan = new AturanKelulusanInstitusi();
    }

    // Mengevaluasi nilai calon dan menyimpan statusnya ke dalam objek calon
    public void terapkanStatus(CalonMahasiswa calon) {
        String status = aturan.tentukanStatus(calon.hitungTotalNilai());
        calon.setStatusKelulusan(status);
    }

    // Menjalankan ulang penilaian jika ada perubahan nilai
    public void evaluasiUlang(CalonMahasiswa calon) {
        terapkanStatus(calon);
    }
}
