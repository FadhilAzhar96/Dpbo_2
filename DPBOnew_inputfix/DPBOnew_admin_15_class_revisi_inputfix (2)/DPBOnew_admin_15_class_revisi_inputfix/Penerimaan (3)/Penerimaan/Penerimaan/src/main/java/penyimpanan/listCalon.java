/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penyimpanan;

/**
 *
 * @author ASUS
 */




import java.util.ArrayList;
import user.Calonmhs;

public class listCalon {
    //membuat ArrayList untuk menyimpan daftar calon mahasiswa
    private static ArrayList<Calonmhs> daftarCalon = new ArrayList<>();
    //method untuk menambah daftar calon 
    public static void tambahCalon(Calonmhs calon) {
        daftarCalon.add(calon);
    }
    //method untuk mengambil daftar calon mahsiswa
    public static ArrayList<Calonmhs> getDaftarCalon() {
        return daftarCalon;
    }
}