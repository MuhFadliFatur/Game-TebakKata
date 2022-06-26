package Game.Tebak.Kata;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;


public class Main {
        private final static String[] gudangKata = {"informatika", "java", "kompilator", "interpreter", "applet",
                "debugger", "loading", "verify", "execute", "helloworld",
                "enterprise", "aswarfajar", "aswarfajar@gmail.com", "fadli", "faturrahman"};

        private final static String[] kataKunci = {"teknik", "bahasa pemrograman", "jdk", "jdk", "jenis java",
                "jdk", "siklus program java", "siklus program java", "siklus program java", "latihan java",
                "edisi java", "tokoh dunia", "email", "mahasiswa SI", "mahasiswa SI"};

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            Random rand = new Random();
            int acak;
            int kesempatan;
            String kataPilihan;
            boolean ulangi = false;
            char pilih, jawab;
            String pilih2;
            String[] ubah;
            boolean back;
            int index = gudangKata.length-1;
            int index2 = kataKunci.length-1;

            do {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("                Game Tebak Kata");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(" 1. anda akan diberi kesempatan menebak 8 kali ");
                System.out.println(" 2. kata berhubungan dgn dunia IT ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                lanjut();
                acak = rand.nextInt(gudangKata.length-1);
                kataPilihan = "";
                kesempatan = 8;
                ubah = gudangKata[acak].split("");
                for (int c = 0; c <= gudangKata[acak].length(); c++) {
                    if(c == index){
                        ubah[c] = "-";
                        kataPilihan = kataPilihan.concat(ubah[c]);
                    }
                }
                do {
                    System.out.println("\n kesempatan anda menebak : " + kesempatan);
                    System.out.println(" Kata Kunci         : " + kataKunci[acak]);
                    System.out.println(" Tebak kata apa ini : " + kataPilihan);
                    System.out.print(" Anda tebak         : ");

                    pilih = scan.next().toLowerCase().charAt(0);
                    pilih2 = String.valueOf(pilih);
                    if(pilih==index2){
                        kataPilihan = proses(kataPilihan, pilih2, acak);
                    }


                    if (kataPilihan.equals(gudangKata[acak])) {
                        System.out.println("\n Selamat Anda bisa... ^_^");
                        break;
                    }
                    if (gudangKata[acak].contains(pilih2)) {
                        continue;
                    }
                    kesempatan--;
                } while (kesempatan > 0);

                if(kesempatan==0 && !kataPilihan.equals(gudangKata[acak])){
                    System.out.println("\n maaf, anda kurang beruntung!!");
                    System.out.println(" Jawaban yang benar adalah : "+gudangKata[acak]+"\n\n");
                    lanjut();
                }

                do {
                    back = false;
                    System.out.print("\n Apalah Anda ingin mengulanginya lagi [y/n]: ");
                    jawab = scan.next().toUpperCase().charAt(0);
                    System.out.println("\n");
                    if (jawab == 'Y') {
                        ulangi = true;
                    } else if (jawab == 'N') {
                        ulangi = false;
                    } else {
                        back = true;
                    }
                } while (back);
            } while (ulangi);
        }

        private static String proses(String kataPilihan, String pilih2, int acak) {
            String[] ubah2 = gudangKata[acak].split("");
            String[] ubah = kataPilihan.split("");
            kataPilihan = "";
            for (int c = 0; c <= gudangKata[acak].length(); c++) {
                if (ubah2[c].equalsIgnoreCase(pilih2)) {
                    ubah[c] = ubah2[c];
                }
                kataPilihan = kataPilihan.concat(ubah[c]);
            }
            return kataPilihan;
        }


        public static void lanjut() {
            Scanner scan = new Scanner(System.in);
            char jawab;
            do {
                System.out.print("  Tekan \"c\" kemudian \"enter\" untuk melanjutkan...");
                jawab = scan.next().toUpperCase().charAt(0);
            } while (jawab != 'C');
        }
    }
