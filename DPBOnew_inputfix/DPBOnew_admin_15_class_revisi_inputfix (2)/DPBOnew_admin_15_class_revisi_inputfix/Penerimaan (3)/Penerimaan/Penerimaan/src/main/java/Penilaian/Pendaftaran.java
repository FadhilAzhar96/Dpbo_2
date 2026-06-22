package Penilaian;

import user.Calonmhs;
import penyimpanan.listCalon;

public class Pendaftaran {
    //method untuk menambah daftar listcalon
    public void daftar(Calonmhs calon) {
        if (calon != null) {
            listCalon.tambahCalon(calon);
        }
    }
    //method untuk menampilkan daftar calon mahasiswa
    public String tampilPendaftaran(Calonmhs calon) {
        return calon.Daftar();
    }
}
