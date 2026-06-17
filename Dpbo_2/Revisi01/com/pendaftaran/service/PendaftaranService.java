package com.pendaftaran.service;

import com.pendaftaran.model.CalonMahasiswa;
import com.pendaftaran.repository.CalonRepository;

public class PendaftaranService {

    private final CalonRepository repository;
    private final PenilaiService penilaiService;
    private int nextId = 1;

    public PendaftaranService(CalonRepository repository, PenilaiService penilaiService) {
        this.repository = repository;
        this.penilaiService = penilaiService;
    }

    public boolean tambahCalon(String nama, String fakultas, int totalNilai) {
        if (repository.cariCalon(nama) != null) {
            return false;
        }
        CalonMahasiswa calon = new CalonMahasiswa(generateId(), nama, fakultas, totalNilai);
        calon.tentukanStatus(penilaiService);
        repository.simpan(calon);
        return true;
    }

    public CalonMahasiswa daftarCalon(String fakultas) {
        String nama = "Calon-" + nextId;
        int totalNilai = 0;
        CalonMahasiswa calon = new CalonMahasiswa(generateId(), nama, fakultas, totalNilai);
        calon.tentukanStatus(penilaiService);
        repository.simpan(calon);
        return calon;
    }

    public boolean ubahTotalNilai(String nama, int totalNilai) {
        CalonMahasiswa calon = repository.cariCalon(nama);
        if (calon == null) {
            return false;
        }
        calon.setTotalNilai(totalNilai);
        calon.tentukanStatus(penilaiService);
        return true;
    }

    public boolean hapusCalon(String nama) {
        return repository.hapusCalon(nama);
    }

    public CalonMahasiswa cariCalon(String nama) {
        return repository.cariCalon(nama);
    }

    public void tampilkanSemuaCalon() {
        repository.dapatkanSemuaCalon().forEach(calon -> System.out.println(calon.ringkasan()));
    }

    private String generateId() {
        return String.format("C%03d", nextId++);
    }
}
