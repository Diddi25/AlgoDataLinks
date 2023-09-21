public class Benchmark {
    public static void main(String[] args) {
        System.out.printf("#%4s%15s%15s%15s%15s\n", "n", "A list vary", "B list vary", "A array vary", "B array vary\n");
        benchmark();
    }
    private static final int tries = 1;
    private static final int fixedSize = 5;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    public static void benchmark() {
        int[] differentSizes = {100, 250, 500, 1000, 2500, 4000, 5500};
        testDifferentSizesForLists(differentSizes);
        testDifferentSizesForArrays(differentSizes);
    }
    private static void testDifferentSizesForLists(int[] differentSizes) {
        LinkedList B = new LinkedList(fixedSize);
        System.out.println("When A varies");
        for (int n: differentSizes) {
            LinkedList A = new LinkedList(n);
            printResultForLists(n, A, B);
        }
        restoreMinAndMax();
        System.out.println(" ");
        System.out.println("When B varies");
        for (int n: differentSizes) {
            LinkedList A = new LinkedList(n);
            printResultForLists(n, B, A);
        }
    }
    private static void printResultForLists(int n, LinkedList A, LinkedList B) {
        System.out.printf("%5d", n);
        float timeForFirstTask = tryThis1000TimesForList(A, B);
        System.out.printf("%12.0f\n", timeForFirstTask);
    }
    private static void testDifferentSizesForArrays(int[] differentSizes) {
        DynamicArray B = new DynamicArray(fixedSize);
        System.out.println(" ");
        System.out.println("When A varies for arrays");
        for (int n: differentSizes) {
            DynamicArray A = new DynamicArray(n);
            printResultForArrays(n, A, B);
        }
        restoreMinAndMax();
        System.out.println(" ");
        System.out.println("When B varies for arrays");
        for (int n: differentSizes) {
            DynamicArray A = new DynamicArray(n);
            printResultForArrays(n, B, A);
        }
    }
    private static void printResultForArrays(int n, DynamicArray A, DynamicArray B) {
        System.out.printf("%5d", n);
        float timeForFirstTask = tryThis1000TimesForArrays(A, B);
        System.out.printf("%12.0f\n", timeForFirstTask);
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
