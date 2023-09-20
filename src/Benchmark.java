public class Benchmark {
    public static void main(String[] args) {
        System.out.printf("#%4s%12s%11s%7s%8s\n", "n", "A variates", "B variates", "merge", "quick\n");
        benchmark();
    }
    private static final int tries = 1000;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    public static void benchmark() {
        int[] sizesForA = {100, 250, 500, 1000, 2500, 4000, 5500};
        int[] sizesForB = {100, 250, 500, 1000, 2500, 4000, 5500};

        for (int n: sizesForA) {
            LinkedList A = new LinkedList(n);
            LinkedList B = new LinkedList(5);

            System.out.printf("%5d", n);
            float timeForFirstTask = tryThis1000Times(A, B);
            System.out.printf("%12.0f", timeForFirstTask);
        }
        restoreMinAndMax();
        System.out.println(" ");
        for (int n: sizesForB) {
            LinkedList A = new LinkedList(5);
            LinkedList B = new LinkedList(n);

            System.out.printf("%5d", n);
            float timeForFirstTask = tryThis1000Times(A, B);
            System.out.printf("%12.0f", timeForFirstTask);
        }
        for (int n: sizesForA) {
            LinkedList A = new LinkedList(5);
            LinkedList B = new LinkedList(n);

            System.out.printf("%5d", n);
            float timeForFirstTask = tryThis1000Times(A, B);
            System.out.printf("%12.0f", timeForFirstTask);
        }
    }
    private static float tryThis1000Times(LinkedList firstList, LinkedList secondList) {
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            firstList.append(secondList);
            long t1 = System.nanoTime();
            long t = t1 - t0;
            if(t < min) {
                min = t;
            }
            if(t > max) {
                max = t;
            }
        }
        return (max + min) / 2;
    }
    private static void restoreMinAndMax() {
        min = Float.POSITIVE_INFINITY;
        max = -1;
    }
}
