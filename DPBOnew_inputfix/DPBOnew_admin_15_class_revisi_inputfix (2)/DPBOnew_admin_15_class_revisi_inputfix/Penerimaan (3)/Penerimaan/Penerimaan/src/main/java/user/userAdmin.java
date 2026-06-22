/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author ASUS
 */
//menyimpan id,
public class userAdmin extends User{
    private String role;
    //menyimpan data dan menentukan role admin
    public userAdmin(String id, String nama, String role){
        super(id, nama);
        this.role = role;
    }
    public String getRole(){//mengambil role admin
        return role;
    }
}
