/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;
import Penilaian.*;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class Calonmhs extends User{//class Calonmhs mengextends class User
    private String fakultas;
    private String prodi;
    private String jalur;
    private int totalNilai;
    public penilaian penilai;
    public static int pendaftar = 0;
    
    Scanner scanner = new Scanner(System.in);
    
    public Calonmhs(String nama, String fakultas, String prodi, String jalur){
        pendaftar++;
        
        String ID = "Calon" + pendaftar;//membuat id otomatis berdasarkan daftar calon
        
        super(ID, nama);
        this.fakultas = fakultas;
        this.prodi = prodi;
        this.jalur = jalur;
        this.penilai = penilaian.BELUM;
    }



    @Override
    public String getId() {//mengambil ID calon
        return super.getId();
    }
    @Override
    public String getName(){//mengamabil nama calon
        return super.getName();
    }
    
    public String getRole(){//mengambil string role
        return "Calon mahasiswa";
    }
    public String getFakultas(){//mengambil string fakultas
        return fakultas;
    }
    public String getProdi(){//mengambil string prodi
        return prodi;
    }
    public int getTotal(){//mengambil total nilai calon
        return totalNilai;
    }
    public String LihatNilai(){//melihat nilai yang dimiliki calon
        return "Nilai kamu adalah: " + totalNilai;
    }
    public void setNilai(int totalNilai){//mengatur nilai calon
        this.totalNilai = totalNilai;
    }
    public penilaian penilai(){//method yang mengeluarkan nilai dari class penilaian
        return penilai;
    }
    public void setStatusKelulusan(penilaian pen) {//untuk menyimpan data kelulusan
        this.penilai = pen;
    }
    public String getStatus(){//method untuk mengambil status kelulusan
        return "===== PENGUMUMAN KELULUSAN =====\n"
                + "Nama : " + getName() + "\n"
                + penilai.getLabel();
    }
    public void tentukanStatus(penilaian penilaiService) {//method untuk menentukan status
        penilaiService.kelulusan(this);
    }
    public String DataDiri() {//mengeluarkan data diri calon
        return "\n=========================================\n" +
           "        Data Diri Kamu        \n" +
           "=========================================\n" +
           " ID Pendaftar  : " + getId() + "\n" +
           " Nama          : " + getName() + "\n" +
           " Fakultas      : " + fakultas + "\n" +
           " Jalur Seleksi : " + jalur + "\n" +
           " Total Nilai   : " + totalNilai + "\n" +
           " Status        : " + penilai.getLabel() + "\n" +
           "=========================================";
    }
    public String Daftar() {//setelah pendaftaran berhasil, sistem mengeluarkan method ini
        return "\n=========================================\n" +
           "        PENDAFTARAN BERHASIL        \n" +
           "=========================================\n" +
           " ID Pendaftar  : " + getId() + "\n" +
           " Nama          : " + getName() + "\n" +
           " Fakultas      : " + fakultas + "\n" +
           " Jalur Seleksi : " + jalur + "\n" +
           " Total Nilai   : " + totalNilai + "\n" +
           " Status        : " + penilai.getLabel() + "\n" +
           "=========================================";
    }
    
}
