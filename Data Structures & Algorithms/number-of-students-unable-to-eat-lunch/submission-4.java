class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];

        // Count how many students want 0 and how many want 1
        for (int student : students) {
            count[student]++;
        }

        // Go through sandwiches from top to bottom
        for (int sandwich : sandwiches) {
            // If no student wants this sandwich, nobody else can eat
            if (count[sandwich] == 0) {
                break;
            }

            // One student who wants this sandwich eats it
            count[sandwich]--;
        }

        // Students left unable to eat
        return count[0] + count[1];
    }
}