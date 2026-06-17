package com.pendaftaran.model;

import com.pendaftaran.service.PenilaiService;

public class CalonMahasiswa extends Person {

    private final String fakultas;
    private int totalNilai;
    private StatusKelulusan statusKelulusan;

    public CalonMahasiswa(String id, String nama, String fakultas, int totalNilai) {
        super(id, nama);
        this.fakultas = fakultas;
        this.totalNilai = totalNilai;
        this.statusKelulusan = StatusKelulusan.BELUM_DINILAIKAN;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public String getRole() {
        return "Calon Mahasiswa";
    }

    public String getFakultas() {
        return fakultas;
    }

    public int getTotalNilai() {
        return totalNilai;
    }

    public void setTotalNilai(int totalNilai) {
        this.totalNilai = totalNilai;
    }

    public StatusKelulusan getStatusKelulusan() {
        return statusKelulusan;
    }

    public void setStatusKelulusan(StatusKelulusan statusKelulusan) {
        this.statusKelulusan = statusKelulusan;
    }

    public void tentukanStatus(PenilaiService penilaiService) {
        penilaiService.evaluasi(this);
    }

    public String ringkasan() {
        return "[" + getId() + "] " + getNama() + " - Fakultas: " + fakultas
                + " - Total Nilai: " + totalNilai + " - Status: " + statusKelulusan.getLabel();
    }
}
