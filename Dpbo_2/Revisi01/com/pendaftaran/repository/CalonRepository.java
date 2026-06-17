package com.pendaftaran.repository;

import com.pendaftaran.model.CalonMahasiswa;
import java.util.ArrayList;
import java.util.List;

public class CalonRepository {

    private final List<CalonMahasiswa> daftarCalon;

    public CalonRepository() {
        this.daftarCalon = new ArrayList<>();
    }

    public void simpan(CalonMahasiswa calon) {
        daftarCalon.add(calon);
    }

    public CalonMahasiswa cariCalon(String nama) {
        return daftarCalon.stream()
                .filter(calon -> calon.getNama().equalsIgnoreCase(nama))
                .findFirst()
                .orElse(null);
    }

    public boolean hapusCalon(String nama) {
        CalonMahasiswa calon = cariCalon(nama);
        if (calon == null) {
            return false;
        }
        return daftarCalon.remove(calon);
    }

    public List<CalonMahasiswa> dapatkanSemuaCalon() {
        return new ArrayList<>(daftarCalon);
    }
}
