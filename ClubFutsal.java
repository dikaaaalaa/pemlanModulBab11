import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//DHIKALAFFAIZ MARISKY-255150707111015-TEKNOLOGI INFORMASI//

class Pemain {
    String tim;
    int no;
    int tinggiBadan;
    int beratBadan;

    public Pemain(String tim, int no, int tinggiBadan, int beratBadan) {
        this.tim = tim;
        this.no = no;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }
    @Override
    public String toString() {
        return String.format("%s No.%02d [Tinggi: %d cm, Berat: %d kg]", tim, no, tinggiBadan, beratBadan);
    }
}
public class ClubFutsal {

    public static void main(String[] args) {
        List<Pemain> timA = new ArrayList<>();
        List<Pemain> timB = new ArrayList<>();

        //tim A
        timA.add(new Pemain("Tim A", 1, 168, 50));
        timA.add(new Pemain("Tim A", 2, 170, 60));
        timA.add(new Pemain("Tim A", 3, 165, 56));
        timA.add(new Pemain("Tim A", 4, 168, 55));
        timA.add(new Pemain("Tim A", 5, 172, 60));
        timA.add(new Pemain("Tim A", 6, 170, 70));
        timA.add(new Pemain("Tim A", 7, 169, 66));
        timA.add(new Pemain("Tim A", 8, 165, 56));
        timA.add(new Pemain("Tim A", 9, 171, 72));
        timA.add(new Pemain("Tim A", 10, 166, 56));

        //tim B
        timB.add(new Pemain("Tim B", 1, 170, 66));
        timB.add(new Pemain("Tim B", 2, 167, 60));
        timB.add(new Pemain("Tim B", 3, 165, 59));
        timB.add(new Pemain("Tim B", 4, 166, 58));
        timB.add(new Pemain("Tim B", 5, 168, 58));
        timB.add(new Pemain("Tim B", 6, 175, 71));
        timB.add(new Pemain("Tim B", 7, 172, 68));
        timB.add(new Pemain("Tim B", 8, 171, 68));
        timB.add(new Pemain("Tim B", 9, 168, 65));
        timB.add(new Pemain("Tim B", 10, 169, 60));


        System.out.println("========== JAWABAN NOMOR 1 ==========\n");
        List<Pemain> semuaPemain = new ArrayList<>();
        semuaPemain.addAll(timA);
        semuaPemain.addAll(timB);

        System.out.println("1.a. Mengurutkan Seluruh Pemain Berdasarkan Tinggi Badan:");
        semuaPemain.sort(Comparator.comparingInt(p -> p.tinggiBadan));
        System.out.println("--- Ascending (Menaik) ---");
        for (Pemain p : semuaPemain) System.out.println(p);

        semuaPemain.sort((p1, p2) -> Integer.compare(p2.tinggiBadan, p1.tinggiBadan));
        System.out.println("\n--- Descending (Menurun) ---");
        for (Pemain p : semuaPemain) System.out.println(p);

        System.out.println("\n1.b. Mengurutkan Seluruh Pemain Berdasarkan Berat Badan:");
        semuaPemain.sort(Comparator.comparingInt(p -> p.beratBadan));
        System.out.println("--- Ascending (Menaik) ---");
        for (Pemain p : semuaPemain) System.out.println(p);

        semuaPemain.sort((p1, p2) -> Integer.compare(p2.beratBadan, p1.beratBadan));
        System.out.println("\n--- Descending (Menurun) ---");
        for (Pemain p : semuaPemain) System.out.println(p);

        System.out.println("\n1.c. Nilai Max & Min Masing-Masing Tim:");
        cariMaxMin(timA, "Tim A");
        cariMaxMin(timB, "Tim B");

        List<Pemain> timC = new ArrayList<>();
        System.out.println("\n1.d. Copy Anggota Tim B ke Tim C Berhasil! Berikut isi Tim C yang baru dibentuk:");
        for (Pemain p : timB) {
            Pemain pemainTimC = new Pemain("Tim C", p.no, p.tinggiBadan, p.beratBadan);
            timC.add(pemainTimC);
            System.out.println(pemainTimC);
        }
        System.out.println();


        System.out.println("========== JAWABAN NOMOR 2 ==========\n");

        System.out.println("2.a. Isi Data di Dalam ArrayList Terpisah:");
        System.out.println("--- ArrayList Tim A ---");
        for (Pemain p : timA) System.out.println(p);
        
        System.out.println("\n--- ArrayList Tim B ---");
        for (Pemain p : timB) System.out.println(p);

        timB.sort(Comparator.comparingInt(p -> p.tinggiBadan)); 
        int jumlah168TimB = countOccurrencesByTinggi(timB, 168);
        int jumlah160TimB = countOccurrencesByTinggi(timB, 160);
        System.out.println("\n2.b. Pencarian di Tim B (Binary Search):");
        System.out.println("- Jumlah pemain dengan tinggi 168 cm: " + jumlah168TimB);
        System.out.println("- Jumlah pemain dengan tinggi 160 cm: " + jumlah160TimB);

        timA.sort(Comparator.comparingInt(p -> p.beratBadan));
        int jumlah56TimA = countOccurrencesByBerat(timA, 56);
        int jumlah53TimA = countOccurrencesByBerat(timA, 53);
        System.out.println("\n2.c. Pencarian di Tim A (Binary Search):");
        System.out.println("- Jumlah pemain dengan berat 56 kg: " + jumlah56TimA);
        System.out.println("- Jumlah pemain dengan berat 53 kg: " + jumlah53TimA);

        System.out.println("\n2.d. Pengecekan Pemain Tim A yang memiliki Tinggi/Berat sama dengan pemain Tim B:");
        cekKesamaanTimAdanB(timA, timB);
    }

