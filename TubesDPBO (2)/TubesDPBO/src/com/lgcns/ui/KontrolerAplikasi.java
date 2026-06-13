package com.lgcns.ui;

import com.lgcns.model.CalonMahasiswa;
import com.lgcns.service.LayananAdministrasiPendaftaran;
import com.lgcns.util.ValidasiInputSeleksi;

/**
 * Bertindak sebagai pengatur lalu lintas logika (brain dari UI). Menerima input
 * dari pengguna melalui {@link MenuKonsol}, memvalidasinya dengan
 * {@link ValidasiInputSeleksi}, lalu memanggil
 * {@link LayananAdministrasiPendaftaran}.
 */
public class KontrolerAplikasi {

    private MenuKonsol ui;
    private LayananAdministrasiPendaftaran layanan;
    private ValidasiInputSeleksi validasi;

    public KontrolerAplikasi(LayananAdministrasiPendaftaran layanan) {
        this.ui = new MenuKonsol();
        this.layanan = layanan;
        this.validasi = new ValidasiInputSeleksi();
    }

    // Menjalankan perulangan menu utama agar aplikasi tidak langsung tertutup
    public void mulaiLoopMenu() {
        int pilihan;
        do {
            ui.tampilkanMenuUtama();
            pilihan = ui.bacaInt();
            prosesPilihanMenu(pilihan);
        } while (pilihan != 0);
    }

    // Mengeksekusi aksi berdasarkan pilihan menu dari pengguna
    public void prosesPilihanMenu(int idx) {
        switch (idx) {
            case 1 -> prosesInputCalon();
            case 2 -> layanan.tampilkanSemuaCalon();
            case 3 -> prosesCariCalon();
            case 4 -> prosesUbahNilai();
            case 5 -> prosesHapusCalon();
            case 6 -> layanan.tampilkanCalonNilaiTotalTertinggi();
            case 7 -> layanan.tampilkanRingkasanStatistik();
            case 0 -> System.out.println("Terima kasih telah menggunakan sistem ini.");
            default -> System.out.println("Pilihan menu tidak tersedia. Silakan coba lagi.");
        }
    }

    private void prosesInputCalon() {
        String nama = ui.bacaString("Masukkan nama          : ");
        if (!validasi.validasiNamaTidakKosong(nama)) {
            System.out.println("Gagal: nama tidak boleh kosong.");
            return;
        }
        String jurusan = ui.bacaString("Masukkan jurusan       : ");
        int nilai1 = mintaNilaiTes("Masukkan nilai tes 1   : ");
        int nilai2 = mintaNilaiTes("Masukkan nilai tes 2   : ");

        boolean berhasil = layanan.inputCalonBaru(nama, jurusan, nilai1, nilai2);
        if (berhasil) {
            System.out.println("Data calon berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan data calon.");
        }
    }

    private void prosesCariCalon() {
        String nama = ui.bacaString("Masukkan nama yang dicari: ");
        CalonMahasiswa calon = layanan.cariCalon(nama);
        if (calon == null) {
            System.out.println("Calon dengan nama '" + nama + "' tidak ditemukan.");
        } else {
            System.out.println("Data ditemukan: " + calon);
        }
    }

    private void prosesUbahNilai() {
        String nama = ui.bacaString("Masukkan nama calon    : ");
        if (layanan.cariCalon(nama) == null) {
            System.out.println("Calon dengan nama '" + nama + "' tidak ditemukan.");
            return;
        }
        int nilai1 = mintaNilaiTes("Nilai tes 1 baru       : ");
        int nilai2 = mintaNilaiTes("Nilai tes 2 baru       : ");
        if (layanan.ubahNilaiTes(nama, nilai1, nilai2)) {
            System.out.println("Nilai tes berhasil diperbarui dan dinilai ulang.");
        } else {
            System.out.println("Gagal memperbarui nilai tes.");
        }
    }

    private void prosesHapusCalon() {
        String nama = ui.bacaString("Masukkan nama calon yang dihapus: ");
        if (layanan.hapusCalon(nama)) {
            System.out.println("Data calon berhasil dihapus.");
        } else {
            System.out.println("Calon dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // Meminta nilai tes berulang sampai input berada pada rentang yang valid
    private int mintaNilaiTes(String prompt) {
        while (true) {
            int nilai = ui.bacaInt(prompt);
            if (validasi.validasiRentangNilaiTes(nilai)) {
                return nilai;
            }
            System.out.println("Nilai harus berada pada rentang 0 - 100.");
        }
    }
}
