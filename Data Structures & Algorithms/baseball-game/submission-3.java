class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String num : operations){
            if(num.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                int sum = first + second;

                stack.push(first);
                stack.push(sum);
            } else if (num.equals("C")){
                stack.pop();
            } else if (num.equals("D")){
                stack.push(stack.peek()*2);
            } else {
                stack.push(Integer.parseInt(num));
            }
        }
         int sum = 0;
            for (int score : stack){
                sum += score;
            }
        return sum;
    }
}