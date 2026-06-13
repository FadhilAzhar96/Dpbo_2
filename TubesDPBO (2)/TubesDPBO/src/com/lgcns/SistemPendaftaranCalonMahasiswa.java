package com.lgcns;

import com.lgcns.model.AdminPetugas;
import com.lgcns.model.Pengguna;
import com.lgcns.service.LayananAdministrasiPendaftaran;
import com.lgcns.ui.KontrolerAplikasi;

/**
 * Kelas Root atau titik masuk (entry point) aplikasi. Bertanggung jawab
 * merangkai komponen utama dan menjalankan sistem.
 */
public class SistemPendaftaranCalonMahasiswa {

    private LayananAdministrasiPendaftaran layananAdmin;
    private KontrolerAplikasi kontroler;
    private Pengguna penggunaAktif;

    public SistemPendaftaranCalonMahasiswa() {
        this.layananAdmin = new LayananAdministrasiPendaftaran();
        this.kontroler = new KontrolerAplikasi(layananAdmin);
        // Polymorphism: referensi bertipe Pengguna (abstract) menunjuk ke
        // objek konkret AdminPetugas. Pemanggilan getPeranSistem() di-resolve
        // saat runtime melalui dynamic binding.
        this.penggunaAktif = new AdminPetugas("ADM-001", "Petugas Pendaftaran", "rahasia123");
    }

    // Metode untuk memulai eksekusi sistem secara keseluruhan
    public void jalankan() {
        System.out.println("Login sebagai : " + penggunaAktif.getNamaLengkap()
                + " (" + penggunaAktif.getPeranSistem() + ")");
        kontroler.mulaiLoopMenu();
    }

    public static void main(String[] args) {
        SistemPendaftaranCalonMahasiswa sistem = new SistemPendaftaranCalonMahasiswa();
        sistem.jalankan();
    }
}
