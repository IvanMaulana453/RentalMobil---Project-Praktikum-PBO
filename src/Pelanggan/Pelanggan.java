package Pelanggan;

import Kendaraan.Mobil;
import Sewa.PenyediaMobil;

import java.util.ArrayList;

public class Pelanggan {
    public static ManajemenPelanggan manajemenPelanggan;

    //simpan mobil yang disewa
    private ArrayList<Mobil> mobilDisewa = new ArrayList<>();
    private String nama;
    private String username;
    private String password;

    public Pelanggan(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean cekPassword(String password) {
        return this.password.equals(password);
    }

    public void sewaMobil(Mobil mobil, int jumlahHari) {
        double totalBiaya = mobil.hargaPerHari * jumlahHari;
        System.out.println("Pelanggan " + nama + " telah menyewa mobil:");
        mobil.tampilkanDetail();
        System.out.println("Total Biaya: $" + totalBiaya);

        mobilDisewa.add(mobil);
    }


    public ArrayList<Mobil> getMobilDisewa() {
        return mobilDisewa;
    }
}