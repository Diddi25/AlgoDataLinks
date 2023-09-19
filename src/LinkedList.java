class LinkedList {
    Cell first;
    LinkedList (int n) { //initierar en lista med längd n
        Cell next = null;
        for (int i = 0; i < n; i++) {
            next = new Cell(i, next); //initierar null objekt i varje cell property
        }
        first = next;
    }

    public void add(Cell newFirst) {
        newFirst.nextCell = first;
    }
    public int length() {
        int counter = 0;
        while (first.nextCell != null) {
            counter++;
            first = first.nextCell;
        }
        return counter;
    }

    public boolean find(Cell wantedCell) {
        while (first.nextCell != null) {
            if(first == wantedCell) {
                return true;
            }
            first = first.nextCell;
        }
        return false;
    }

    public void remove(Cell targetCell) {
        if(find(targetCell)) {
            while (first.nextCell != targetCell) {
                first = first.nextCell;
            }
            first = first.nextCell.nextCell;
            targetCell.nextCell = null;
        }
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
