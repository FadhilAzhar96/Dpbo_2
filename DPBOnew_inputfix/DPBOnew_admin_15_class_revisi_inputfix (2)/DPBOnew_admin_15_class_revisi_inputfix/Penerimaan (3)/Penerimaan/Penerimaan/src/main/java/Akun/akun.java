/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Akun;

/**
 *
 * @author ASUS
 */


import java.util.Scanner;

public class akun {
//membuat username dan password untuk admin
    private final String username = "admin";
    private final String password = "admin123";

    public boolean login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== LOGIN ADMIN =====");

        System.out.print("Username : ");
        String userInput = scanner.nextLine();

        System.out.print("Password : ");
        String passInput = scanner.nextLine();
    //jika username dan password sesuai, sistem akan menampilkan kalimat bahwa login berhasil
        if (userInput.equals(username) && passInput.equals(password)) {
            System.out.println("Login berhasil!");
            return true;
        }
    //jika username atau password berbeda makan sistem menampilkan kalimat bahwa password sala
        System.out.println("Username atau password salah!");
        return false;
    }
}
