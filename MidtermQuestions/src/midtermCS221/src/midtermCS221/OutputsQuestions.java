package PreparingQuestions.MidtermQuestions.src.midtermCS221.src.midtermCS221;

import java.util.Stack;

public class OutputsQuestions {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        int n = stack.peek();
        stack.push(n);
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++){
            System.out.println(stack.pop());
        }
        //10 10 5
    }
}
