import Pelanggan.*;
import Kendaraan.*;
import Sewa.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PenyediaMobil penyediaMobil = new PenyediaMobil();
        penyediaMobil.tampilkanPenyewa();
        ManajemenPelanggan manajemenPelanggan = new ManajemenPelanggan();

        while (true) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Login Sebagai Penyedia Mobil");
            System.out.println("2. Login Sebagai Pelanggan");
            System.out.println("3. Daftar Akun Baru Pelanggan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihanUtama = scanner.nextInt();

            switch (pilihanUtama) {
                case 1:
                    System.out.print("Masukkan username penyedia mobil: ");
                    String usernamePenyedia = scanner.next();
                    System.out.print("Masukkan password penyedia mobil: ");
                    String passwordPenyedia = scanner.next();

                    // Login berhasil
                    System.out.println("Login berhasil sebagai penyedia mobil.");

                    // Menu Penyedia Mobil
                    int pilihan;
                    do {
                        System.out.println("\nMenu Penyedia Mobil:");
                        System.out.println("1. Tambah Mobil");
                        System.out.println("2. Hapus Mobil");
                        System.out.println("3. Lihat Informasi Pelanggan");
                        System.out.println("4. List Mobil");
                        System.out.println("5. Kembali");
                        System.out.println();
                        System.out.print("Pilih menu: ");
                        pilihan = scanner.nextInt();

                        switch (pilihan) {
                            case 1:
                                System.out.print("Jenis Mobil: ");
                                String jenis = scanner.next();
                                System.out.print("Harga per Hari: ");
                                double hargaPerHari = scanner.nextDouble();
                                System.out.print("Warna: ");
                                String warna = scanner.next();
                                penyediaMobil.tambahkanMobil(jenis, hargaPerHari, warna);
                                break;
                            case 2:
                                System.out.print("Masukkan index mobil yang akan dihapus: ");
                                int indexHapus = scanner.nextInt();
                                penyediaMobil.hapusMobil(indexHapus);
                                break;
                            case 3:
                                penyediaMobil.tampilkanPenyewa();
                                break;
                            case 4:
                                TampilkanDaftarMobil.tampilkanDaftarMobil(penyediaMobil.getMobilDisewakan());
                                break;
                            case 5:
                                System.out.println("Kembali");
                                break;

                            default:
                                System.out.println("Pilihan tidak ada!!");
                                break;
                        }
                    } while (pilihan != 5);
                    break;
                case 2:
                    // Login Pelanggan
                    System.out.print("Masukkan username pelanggan: ");
                    String usernamePelanggan = scanner.next();
                    System.out.print("Masukkan password pelanggan: ");
                    String passwordPelanggan = scanner.next();
                    Pelanggan pelanggan = manajemenPelanggan.loginPelanggan(usernamePelanggan, passwordPelanggan);


                    if (pelanggan != null) {
                        while (true) {
                            System.out.println("\nMenu Pelanggan:");
                            System.out.println("1. Cari Mobil");
                            System.out.println("2. Sewa Mobil");
                            System.out.println("3. Tampilkan Daftar Mobil");
                            System.out.println("4. Keluar");
                            System.out.print("Pilih menu: ");
                            int pilihanPelanggan = scanner.nextInt();

                            switch (pilihanPelanggan) {
                                case 1:
                                    System.out.print("Masukkan jenis mobil yang dicari: ");
                                    String jenisMobilCari = scanner.next();
                                    pencarianMobil(penyediaMobil, jenisMobilCari);
                                    break;
                                case 2:
                                    ManajemenPenyewaan.sewaMobil(scanner, penyediaMobil, manajemenPelanggan);
                                    break;
                                case 3:
                                    TampilkanDaftarMobil.tampilkanDaftarMobil(penyediaMobil.getMobilDisewakan());
                                    break;
                                case 4:
                                    System.out.println("Keluar dari akun pelanggan.");
                                    Pelanggan pelangganAktif = manajemenPelanggan.getPelangganAktif();
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid.");
                            }

                            if (pilihanPelanggan == 3) {
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    // Daftar Akun Pelanggan
                    System.out.print("Masukkan nama pelanggan: ");
                    String namaPelanggan = scanner.next();
                    System.out.print("Masukkan username pelanggan: ");
                    String usernameBaru = scanner.next();
                    System.out.print("Masukkan password pelanggan: ");
                    String passwordBaru = scanner.next();
                    manajemenPelanggan.tambahPelanggan(namaPelanggan, usernameBaru, passwordBaru);
                    break;
                case 4:
                    System.out.println("Keluar dari aplikasi.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void pencarianMobil(PenyediaMobil penyediaMobil, String jenisMobil) {
        ArrayList<Mobil> mobilDitemukan = new ArrayList<>();

        for (Mobil mobil : penyediaMobil.getMobilDisewakan()) {
            if (mobil.getJenis().equalsIgnoreCase(jenisMobil)) {
                mobilDitemukan.add(mobil);
            }
        }

        if (!mobilDitemukan.isEmpty()) {
            System.out.println("Mobil yang ditemukan:");
            for (int i = 0; i < mobilDitemukan.size(); i++) {
                System.out.println("Index " + i);
                mobilDitemukan.get(i).tampilkanDetail();
                System.out.println();
            }
        } else {
            System.out.println("Mobil dengan jenis " + jenisMobil + " tidak ditemukan.");
        }
    }
}

