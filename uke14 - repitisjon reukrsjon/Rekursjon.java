public class Rekursjon {
    public static void main(String[] args) {
        Integer[] liste = {1, 32, 54, 7, 223, 3};
        sum_arr(10, liste);
    }
    public static int rec(int teller) {
        if (teller == 1) return 1;
        int sum_hittil = teller + rec(teller-1);
        return sum_hittil;
    }

    // Oppgave: en rekursjiv funksjon som returnerer summen
    // til et array.
    public static int sum_arr(int i, int[] arr) {
        
    }
    // Oppgave: en rekursjiv funksjon som returnerer det
    // største elementet i et array.

    public static int fin_maks(int i, int[] arr) {
        if (i == arr.length - 1) {
            return arr[i];
        }
        int storst_hitill = fin_maks(i + 1, arr);
        if (storst_hitill > arr[i]) {
            return storst_hitill;
        } else {
            return arr[i];
        }
    }

}
