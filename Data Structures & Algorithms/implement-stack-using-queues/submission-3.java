class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;
    Boolean oneIsLongest;

    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
        oneIsLongest = true;
    }

    // 1: 8
    // 2: 1, 2, 3, 4, 5, 6, 7

    // 1: 1
    // 2: 2, 3

    public void push(int x) {
        // init 0
        if (first.size() == 0 && second.size() == 0) {
            first.add(x);
            oneIsLongest = true;
            return;
        }

        if (!oneIsLongest) {
            first.add(x);
            second.add(first.poll());
        } else {
            second.add(x);
            first.add(second.poll());
        }
    }

    // 1: 8,
    // 2: 1, 2, 3, 4, 5, 6, 7

    // 1: 1
    // 2: 2, 3

    public int pop() {
        if (!oneIsLongest) {
            int size = second.size();

            for (int i = 0; i < size - 1; i++) {
                first.add(second.poll());
            }

            oneIsLongest = true;
            return second.poll();
        } else {
            int size = first.size();

            for (int i = 0; i < size - 1; i++) {
                second.add(first.poll());
            }

            oneIsLongest = false;
            return first.poll();
        }
    }

    public int top() {
        int top;

        if (oneIsLongest) {
            int size = first.size();

            for (int i = 0; i < size - 1; i++) {
                second.add(first.poll());
            }

            top = first.poll();
            second.add(top);
            oneIsLongest = false;
        } else {
            int size = second.size();

            for (int i = 0; i < size - 1; i++) {
                first.add(second.poll());
            }

            top = second.poll();
            first.add(top);
            oneIsLongest = true;
        }

        return top;
    }

    public boolean empty() {
        return first.size() == 0 && second.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */