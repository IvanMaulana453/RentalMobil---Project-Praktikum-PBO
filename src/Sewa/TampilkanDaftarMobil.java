package Sewa;

import Kendaraan.Mobil;

import java.util.ArrayList;

public class TampilkanDaftarMobil {
    public static void tampilkanDaftarMobil(ArrayList<Mobil> mobilDisewakan) {
        System.out.println("\nDaftar Mobil yang Tersedia:");
        for (int i = 0; i < mobilDisewakan.size(); i++) {
            System.out.println("Index " + i);
            mobilDisewakan.get(i).tampilkanDetail();
            System.out.println();
        }
    }
}
