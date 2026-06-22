/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author ASUS
 */




import java.util.Scanner;
import penyimpanan.listCalon;
import user.Calonmhs;

public class uiAdmin {

    private Scanner scanner;
//membuat constructor dengan parameter scanner
    public uiAdmin(Scanner scanner) {
        this.scanner = scanner;
    }
    //sistem menampilkan menu admin
    public void tampilkan() {

        int pilihan;

        do {

            System.out.println("\n== Menu Admin ==");
            System.out.println("1. Tampilkan semua calon");
            System.out.println("2. Cari calon");
            System.out.println("3. Ubah total nilai calon");
            System.out.println("4. Hapus calon");
            System.out.println("0. Logout");
            System.out.print("Pilih menu admin: ");

            pilihan = bacaInt();

            switch (pilihan) {

                case 1:

                    if (listCalon.getDaftarCalon().isEmpty()) {
                        System.out.println("\nBelum ada calon yang mendaftar.");
                    } else {

                        System.out.println("\n===== DAFTAR CALON MAHASISWA =====");

                        for (Calonmhs calon : listCalon.getDaftarCalon()) {

                            System.out.println("--------------------------------");
                            System.out.println("ID           : " + calon.getId());
                            System.out.println("Nama         : " + calon.getName());
                            System.out.println("Fakultas     : " + calon.getFakultas());
                            System.out.println("Prodi        : " + calon.getProdi());
                            System.out.println("Total Nilai  : " + calon.getTotal());
                            System.out.println("Status       : " + calon.penilai().getLabel());
                        }

                    }

                    break;

                case 2:
                    cariCalon();
                    break;

                case 3:
                    ubahTotalNilaiCalon();
                    break;

                case 4:
                    hapusCalon();
                    break;

                case 0:
                    System.out.println("Logout berhasil.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);

    }

    private void cariCalon() {
        System.out.println("\n== Cari Calon Mahasiswa ==");
        System.out.print("Masukkan nama calon: ");
        String nama = scanner.nextLine();

        if (!isNotBlank(nama)) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }

        for (Calonmhs calon : listCalon.getDaftarCalon()) {
            if (calon.getName().equalsIgnoreCase(nama)) {
                System.out.println("--------------------------------");
                System.out.println("ID           : " + calon.getId());
                System.out.println("Nama         : " + calon.getName());
                System.out.println("Fakultas     : " + calon.getFakultas());
                System.out.println("Prodi        : " + calon.getProdi());
                System.out.println("Total Nilai  : " + calon.getTotal());
                System.out.println("Status       : " + calon.penilai().getLabel());
                return;
            }
        }

        System.out.println("Calon mahasiswa tidak ditemukan.");
    }

    private void ubahTotalNilaiCalon() {
        System.out.println("\n== Ubah Total Nilai Calon ==");
        System.out.print("Masukkan nama calon: ");
        String nama = scanner.nextLine();

        if (!isNotBlank(nama)) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }

        System.out.print("Total nilai baru: ");
        String nilaiInput = scanner.nextLine();

        if (!isNumber(nilaiInput)) {
            System.out.println("Total nilai harus berupa angka.");
            return;
        }

        int nilai = Integer.parseInt(nilaiInput);
        if (!isRangeNilai(nilai)) {
            System.out.println("Total nilai harus berada pada rentang 0 - 300.");
            return;
        }

        for (Calonmhs calon : listCalon.getDaftarCalon()) {
            if (calon.getName().equalsIgnoreCase(nama)) {
                calon.setNilai(nilai);
                calon.tentukanStatus(Penilaian.penilaian.BELUM);
                System.out.println("Total nilai berhasil diperbarui.");
                return;
            }
        }

        System.out.println("Calon mahasiswa tidak ditemukan.");
    }

    private void hapusCalon() {
        System.out.println("\n== Hapus Calon Mahasiswa ==");
        System.out.print("Masukkan nama calon yang akan dihapus: ");
        String nama = scanner.nextLine();

        if (!isNotBlank(nama)) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }

        for (Calonmhs calon : listCalon.getDaftarCalon()) {
            if (calon.getName().equalsIgnoreCase(nama)) {
                listCalon.getDaftarCalon().remove(calon);
                System.out.println("Calon mahasiswa berhasil dihapus.");
                return;
            }
        }

        System.out.println("Calon mahasiswa tidak ditemukan.");
    }


    private boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }

    private boolean isNumber(String value) {
        if (!isNotBlank(value)) return false;
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isRangeNilai(int nilai) {
        return nilai >= 0 && nilai <= 300;
    }



    private int bacaInt() {
        while (true) {
            String input = scanner.nextLine();

            try {
                if (input.trim().isEmpty()) {
                    throw new NumberFormatException();
                }
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
                System.out.print("Masukkan pilihan: ");
            }
        }
    }
}
