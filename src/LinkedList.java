class LinkedList {
    Cell first;
    LinkedList (int n) { //initierar en lista med längd n
        Cell next = null;
        for (int i = 0; i < n; i++) {
            next = new Cell(i, next); //initierar varje cell med ett värde upp till n,
        }
        this.first = next;
    }
    public void addAtFirst(int item) {
        this.first = new Cell(item, this.first);
    }
    public int length() {
        int counter = 0;
        while (first.nextCell != null) {
            counter++;
            first = first.nextCell;
        }
        return counter;
    }
    public boolean find(int item) {
        while (first.nextCell != null) {
            if (first.value == item) {
                return true;
            }
            first = first.nextCell;
        }
        return false;
    }
    public void remove(int item) {
        if (find(item)) {
            while (first.value != item) {
                first = first.nextCell;
            }
            first = first.nextCell.nextCell;
        }
    }
    public void append(LinkedList anotherList) {
        Cell next = this.first;
        Cell previous = null;
        while (next.nextCell != null) {
            previous = next;
            next = next.nextCell;
        }
        next.nextCell = anotherList.first;
    }
}
