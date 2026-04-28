class Rekursjon {
    public static void main(String[] args) {
        int[] arr = {10, 11, 2, 13, 5};
        minst(arr, 0);
    }

    public static int minst(int[] arr, int i) {
        if (arr.length - 1 == i) return arr[i];
        int minstHitill = minst(arr, i + 1);
        if (arr[i] < minstHitill) return arr[i];
        else return minstHitill;
    }



    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}