class LinkedList {
    Cell first;

    LinkedList(int n) {
        Cell last = null;
        for (int i = 0; i<n; i++) {
            last = new Cell(i, last);
        }
        first = last;
    }

    private class Cell {
        int head;
        Cell tail;
        Cell(int value, Cell t1) {
            head = value;
            tail = t1;
        }
    }

    public void append(LinkedList b) {
        Cell next = this.first;
        Cell previous = null;
        while (next.tail != null) {
            previous = next;
            next = next.tail;
        }
    }
}
