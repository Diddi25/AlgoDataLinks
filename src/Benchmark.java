public class Benchmark {
    public static void main(String[] args) {
        System.out.printf("#%4s%12s%11s%7s%8s\n", "n", "A variates", "B variates", "merge", "quick\n");
        benchmark();
    }
    private static final int tries = 1000;
    private static final int fixedSize = 5;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    public static void benchmark() {
        int[] differentSizes = {100, 250, 500, 1000, 2500, 4000, 5500};

        for (int n: differentSizes) {
            LinkedList A = new LinkedList(n);
            LinkedList B = new LinkedList(fixedSize);

            System.out.printf("%5d", n);
            float timeForFirstTask = tryThis1000TimesForList(A, B);
            System.out.printf("%12.0f", timeForFirstTask);
        }
        restoreMinAndMax();
        System.out.println(" ");
        for (int n: differentSizes) {
            LinkedList A = new LinkedList(fixedSize);
            LinkedList B = new LinkedList(n);

            System.out.printf("%5d", n);
            float timeForFirstTask = tryThis1000TimesForList(A, B);
            System.out.printf("%12.0f", timeForFirstTask);
        }
        for (int n: differentSizes) {
            DynamicArray A = new DynamicArray(n);
            DynamicArray B = new DynamicArray(fixedSize);

            System.out.printf("%5d", n);
            float timeForFirstTask = tryThis1000TimesForArrays(A, B);
            System.out.printf("%12.0f", timeForFirstTask);
        }
        for (int n: differentSizes) {
            DynamicArray A = new DynamicArray(fixedSize);
            DynamicArray B = new DynamicArray(n);

            System.out.printf("%5d", n);
            float timeForFirstTask = tryThis1000TimesForArrays(A, B);
            System.out.printf("%12.0f", timeForFirstTask);
        }
    }
    private static float tryThis1000TimesForList(LinkedList firstList, LinkedList secondList) {
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
    private static float tryThis1000TimesForArrays(DynamicArray firstArray, DynamicArray secondArray) {
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            firstArray.append(secondArray);
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
