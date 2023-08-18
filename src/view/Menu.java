package view;

public class Menu {
    public void  bookManagementSubMenuView() {
        // Menampilkan pilihan menu kepada pengguna.
        System.out.println("=== Manajemen Buku ===");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Daftar Buku");
        System.out.println("5. Hapus Buku");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public void memberManagementSubMenuView() {
        System.out.println("=== Manajemen Anggota ===");
        System.out.println("1. Tambah Anggota");
        System.out.println("2. Daftar Anggota");
        System.out.println("3. Hapus Anggota");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public void fileManagementSubMenuView() {
        System.out.println("=== Manajemen File ===");
        System.out.println("1. Simpan Data Buku");
        System.out.println("2. Simpan Data Anggota");
        System.out.println("3. Simpan Data Transaksi");
        System.out.println("4. Muat Data Buku");
        System.out.println("5. Muat Data Anggota");
        System.out.println("6. Muat Data Transaksi");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public void mainMenuView() {
        // Tampilkan menu utama
        System.out.println("=== Menu Utama ===");
        System.out.println("1. Manajemen Buku");
        System.out.println("2. Manajemen Anggota");
        System.out.println("3. Manajemen File");
        System.out.println("4. Daftar Transaksi");
        System.out.println("0. Keluar");
        System.out.print("Pilih opsi: ");
    }
}
