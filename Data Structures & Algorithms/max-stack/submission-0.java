class MaxStack {
    int[] stack;
    int size;

    public MaxStack() {
        stack = new int[10000];
        size = 0;
    }
    
    public void push(int x) {
        stack[size] = x;
        size++;
    }
    
    public int pop() {
        int num = stack[size - 1];
        size--;
        return num;
    }
    
    public int top() {
        return stack[size - 1];
    }
    
    public int peekMax() {
        int max = stack[0];

        for (int i = 1; i < size; i++) {
            if (stack[i] > max) {
                max = stack[i];
            }
        }

        return max;
    }
    
    public int popMax() {
        int max = peekMax();
        int maxIndex = 0;

        // If there are duplicates, remove the top-most max
        for (int i = 0; i < size; i++) {
            if (stack[i] == max) {
                maxIndex = i;
            }
        }

        int num = stack[maxIndex];

        // Shift everything after maxIndex left by 1
        for (int i = maxIndex; i < size - 1; i++) {
            stack[i] = stack[i + 1];
        }

        size--;

        return num;
    }
}