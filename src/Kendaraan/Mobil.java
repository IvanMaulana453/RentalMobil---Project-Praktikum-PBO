package Kendaraan;

public class Mobil extends Kendaraan {
    public Mobil(String jenis, double hargaPerHari, String warna) {
        super(jenis, hargaPerHari, warna);
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Jenis Mobil: " + jenis);
        System.out.println("Harga per Hari: $" + hargaPerHari);
        System.out.println("Warna: " + warna);
    }

    public String getJenis() {
        return jenis;
    }

    public double getHargaPerHari() {
        return hargaPerHari;
    }


}

