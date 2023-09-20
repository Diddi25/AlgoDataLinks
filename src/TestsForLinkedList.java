public class TestsForLinkedList {
    public static void main(String[] args) {
        LinkedList A = new LinkedList(5);

        for (int i = 0; i < 5; i++) {
            System.out.print(A.first.value + " ");
            A.first = A.first.nextCell;
        }

        //System.out.println(A.first.value);

        A.addAtFirst(3);
        System.out.println(" ");

        for (int i = 0; i < 6; i++) {
            System.out.print(A.first.value + " ");
            A.first = A.first.nextCell;
        }
    }
}
