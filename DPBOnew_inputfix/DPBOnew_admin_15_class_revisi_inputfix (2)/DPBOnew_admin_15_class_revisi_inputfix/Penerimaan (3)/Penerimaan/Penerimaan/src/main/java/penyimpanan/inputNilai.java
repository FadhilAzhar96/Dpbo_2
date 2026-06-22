package penyimpanan;

import user.Calonmhs;

public class inputNilai {
    public boolean masukkanNilai(Calonmhs calon, int nilai) {
        //apabila nama calon ada dalam daftar maka nilai calon yang diubah tersimpan
        if (calon != null && Validasi.nilaiValid(nilai)) {
            calon.setNilai(nilai);
            return true;
        }
        return false;
    }
    //menampilkan nilai calon mahasiswa yang telah dimasukkan
    public String tampilNilai(Calonmhs calon) {
        return calon.LihatNilai();
    }
}
