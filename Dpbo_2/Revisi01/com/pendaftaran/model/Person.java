package com.pendaftaran.model;

public abstract class Person implements Identifiable {

    private final String id;
    private final String nama;

    public Person(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public abstract String getRole();
}
