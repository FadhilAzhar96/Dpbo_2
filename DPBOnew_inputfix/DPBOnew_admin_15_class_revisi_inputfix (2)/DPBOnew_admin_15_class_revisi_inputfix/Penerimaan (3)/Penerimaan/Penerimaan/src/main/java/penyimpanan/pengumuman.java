package penyimpanan;

import user.Calonmhs;

public class pengumuman {
    //Method untuk menampilkan pengumuman hasil seleksi
    public String tampilkan(Calonmhs calon) {
        //bila data calon null maka sistem akan menampilkan kalimat data calon tidak ditemukan
        if (calon == null) {
            return "Data calon tidak ditemukan.";
        }
        //bila data calon tidak null maka sistem mengeluarkan pengumuman kelulusan seleksi calon 
        return "===== PENGUMUMAN KELULUSAN =====\n"
                + "Nama : " + calon.getName() + "\n"
                + calon.getStatus();
    }
}
