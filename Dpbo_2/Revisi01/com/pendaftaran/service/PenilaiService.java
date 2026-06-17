package com.pendaftaran.service;

import com.pendaftaran.model.CalonMahasiswa;
import com.pendaftaran.model.StatusKelulusan;

public class PenilaiService {

    public void evaluasi(CalonMahasiswa calon) {
        int total = calon.getTotalNilai();
        if (total >= 120) {
            calon.setStatusKelulusan(StatusKelulusan.LULUS);
        } else if (total >= 60) {
            calon.setStatusKelulusan(StatusKelulusan.TIDAK_LULUS);
        } else {
            calon.setStatusKelulusan(StatusKelulusan.BELUM_DINILAIKAN);
        }
    }
}
