package com.pendaftaran.model;

public class Admin extends Person {

    private final String role;

    public Admin(String id, String nama, String role) {
        super(id, nama);
        this.role = role;
    }

    @Override
    public String getRole() {
        return role;
    }
}
