import java.util.Random;

public class Exa {

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } // bytt

    public static int[] randPerm(int n) {
        Random r = new Random(); // en random genereation
        int[] a = new int[n]; // en tabell med plass til n tall

        for (int i = 0; i < n; i++) a[i] = i + 1; // den legger inn talene 1,2,...n

        for (int k = n - 1; k > 0; k--) { // løkka som går n-1
            int i = r.nextInt(k + 1); // en tifeldig tall fra 0 til k
            bytt(a, k, i);

        }
        return a;
    } // randPerm

    static int max(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) throw new
                IllegalArgumentException();

        int maksindex = fra;
        int maksverdi = a[fra];

        for (int i = fra; i < til; i++) {
            if (a[i] > maksverdi) {
                maksindex = i;
                maksverdi = a[maksindex];

            }
        }
        return maksindex;
    } // maks

    static int max(int[] a) {
        return max(a, 0, a.length);
    } // max


    public static int[] nestMax(int[] a, int begin, int end) {
        // int a = {1,2,3,4,5,6};
        int n = a.length; // n = 6
        if (n < 2) throw // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ")<2!");

        int index_maks = max(a);
        int nestIndex_maks;
        if (index_maks == 0) {
            nestIndex_maks = max(a, 1, n);
        } else if (index_maks == n - 1) {
            nestIndex_maks = max(a, 0, n - 1);
        } else {
            int maxverdi = max(a, 0, index_maks);
            int mh = max(a, index_maks + 1, n);
            nestIndex_maks = a[mh] > a[maxverdi] ? mh : maxverdi;
        }
        return new int[]{index_maks, nestIndex_maks};

    } // NEST MAKS

    static int[] nestMax(int[] a) {
        return nestMax(a, 0, a.length);
    } // nestmaks


    public static void skrivln(int[] a, int fra, int til) {
        skriv(a, fra, til);
        System.out.println();
    }
    private static void skriv(int[] a, int fra, int til) {}

    public static void skrivln(int[] a) {
        skrivln(a, 0, a.length);
    }





    public static void main(String[] args) {
        System.out.println("nestMax er:");
        int[] permtation = Exa.randPerm(100); // tilfeldig permutasjon av 1,...100
        int[] retur = Exa.nestMax(permtation); // metoden som returnerer en  tabell
        int maksindex = retur[0]; // for maks
        int nestmaxindex = retur[1]; // for nestmaks
        Exa.skrivln(permtation); // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("størst(" + permtation[maksindex] + ") har posisjon  " + maksindex);
        System.out.println(", nest størst (" + permtation[nestmaxindex] + ") har posisjon " + nestmaxindex);

    }// main

}
