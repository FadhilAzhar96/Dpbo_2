/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author ASUS
 */
public abstract class User implements Identifikasi{
    final String id;
    private final String nama;
    //menyimpan id dan nama calon
    public User(String id, String nama){
        this.id = id;
        this.nama = nama;
    }
    @Override
    public String getId(){//mengambil id calon
        return id;
    }
    public String getName(){//mengambil nama calon
        return nama;
    }
    public abstract String getRole();//untuk mengambil role
}
