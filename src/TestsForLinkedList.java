public class TestsForLinkedList {
    public static void main(String[] args) {
        //test för append()

        LinkedList A = new LinkedList(0);

        LinkedList B = new LinkedList(0);

        A.append(B);
        System.out.println(A.length());
    }
    private static void testForRemove() {
        LinkedList A = new LinkedList(4);
        Cell next2 = A.first;
        for (int i = 0; i < 4; i++) {
            System.out.print(next2.value + " ");
            next2 = next2.nextCell;
        }

        A.remove(2);
        System.out.println("");

        Cell next = A.first;
        for (int i = 0; i < 3; i++) {
            System.out.print(next.value + " ");
            next = next.nextCell;
        }
    }
    private static void testForFindMethod() {
        LinkedList A = new LinkedList(5);
        System.out.println(A.find(7));
    }
    private void testLengthMethod() {
        LinkedList A = new LinkedList(5);
        A.addAtFirst(5);
        A.addAtFirst(5);
        LinkedList B = new LinkedList(0);
        System.out.println(A.length());
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
