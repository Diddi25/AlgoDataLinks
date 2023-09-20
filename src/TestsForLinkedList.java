public class TestsForLinkedList {
    public static void main(String[] args) {
        //test för längd

        LinkedList A = new LinkedList(5);
        A.addAtFirst(5);
        A.addAtFirst(5);
        LinkedList B = new LinkedList(0);
        System.out.println(B.length());
    }
    private void testLengthMethod() {

    }
    private void testAddMethod() {
        LinkedList A = new LinkedList(5);

        Cell next = A.first;
        for (int i = 0; i < 5; i++) {
            System.out.print(next.value + " ");
            next = next.nextCell;
        }

        A.addAtFirst(3);
        System.out.println(" ");

        Cell next2 = A.first;
        for (int i = 0; i < 6; i++) {
            System.out.print(next2.value + " ");
            next2 = next2.nextCell;
        }
    }
}
