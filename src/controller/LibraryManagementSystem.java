package controller;

import view.Menu;
import model.Book;
import model.Library;
import model.Member;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {

    public void bookManagementSubMenu(Library library, Scanner scanner) {
        while (true) {
            try {
                // tampilan untuk menu
                Menu menu = new Menu();
                menu.bookManagementSubMenuView();

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        // Menambahkan buku baru ke dalam perpustakaan.
                        System.out.print("Judul: ");
                        scanner.nextLine();
                        String title = scanner.nextLine();
                        System.out.print("Penulis: ");
                        String author = scanner.nextLine();
                        String ISBN;
                        do {
                            System.out.print("ISBN (13 angka): ");
                            ISBN = scanner.nextLine();
                            if (!library.isValidISBN(ISBN)) {
                                System.out.println("ISBN tidak valid. Harus terdiri dari 13 angka.");
                            }
                        } while (!library.isValidISBN(ISBN));
                        System.out.print("Jumlah Tersedia: ");
                        int availableCopies = scanner.nextInt();
                        Book newBook = new Book(title, author, ISBN, availableCopies);
                        library.addBook(newBook);
                        System.out.println("Buku berhasil ditambahkan.");
                    }
                    case 2 -> {
                        // Meminjam buku dari perpustakaan.
                        System.out.print("Masukkan ISBN buku yang ingin dipinjam: ");
                        scanner.nextLine();
                        String borrowISBN = scanner.nextLine();
                        System.out.print("Masukkan ID Anggota: ");
                        int borrowMemberId = scanner.nextInt();
                        library.borrowBook(borrowISBN, borrowMemberId);
                    }
                    case 3 -> {
                        // Mengembalikan buku yang telah dipinjam.
                        System.out.print("Masukkan ISBN buku yang dikembalikan: ");
                        scanner.nextLine();
                        String returnISBN = scanner.nextLine();
                        System.out.print("Masukkan ID Anggota: ");
                        int returnMemberId = scanner.nextInt();
                        library.returnBook(returnISBN, returnMemberId);
                    }
                    case 4 -> library.listBooks(); // Menampilkan daftar buku.
                    case 5 -> {
                        // Menghapus buku dari perpustakaan.
                        System.out.print("Masukkan ISBN buku yang ingin dihapus: ");
                        scanner.nextLine();
                        String deleteISBN = scanner.nextLine();
                        library.deleteBook(deleteISBN);
                    }
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Opsi tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Mohon masukkan input yang sesuai.");
                scanner.nextLine();
            }
        }
    }

    // Submenu untuk manajemen anggota (member)
    private void memberManagementSubMenu(Library library, Scanner scanner) {
        while (true) {
            try {
                // tampilan untuk menu
                Menu menu = new Menu();
                menu.memberManagementSubMenuView();

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        // Menambahkan anggota baru ke dalam perpustakaan.
                        scanner.nextLine();
                        System.out.print("Nama Anggota: ");
                        String memberName = scanner.nextLine();
                        Member newMember = new Member(library.memberIdCounter, memberName);
                        library.addMember(newMember);
                        System.out.println("Anggota berhasil ditambahkan. ID Anggota: " + newMember.getMemberId());
                    }
                    case 2 -> library.listMembers(); // Menampilkan daftar anggota.
                    case 3 -> {
                        // Menghapus anggota dari perpustakaan.
                        System.out.print("Masukkan ID Anggota yang ingin dihapus: ");
                        int deleteMemberId = scanner.nextInt();
                        library.deleteMember(deleteMemberId);
                    }
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Opsi tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Mohon masukkan input yang sesuai.");
                scanner.nextLine();
            }
        }
    }

    // Submenu untuk manajemen file
    private void fileManagementSubMenu(Library library, Scanner scanner) {
        while (true) {
            try {
                // tampilan untuk menu
                Menu menu = new Menu();
                menu.fileManagementSubMenuView();

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        // Menyimpan data buku ke file
                        library.saveBooksToFile("./src/data/books_data.csv");
                        System.out.println("Data buku telah disimpan.");
                    }
                    case 2 -> {
                        // Menyimpan data anggota ke file
                        library.saveMembersToFile("./src/data/members_data.csv");
                        System.out.println("Data anggota telah disimpan.");
                    }
                    case 3 -> {
                        // Menyimpan data transaksi ke file
                        library.saveTransactionsToFile("./src/data/transactions_data.csv");
                        System.out.println("Data transaksi telah disimpan.");
                    }
                    case 4 -> {
                        // Memuat data buku dari file
                        library.loadBooksFromFile("./src/data/books_data.csv");
                        System.out.println("Data buku telah dimuat.");
                    }
                    case 5 -> {
                        // Memuat data anggota dari file
                        library.loadMembersFromFile("./src/data/members_data.csv");
                        System.out.println("Data anggota telah dimuat.");
                    }
                    case 6 -> {
                        // Memuat data transaksi dari file
                        library.loadTransactionsFromFile("./src/data/transactions_data.csv");
                        System.out.println("Data transaksi telah dimuat.");
                    }
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Opsi tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Mohon masukkan input yang sesuai.");
                scanner.nextLine();
            }
        }
    }

    public void mainProgram() {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // tampilan untuk menu
                Menu menu = new Menu();
                menu.mainMenuView();

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> bookManagementSubMenu(library, scanner);
                    case 2 -> memberManagementSubMenu(library, scanner);
                    case 3 -> fileManagementSubMenu(library, scanner);
                    case 4 ->
                        // Menampilkan log transaksi peminjaman dan pengembalian.
                            library.displaySeparatedTransactionLog();
                    case 0 -> {
                        System.out.println("Data berhasil disimpan. Terima kasih!");
                        System.exit(0);
                    }
                    default -> System.out.println("Opsi tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Mohon masukkan input yang sesuai.");
                scanner.nextLine();
            }
        }
    }
}