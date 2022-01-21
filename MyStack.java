import java.util.*;

public class MyStack<E> implements Iterable<E>{
    /*public class MyIterator implements Iterator<E>{
        public MyIterator(){}
        public Node<E> current = getHead();


        @Override
        public boolean hasNext() {
            System.out.println(current.data);

            return (current != null);
        }

        @Override
        public E next() {
            E item = current.data;
            size++;
            current = current.next;
            return item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }
    */
    public class MyIterator implements Iterator<E>{
        Node<E> current = head;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E item = current.data;
            current = current.next;
            return item;
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();//stop
    }

    static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E item, Node<E> next){
            this.data = item;
            this.next = next;
        }
    }


    private Node<E> head = null;
    private int size = 0;

    public void push(E item){
        Node<E> node = new Node(item, head);
        head = node;
        size++;
    }

    public E pop(){
        if (size == 0)
            return null;
        E item = head.data;
        head = head.next;
        size--;
        return item;
    }

    public E peek(){
        if (size == 0)
            return null;
        E item = head.data;
        return item;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public String reverseLine(String line){
        //hello world --> world hello
        String[] words = line.split(" ");
        for (int i = 0 ; i < words.length; i++){
            E item = (E)words[i];
            this.push(item);
        }

        String result = "";
        while (!isEmpty())
            result += this.pop() + " ";
        return result;
    }

    public Node<E> getHead() {
        return head;
    }

    public static void main(String[] args){

        MyStack<Integer> stack = new MyStack<Integer>();
        //stop
        //the stack is empty the head is still null
        stack.push(45);
        stack.push(51);
        stack.push(3);
        stack.push(-23);

        //System.out.println(stack.head.data);
        Iterator<Integer> iter = stack.iterator();
        while (iter.hasNext()){//false
            //if (!stack.isEmpty())
            int item = (int)iter.next();
            System.out.println(item);
        }

        /*MyStack<Integer> stack = new MyStack<>();

        stack.push(56);
        stack.push(45);
        stack.push(80);
        stack.push(10);
        stack.push(90);

        Iterator<Integer> iter = stack.iterator();
        //Node<Integer> node = sll.head;
        while(iter.hasNext()){
            System.out.println(iter.next());
        }*/

    }
}
