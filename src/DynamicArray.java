public class DynamicArray {
    public int size;
    public int[] array = new int[size];
    DynamicArray(int size) {
        this.size = size;
    }
    public int[] append(DynamicArray anotherArray) {
        int[] newArray = new int[this.size + anotherArray.size];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        for (int i = this.size; i < newArray.length; i++) {
            newArray[i] = anotherArray.array[i - this.size];
        }
        //this.array = newArray;
        return newArray;
    }

}
