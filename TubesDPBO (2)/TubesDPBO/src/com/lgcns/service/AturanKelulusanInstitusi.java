package com.lgcns.service;

/**
 * Menyimpan business rules murni terkait standar nilai kelulusan dari pihak
 * kampus. Merupakan implementasi konkret dari interface {@link AturanKelulusan}.
 */
public class AturanKelulusanInstitusi implements AturanKelulusan {

    // Konstanta batas nilai total minimal agar calon dinyatakan lulus
    public static final int BATAS_NILAI_LULUS = 120;

    // Mengembalikan status berdasarkan angka total yang dimasukkan
    @Override
    public String tentukanStatus(int total) {
        if (total >= BATAS_NILAI_LULUS) {
            return "Lulus";
        }
        return "Tidak Lulus";
    }
}
