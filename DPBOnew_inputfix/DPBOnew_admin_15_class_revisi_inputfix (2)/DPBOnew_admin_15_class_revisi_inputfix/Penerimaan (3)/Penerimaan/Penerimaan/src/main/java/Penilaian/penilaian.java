/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Penilaian;
import user.*;
/**
 *
 * @author ASUS
 */
public enum penilaian {
    //membuat enum untuk mendefinisikan nilai tetap dengan aman
    LULUS("Lulus"),
    TIDAKLULUS("Tidak lulus"),
    BELUM("Belum diumumkan");
    //String label dibuat untuk menyimpan String dari enum
    private final String label;
    //constructor yang berisi strng label
    private penilaian(String label){
        this.label = label;
    }
    //method untuk mengambil String dari enum
    public String getLabel(){
        return label;
    }
    //method untuk menentukan nilai kelulusan seleksi
    public void kelulusan(Calonmhs nilai){
        int n = nilai.getTotal();
        if(n >= 120){
            nilai.setStatusKelulusan(penilaian.LULUS);
        }else if (n >= 60){
            nilai.setStatusKelulusan(penilaian.TIDAKLULUS);
        }else{
            nilai.setStatusKelulusan(penilaian.BELUM);
        }
    }
    
}
