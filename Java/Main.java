/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gudanginternet;

/**
 *
 * @author ASUS
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BarangService service = new BarangService();

        // Data awal contoh
        service.tambahBarang("Modem ZTE F609", "Perangkat Jaringan", 350000, 25);
        service.tambahBarang("Kabel Fiber Optik Dropcore 100m", "Kabel", 750000, 15);
        service.tambahBarang("Router Mikrotik RB750", "Perangkat Jaringan", 620000, 10);

        boolean running = true;

        while (running) {
            tampilkanMenu();
            int pilihan = Validator.inputPilihanMenu(sc, "Pilih menu (1-6): ", 1, 6);

            switch (pilihan) {
                case 1:
                    tambahBarang(sc, service);
                    break;
                case 2:
                    System.out.println("\n=== DAFTAR BARANG GUDANG ===");
                    service.tampilkanSemuaBarang();
                    break;
                case 3:
                    cariBarang(sc, service);
                    break;
                case 4:
                    updateBarang(sc, service);
                    break;
                case 5:
                    hapusBarang(sc, service);
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan Sistem Gudang Internet Comtelindo!");
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void tampilkanMenu() {
        System.out.println("===========================================");
        System.out.println("   SISTEM GUDANG INTERNET COMTELINDO");
        System.out.println("===========================================");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Tampilkan Semua Barang");
        System.out.println("3. Cari Barang berdasarkan ID");
        System.out.println("4. Update Barang");
        System.out.println("5. Hapus Barang");
        System.out.println("6. Keluar");
        System.out.println("===========================================");
    }

    private static void tambahBarang(Scanner sc, BarangService service) {
        System.out.println("\n=== TAMBAH BARANG GUDANG ===");
        String nama = Validator.inputString(sc, "Nama barang: ");
        String kategori = Validator.inputString(sc, "Kategori: ");
        double harga = Validator.inputDoubleMin(sc, "Harga (Rp): ", 0);
        int stok = Validator.inputIntMin(sc, "Stok: ", 0);

        Barang barangBaru = service.tambahBarang(nama, kategori, harga, stok);
        System.out.println("Barang berhasil ditambahkan dengan ID: " + barangBaru.getId());
    }

    private static void cariBarang(Scanner sc, BarangService service) {
        System.out.println("\n=== CARI BARANG ===");
        int id = Validator.inputIntMin(sc, "Masukkan ID barang: ", 1);
        Barang barang = service.cariBarangById(id);
        if (barang == null) {
            System.out.println("Barang dengan ID " + id + " tidak ditemukan.");
        } else {
            System.out.println("Barang ditemukan:");
            System.out.println(barang);
        }
    }

    private static void updateBarang(Scanner sc, BarangService service) {
        System.out.println("\n=== UPDATE BARANG ===");
        service.tampilkanSemuaBarang();
        int id = Validator.inputIntMin(sc, "Masukkan ID barang yang ingin diupdate: ", 1);
        Barang barang = service.cariBarangById(id);
        if (barang == null) {
            System.out.println("Barang dengan ID " + id + " tidak ditemukan.");
            return;
        }

        System.out.println("Data saat ini: " + barang);
        String nama = Validator.inputString(sc, "Nama barang baru: ");
        String kategori = Validator.inputString(sc, "Kategori baru: ");
        double harga = Validator.inputDoubleMin(sc, "Harga baru (Rp): ", 0);
        int stok = Validator.inputIntMin(sc, "Stok baru: ", 0);

        boolean berhasil = service.updateBarang(id, nama, kategori, harga, stok);
        if (berhasil) {
            System.out.println("Barang berhasil diupdate.");
        } else {
            System.out.println("Gagal mengupdate barang.");
        }
    }

    private static void hapusBarang(Scanner sc, BarangService service) {
        System.out.println("\n=== HAPUS BARANG ===");
        service.tampilkanSemuaBarang();
        int id = Validator.inputIntMin(sc, "Masukkan ID barang yang ingin dihapus: ", 1);
        Barang barang = service.cariBarangById(id);
        if (barang == null) {
            System.out.println("Barang dengan ID " + id + " tidak ditemukan.");
            return;
        }
        System.out.print("Yakin ingin menghapus '" + barang.getNamaBarang() + "'? (y/n): ");
        String konfirmasi = sc.nextLine().trim().toLowerCase();
        if (konfirmasi.equals("y")) {
            service.hapusBarang(id);
            System.out.println("Barang berhasil dihapus.");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }
}
