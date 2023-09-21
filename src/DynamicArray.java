public class DynamicArray {
    public int size;
    public int[] array;
    DynamicArray(int size) {
        this.size = size;
        this.array = new int[this.size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }
    public void append(DynamicArray anotherArray) {
        int[] newArray = new int[this.size + anotherArray.size];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        for (int i = this.size; i < newArray.length; i++) {
            newArray[i] = anotherArray.array[i - this.size];
        }
        this.array = newArray;
        this.size = newArray.length;
    }

}
