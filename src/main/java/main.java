import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inp;
        
        do {
            System.out.print.ln("--------------");
            System.out.println("Pilih Menu :");
            System.out.print.ln("--------------");
            System.out.println("1. Tampilkan");
            System.out.println("2. Masukkan");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("0. Keluar");

            inp = input.nextInt();
            switch (inp) {
                case 1:
                    database.tampilkan();
                    break;
                case 2:
                    System.out.println("Masukkan ID Buku");
                    int id = input.nextInt();
                    System.out.println("Masukkan Judul Buku");
                    String judul = input.next();
                    System.out.println("Masukkan Tahun Terbit Buku");
                    int tahun = input.nextInt();
                    System.out.println("Masukkan Jumlah Stok Buku");
                    int stok = input.nextInt();
                    System.out.println("Masukkan Jumlah Penulis Buku");
                    int penulis = input.nextInt();
                    database.masukkanBuku(id, judul, tahun, stok, penulis);
                    break;
                case 3:
                    System.out.println("Masukkan ID Buku");
                    id = input.nextInt();
                    System.out.println("Masukkan Judul Buku");
                    String Ejudul = input.next();
                    System.out.println("Masukkan Tahun Terbit Buku");
                    tahun = input.nextInt();
                    System.out.println("Masukkan Jumlah Stok Buku");
                    stok = input.nextInt();
                    System.out.println("Masukkan Jumlah Penulis Buku");
                    penulis = input.nextInt();

                    database.editBuku(id, Ejudul, tahun, stok, penulis);
                    break;
                case 4:
                    System.out.println("Masukkan ID Buku");
                    id = input.nextInt();
                    database.deleteData(id);
                    break;
                case 0:
                    System.out.println("Exit Program....");
                    break;
            }
        } while (inp != 0);
        input.close();
    }


}
