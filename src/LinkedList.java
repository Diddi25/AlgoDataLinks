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
        Cell next = this.first;
        int counter = 0;
        while (next != null) {
            counter++;
            next = next.nextCell;
        }
        return counter;
    }
    public boolean find(int item) {
        Cell next = this.first;
        while (next.nextCell != null) {
            if (next.value == item) {
                return true;
            }
            next = next.nextCell;
        }
        return false;
    }
    public void remove(int item) {
        if (find(item)) {
            Cell next = this.first;
            while (next.value != item) {
                next = next.nextCell;
            }
            next = next.nextCell.nextCell;
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
