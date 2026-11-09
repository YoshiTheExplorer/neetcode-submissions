class DynamicArray {
    private int[] arr;
    private int capacity;
    private int length;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.length = 0;
    }

    public int get(int i) {
        if(i > this.length - 1) return -1;
        return arr[i];
    }

    public void set(int i, int n) {
        if(i > this.length - 1) return;
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if(this.length >= this.capacity) resize();
        this.arr[this.length] = n;
        this.length++;
    }

    public int popback() {
        this.length--;
        return this.arr[this.length];
    }

    private void resize() {
        int[] temp = new int[this.capacity*2];
        int i = 0;
        for(int a : this.arr){
            temp[i] = a;
            i++;
        }
        this.arr = temp;
        this.capacity = this.capacity * 2;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
