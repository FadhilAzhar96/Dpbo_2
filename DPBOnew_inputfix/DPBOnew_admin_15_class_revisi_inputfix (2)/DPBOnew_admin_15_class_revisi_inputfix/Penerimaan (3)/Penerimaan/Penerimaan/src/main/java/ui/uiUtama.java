/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;




import Penilaian.*;
import user.Calonmhs;
import Akun.akun;
import java.util.Scanner;
import penyimpanan.listCalon;

public class uiUtama {

    private final Scanner scanner;
    private final uiAdmin adminMenu;
    private final uiCalon calonMenu;
    private final akun akunAdmin;
    private Calonmhs calon;

    public uiUtama() {
        scanner = new Scanner(System.in);
        adminMenu = new uiAdmin(scanner);
        calonMenu = new uiCalon(scanner, calon);
        akunAdmin = new akun();
        
    }

    public void tampilkan() {

        int pilihan;
//melakukan perulangan selama pilihan tidak nol
        do {

            System.out.println("\n==================================");
            System.out.println(" SISTEM PENERIMAAN MAHASISWA BARU ");
            System.out.println("==================================");
            System.out.println("1. Login Admin");
            System.out.println("2. Daftar calon mahasiswa");
            System.out.println("3. Login calon mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");

            pilihan = bacaInt();

            switch (pilihan) {

                case 1:
                    if (akunAdmin.login()) {
                        adminMenu.tampilkan();
                    }
                    break;

               case 2:
                System.out.println("\n--- Daftar Calon Mahasiswa ---");
                System.out.print("Masukkan Nama: ");
                String namaMhs = scanner.nextLine();
    
                System.out.print("Masukkan Fakultas: ");
                String fakultasMhs = scanner.nextLine();
    
                System.out.print("Masukkan Prodi: ");
                String prodiMhs = scanner.nextLine();
    
                System.out.print("Masukkan Jalur Seleksi: ");
                String jalurMhs = scanner.nextLine();

    // 1. Buat objek calon mahasiswa baru
                Calonmhs mahasiswaBaru = new Calonmhs(namaMhs, fakultasMhs, prodiMhs, jalurMhs);
    
    // 2. SIMPAN calon tersebut ke dalam listCalon menggunakan class Pendaftaran
                Pendaftaran daftarService = new Pendaftaran();
                daftarService.daftar(mahasiswaBaru);
    
                System.out.println("\n" + mahasiswaBaru.Daftar());
                break;
    
            case 3:
    System.out.println("\n--- Login Calon Mahasiswa ---");
    System.out.print("Masukkan Nama : "); 
    String loginNama = scanner.nextLine();
    
    System.out.print("Masukkan ID   : "); 
    String loginId = scanner.nextLine();
    
    Calonmhs calonLogin = null;
    
    // Mencari data pendaftar berdasarkan NAMA dan ID
    for(Calonmhs c : penyimpanan.listCalon.getDaftarCalon()) {
        if(c.getName().equalsIgnoreCase(loginNama) && c.getId().equalsIgnoreCase(loginId)) {
            calonLogin = c; // Jika Nama DAN ID cocok, simpan data
            break;
        }
    }
    
    // Jika datanya ketemu, izinkan masuk ke menu uiCalon
    if(calonLogin != null) {
        uiCalon menuMahasiswa = new uiCalon(scanner, calonLogin);
        menuMahasiswa.tampilkan();
    } else {
        System.out.println("Login Gagal! Nama atau ID yang dimasukkan salah/tidak terdaftar.");
    }
    break;
            }

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
                System.out.print("Masukkan pilihan: ");
            }
        }
    }
}