package Sewa;

import Kendaraan.Mobil;
import Pelanggan.ManajemenPelanggan;
import Pelanggan.Pelanggan;

import java.util.Scanner;

public class ManajemenPenyewaan {
    public static void sewaMobil(Scanner scanner, PenyediaMobil penyediaMobil, ManajemenPelanggan manajemenPelanggan) {
        System.out.println("Masukkan jenis mobil yang ingin disewa: ");
        String jenisMobil = scanner.next();

        // Cari mobil berdasarkan jenis
        Mobil mobilSewa = null;
        for (Mobil mobil : penyediaMobil.getMobilDisewakan()) {
            if (mobil.getJenis().equalsIgnoreCase(jenisMobil)) {
                mobilSewa = mobil;
                break;
            }
        }

        if (mobilSewa != null) {
            System.out.println("Harga sewa per hari: $" + mobilSewa.getHargaPerHari());
            System.out.print("Masukkan jumlah hari sewa: ");
            int jumlahHari = scanner.nextInt();

            // Hitung total biaya berdasarkan jumlah hari
            double totalBiaya = mobilSewa.getHargaPerHari() * jumlahHari;

            // Tampilkan detail mobil dan total biaya
            System.out.println("\nDetail Mobil yang Disewa:");
            mobilSewa.tampilkanDetail();
            System.out.println("Total Biaya: $" + totalBiaya);

            // Tambah hari
            System.out.print("Tambah berapa hari? (0 jika tidak tambah): ");
            int tambahHari = scanner.nextInt();
            if (tambahHari > 0) {
                jumlahHari += tambahHari;
                totalBiaya = mobilSewa.getHargaPerHari() * jumlahHari;
                System.out.println("Harga sewa per hari setelah tambah hari: $" + mobilSewa.getHargaPerHari());
                System.out.println("Total Biaya setelah tambah hari: $" + totalBiaya);
            }

            // Lakukan penyewaan
            Pelanggan pelanggan = manajemenPelanggan.getPelangganAktif();
            if (pelanggan != null) {
                pelanggan.sewaMobil(mobilSewa, jumlahHari);
                penyediaMobil.pelangganSewa.add(pelanggan);

                penyediaMobil.tampilkanPenyewa();
            }
        } else {
            System.out.println("Mobil tidak ditemukan.");
        }
    }
}