    public static void cariMaxMin(List<Pemain> tim, String namaTim) {
        Pemain maxTinggi = Collections.max(tim, Comparator.comparingInt(p -> p.tinggiBadan));
        Pemain minTinggi = Collections.min(tim, Comparator.comparingInt(p -> p.tinggiBadan));
        Pemain maxBerat = Collections.max(tim, Comparator.comparingInt(p -> p.beratBadan));
        Pemain minBerat = Collections.min(tim, Comparator.comparingInt(p -> p.beratBadan));

        System.out.println(namaTim + ":");
        System.out.println("- Tinggi Max: " + maxTinggi.tinggiBadan + " cm (No " + maxTinggi.no + "), Min: " + minTinggi.tinggiBadan + " cm (No " + minTinggi.no + ")");
        System.out.println("- Berat Max: " + maxBerat.beratBadan + " kg (No " + maxBerat.no + "), Min: " + minBerat.beratBadan + " kg (No " + minBerat.no + ")");
    }

    public static int binarySearchTinggi(List<Pemain> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).tinggiBadan == target) return mid;
            if (list.get(mid).tinggiBadan < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; 
    }
    public static int countOccurrencesByTinggi(List<Pemain> list, int target) {
        int index = binarySearchTinggi(list, target);
        if (index == -1) return 0;

        int count = 1;
        int left = index - 1;
        while (left >= 0 && list.get(left).tinggiBadan == target) {
            count++; left--;
        }
        int right = index + 1;
        while (right < list.size() && list.get(right).tinggiBadan == target) {
            count++; right++;
        }
        return count;
    }
    public static int binarySearchBerat(List<Pemain> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).beratBadan == target) return mid;
            if (list.get(mid).beratBadan < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static int countOccurrencesByBerat(List<Pemain> list, int target) {
        int index = binarySearchBerat(list, target);
        if (index == -1) return 0;

        int count = 1;
        int left = index - 1;
        while (left >= 0 && list.get(left).beratBadan == target) {
            count++; left--;
        }
        int right = index + 1;
        while (right < list.size() && list.get(right).beratBadan == target) {
            count++; right++;
        }
        return count;
    }
    public static void cekKesamaanTimAdanB(List<Pemain> timA, List<Pemain> timB) {
        boolean adaSama = false;

        timB.sort(Comparator.comparingInt(p -> p.tinggiBadan));
        for (Pemain pA : timA) {
            if (binarySearchTinggi(timB, pA.tinggiBadan) != -1) {
                System.out.println("- " + pA.tim + " No." + pA.no + " memiliki TINGGI yang SAMA dengan pemain Tim B (" + pA.tinggiBadan + " cm)");
                adaSama = true;
            }
        }

        timB.sort(Comparator.comparingInt(p -> p.beratBadan));
        for (Pemain pA : timA) {
            if (binarySearchBerat(timB, pA.beratBadan) != -1) {
                System.out.println("- " + pA.tim + " No." + pA.no + " memiliki BERAT yang SAMA dengan pemain Tim B (" + pA.beratBadan + " kg)");
                adaSama = true;
            }
        }

        if (!adaSama) {
            System.out.println("Tidak ada pemain di Tim A yang memiliki tinggi atau berat yang sama dengan Tim B.");
        }
    }
}
