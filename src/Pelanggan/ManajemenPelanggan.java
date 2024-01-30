package Pelanggan;

import java.util.ArrayList;

public class ManajemenPelanggan {
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private Pelanggan pelangganAktif;

    public void tambahPelanggan(String nama, String username, String password) {
        Pelanggan pelangganBaru = new Pelanggan(nama, username, password);
        daftarPelanggan.add(pelangganBaru);
        System.out.println("Akun pelanggan berhasil dibuat.");
    }

    public Pelanggan loginPelanggan(String username, String password) {
        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getUsername().equals(username) && pelanggan.cekPassword(password)) {
                pelangganAktif = pelanggan;
                System.out.println("Login berhasil sebagai pelanggan: " + pelanggan.getUsername());
                return pelanggan;
            }
        }
        System.out.println("Username atau password salah. Login gagal.");
        return null;
    }
    public Pelanggan getPelangganAktif() {
        return pelangganAktif;
    }

}
