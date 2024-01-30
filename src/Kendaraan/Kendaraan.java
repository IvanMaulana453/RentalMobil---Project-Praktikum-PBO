package Kendaraan;

abstract class Kendaraan {
    //Variabel
    public String jenis;
    public double hargaPerHari;
    public String warna;

    public Kendaraan(String jenis, double hargaPerHari, String warna) {
        this.jenis = jenis;
        this.hargaPerHari = hargaPerHari;
        this.warna = warna;
    }

    public abstract void tampilkanDetail();
}

