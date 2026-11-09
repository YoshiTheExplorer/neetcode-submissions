class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int sandwichIdx = 0;
        int turnNum = 0;
        int turns = students.length;


        while(turnNum < turns){
            if(students[0] != sandwiches[sandwichIdx]){
                students = returnToBack(students);
                turnNum++;
                continue;
            } else {
                turnNum = 0;
                turns--;
                sandwichIdx++;
                students = removeStudent(students);
            }
        }
        return students.length;
    }

    public int[] returnToBack(int[] students){
        int back = students[0];
        int i = 0;
        while(i < students.length-1){
            students[i] = students[i+1];
            i++;
        }
        students[students.length-1] = back;
        return students;
    }
    public int[] removeStudent(int[] students){
        int[] newStudents = new int[students.length-1];
        for(int i = 1; i < students.length; i++){
            newStudents[i-1] = students[i];
        }
        return newStudents;
    }
}