package Sewa;

import Kendaraan.Mobil;
import Pelanggan.ManajemenPelanggan;
import Pelanggan.Pelanggan;

import java.util.ArrayList;

public class PenyediaMobil {
    public static ArrayList<Mobil> mobilDisewakan = new ArrayList<>();
    public ArrayList<Pelanggan> pelangganSewa = new ArrayList<>();

    public ArrayList<Mobil> getMobilDisewakan() {
        return mobilDisewakan;
    }

    public void tambahkanMobil(String jenis, double hargaPerHari, String warna) {
        Mobil mobilBaru = new Mobil(jenis, hargaPerHari, warna);
        mobilDisewakan.add(mobilBaru);
        System.out.println("Mobil berhasil ditambahkan.");
    }

    public void hapusMobil(int index) {
        if (index >= 0 && index < mobilDisewakan.size()) {
            mobilDisewakan.remove(index);
            System.out.println("Mobil berhasil dihapus.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    public void tampilkanPenyewa() {
        ManajemenPelanggan manajemenPelanggan = new ManajemenPelanggan();
        System.out.println("\nDaftar Pelanggan yang Telah Menyewa:");
        for (Pelanggan pelanggan : pelangganSewa) {
            System.out.println("Nama Pelanggan: " + pelanggan.getUsername());

            // Jika pelanggan memiliki riwayat penyewaan, tampilkan detail mobil yang disewa
            if (!pelanggan.getMobilDisewa().isEmpty()) {
                System.out.println("Detail Mobil yang Disewa:");
                ArrayList<Mobil> mobilPelangganSewa = pelanggan.getMobilDisewa();
                for (Mobil mobil : mobilPelangganSewa) {
                    mobil.tampilkanDetail();
                    System.out.println();
                }
            } else {
                System.out.println("Pelanggan tidak memiliki riwayat penyewaan.");
            }

            System.out.println();
        }
    }
}
