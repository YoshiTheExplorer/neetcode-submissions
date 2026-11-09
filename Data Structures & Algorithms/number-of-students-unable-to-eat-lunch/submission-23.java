class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for(int student : students){
            queue.add(student);
        }

        int attempts = 0;
        int turns = students.length;
        int sandwichIdx = 0;
        while(attempts < turns){
            // if its a match
                // remove from students
                // move onto next sandwich
                // reduce turns
                // turn attemps to 0
            // if it isn't a match
                // move student to the back
                // increase attempt
            if(queue.peek() == sandwiches[sandwichIdx]){
                queue.poll();
                sandwichIdx++;
                turns--;
                attempts = 0;
            } else {
                queue.add(queue.poll());
                attempts++;
            }
        }
        return queue.size();
    }
}