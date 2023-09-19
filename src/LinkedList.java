class LinkedList {
    Cell first;
    LinkedList (int n) {
        Cell next = null;
        for (int i = 0; i < n; i++) {
            next = new Cell(i, next);
        }
        first = next;
    }

    public void append(LinkedList b) {
        Cell next = this.first;
        Cell previous = null;
        while (next.nextCell != null) {
            previous = next;
            next = next.nextCell;
        }
    }
}
