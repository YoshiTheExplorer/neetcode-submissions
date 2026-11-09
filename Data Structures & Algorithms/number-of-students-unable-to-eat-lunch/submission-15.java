class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();

        for (int student : students) {
            q.offer(student);
        }

        int sandwichIdx = 0;

        while (!q.isEmpty()) {
            int rotations = 0;
            int size = q.size();

            while (rotations < size && q.peek() != sandwiches[sandwichIdx]) {
                q.offer(q.poll());
                rotations++;
            }

            if (rotations == size) {
                break;
            }

            q.poll();
            sandwichIdx++;
        }

        return q.size();
    }
}