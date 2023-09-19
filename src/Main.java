public class Main {
    public static void main(String[] args) {
        DynamicArray A = new DynamicArray(4);
        A.array = new int[]{1, 2, 3, 4};
        DynamicArray B = new DynamicArray(5);
        B.array = new int[]{1, 2, 3, 4,5};
        int[] newArray = A.append(B);
        System.out.println(newArray.length);
    }
}