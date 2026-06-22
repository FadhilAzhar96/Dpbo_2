package ui;

import Penilaian.*;
import user.*;
import java.util.Scanner;
import penyimpanan.listCalon;

public class uiCalon {

    private final Scanner scanner;
    private final Calonmhs calon;

    public uiCalon(Scanner scanner, Calonmhs calon) {
        this.scanner = scanner;
        this.calon = calon;
        // HAPUS bagian listCalon.tambahCalon(calon) dari sini
    }
    //method untuk menampilkan ui calon mahasiswa
    public void tampilkan() {
        //jika data calon yang dimasukkan salah, kita tidak bisa membuka akses ui atau menu calon
        if (calon == null) {
            System.out.println("\n[Akses Ditolak] Data tidak ditemukan!");
            return;
        }
        //jika data calon sesuai maka sistem akan membiarkan kita mengakses menu calon
        System.out.println("\nSelamat datang, " + calon.getName() + "!");

        int pilihan;
        //perulangan selama input yang kita masukkan tidak berangka nol
        do {
            System.out.println("\n===== MENU CALON MAHASISWA =====");
            System.out.println("1. Lihat data diri");
            System.out.println("2. Lihat nilai tes");
            System.out.println("3. Lihat pengumuman kelulusan");
            System.out.println("0. Log out");
            System.out.print("Pilih menu : ");
            
            pilihan = bacaInt();

            switch (pilihan) {
                //jika input angka 1, sistem akan mengeluarkan data diri calon yang ada di class Calonmhs
                case 1:
                    System.out.println(calon.DataDiri());
                    break;
                //jika input angka 2, sistem akan mengeluarkan nilai calon yang ada di class Calonmhs
                case 2:
                    System.out.println(calon.LihatNilai());
                    break;
                //jika input angka 3, sistem akan mengeluarkan status kelulusan calon yang ada di class Calonmhs
                case 3:
                    System.out.println(calon.getStatus());
                    break;
                //jika input angka 0, sistem akan mengeluarkan kita dari menu calon dan kembali ke menu utama
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                //jika kita memasukkan pilihan menu yang tidak sesuai maka sistem akan mengeluarkan kalimat dan 
                    //kita akan mengulang pemilihan menu calon
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            //Selama pilihan menu tidak nol, sistem akan terus mengulang menu calon
        } while (pilihan != 0);
    }
    // Method untuk membaca input angka secara aman dan menangani error (exception)
    private int bacaInt() {
        while (true) {// Terus mengulang sampai mendapatkan input angka yang valid
            String input = scanner.nextLine();

            try {
                // Jika input kosong atau hanya berisi spasi, paksa lempar exception ke blok catch
                if (input.trim().isEmpty()) {
                    throw new NumberFormatException();
                }
                // Jika berhasil diubah jadi angka bulat, kembalikan nilai dan hentikan perulangan
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                // Menangani input yang bukan angka atau kosong, lalu meminta input ulang
                System.out.println("Input harus berupa angka. Coba lagi.");
                System.out.print("Pilih menu : ");
            }
        }
    }
}