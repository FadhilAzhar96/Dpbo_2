package com.pendaftaran.model;

public enum StatusKelulusan {
    LULUS("Lulus"),
    TIDAK_LULUS("Tidak Lulus"),
    BELUM_DINILAIKAN("Belum Dinilai");

    private final String label;

    StatusKelulusan(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
