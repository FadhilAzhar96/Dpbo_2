package penyimpanan;

public class Validasi {
    // Memeriksa apakah input teks kosong, hanya berisi spasi, atau null
    public static boolean kosong(String input) {
        return input == null || input.trim().isEmpty();
    }
    // Bila inputan berisi angka, maka mengembalikan true
    public static boolean angka(String input) {
        try {
            Integer.parseInt(input);
            return true;
    // Mengembalikan false jika inputan bukan merupakan angka (mengandung teks/huruf)
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //nilai yang valid untuk dimasukkan dari 0 sampai 300
    public static boolean nilaiValid(int nilai) {
        return nilai >= 0 && nilai <= 300;
    }
}
