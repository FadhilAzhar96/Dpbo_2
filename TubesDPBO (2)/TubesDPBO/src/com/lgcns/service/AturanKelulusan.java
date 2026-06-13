package com.lgcns.service;

/**
 * Interface yang mendefinisikan kontrak aturan kelulusan. Dengan interface ini,
 * standar penilaian dapat diganti dengan implementasi lain tanpa mengubah kelas
 * yang menggunakannya (interface polymorphism / satu interface banyak aksi).
 */
public interface AturanKelulusan {

    // Mengembalikan status kelulusan berdasarkan nilai total
    String tentukanStatus(int total);
}
