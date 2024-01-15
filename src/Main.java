import java.util.ArrayList;
import java.util.List;

class Kendaraan {
    private String platNomor;
    private int berat;

    public Kendaraan(String platNomor, int berat) {
        this.platNomor = platNomor;
        this.berat = berat;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public int getBerat() {
        return berat;
    }
}

class TempatParkir {
    private List<Kendaraan> kendaraanList;
    private int kapasitas;
    private int bebanBerat;

    public TempatParkir(int kapasitas, int bebanBerat) {
        this.kendaraanList = new ArrayList<>();
        this.kapasitas = kapasitas;
        this.bebanBerat = bebanBerat;
    }

    public void masukParkir(Kendaraan kendaraan) {
        if ((kendaraanList.size() < kapasitas) && (bebanBerat >= kendaraan.getBerat())) {
            kendaraanList.add(kendaraan);
            bebanBerat -= kendaraan.getBerat();
            System.out.println("Kendaraan " + kendaraan.getPlatNomor() + " berhasil masuk ke tempat parkir.");
        } else {
            System.out.println("Tempat parkir penuh atau melebihi beban berat maksimal.");
        }
    }

    public void tampilkanInfoParkir() {
        System.out.println("Jumlah kendaraan yang parkir: " + kendaraanList.size());
        System.out.println("Beban berat tersisa: " + bebanBerat + " kg");
    }
}

public class Main {
    public static void main(String[] args) {
        // Inisialisasi tempat parkir setiap lantai
        TempatParkir lantai1 = new TempatParkir(100, 2000);
        TempatParkir lantai2 = new TempatParkir(100, 1800);
        TempatParkir lantai3 = new TempatParkir(100, 1500);

        // Contoh kendaraan yang masuk parkir
        Kendaraan mobil1 = new Kendaraan("B 1234 CD", 1500);
        Kendaraan mobil2 = new Kendaraan("D 5678 EF", 1700);
        Kendaraan mobil3 = new Kendaraan("F 9012 GH", 2000);

        // Kendaraan masuk ke tempat parkir
        lantai1.masukParkir(mobil1);
        lantai2.masukParkir(mobil2);
        lantai3.masukParkir(mobil3);

        // Tampilkan info parkir setiap lantai
        System.out.println("\nInfo Parkir Lantai 1:");
        lantai1.tampilkanInfoParkir();

        System.out.println("\nInfo Parkir Lantai 2:");
        lantai2.tampilkanInfoParkir();

        System.out.println("\nInfo Parkir Lantai 3:");
        lantai3.tampilkanInfoParkir();
    }
}
