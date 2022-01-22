package PreparingQuestions.MidtermQuestions.src.midtermCS221.src.midtermCS221;

import midtermCS221.StackInterface;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ExamStackArray<E> implements StackInterface<E> {


    E [] data;
    int top = -1;
    private static final int INITIAL_CAPACITY = 10;

    public ExamStackArray(){
        data =  (E[]) new Object[INITIAL_CAPACITY];
    }

    public ExamStackArray(int capacity){
        data =  (E[]) new Object[capacity];
    }


    @Override
    public E push(E obj) {
        if(top==data.length-1){
            reallocate();
        }
        top++;
        data[top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    @Override
    public E pop() {
        if (empty()) {
            return null;
        }
        E hand = data[top];
        top--;
        return hand;
    }

    @Override
    public boolean empty() {
        return (top == -1);
    }

    private void reallocate(){
        data = Arrays.copyOf(data, 2 * data.length);
    }

    @Override
    public int getSize(){
        return top+1;
    }

    public E getTop(){
        if(empty()){
            return null;
        }
        return data[top];
    }
    

    public int[] Q3C_flushOutToArray(){
        //TODO write your implementation here ...
        int[] arr = new int[getSize()];
        int i = 0;
        while (!empty()) {
            arr[i] = (int)pop();
            i++;
        }

        return arr;
    }

    //mum madam
    public boolean isPalindrome(String word){
        int len = word.length() / 2;
        for (int i = 0; i < len; i++){
            Character item  = (Character)word.charAt(i);
            push((E)item);
        }

        int start = (word.length() % 2 == 0) ? len : len + 1;
        for (int i = start; i < word.length(); i++){
            if ((Character)word.charAt(i) == peek())
                pop();
        }
        return empty();
    }

    //create a method that take a string and it should return how many vowels using stack.
    //convert the decimal number to the binary number
    public int countVowels(String word){
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < word.length(); i++){
            String str = word.charAt(i) + "";
            if (vowels.contains(str))
                push((E)str);
        }
        return getSize();
    }

    public String convertToBinary(int number){
        Integer reference = number;
        while (reference != 0){
            Integer x = reference % 2;
            push((E)x);
            reference = reference / 2;
        }
        String binary = "";
        while (!empty())
            binary += pop();
        return binary;
    }

    public static void main (String[] args){
        ExamStackArray<String> st = new ExamStackArray<>();
        //st.push(5);
        //st.push(6);
        //st.push(7);

        int [] numArr = st.Q3C_flushOutToArray();
        System.out.println(st.convertToBinary(40));

        //System.out.println("Is palindrome : " + st.isPalindrome("stackkcats"));
        // FIXME remove the comment tags to test the method
        /*while (!st.empty())
          //  System.out.println(st.pop());*/



        /*
        Expected result
                    7
                    6
                    5
        */


    }

}
