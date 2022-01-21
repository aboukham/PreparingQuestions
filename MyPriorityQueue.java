import java.util.Queue;

public class MyPriorityQueue<E>{
    //Queue stack priorityQ
    //72 67 56 4
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    class Node<E>{
            private E data;
            private Node<E> next;

            public Node(E item, Node<E> next){
                this.data = item;
                this.next = next;
            }
    }
    
    private void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    public boolean offer(E item) {
        if (head == null || ((Person)item).getAge() > ((Person)head.data).getAge()){
            addFirst(item);
        }else {
            Node<E> current = head;
            Node<E> previousNode = null;
            while (current != null && (((Person)item).getAge() < ((Person)current.data).getAge())) {
                previousNode = current;
                current = current.next;
            }
            addAfter(previousNode, item);
        }
        return true;
    }

    public E poll() {
        if (size == 0)
            return null;
        E p = head.data;
        head = head.next;
        size--;
        return p;
    }

    public E peek() {
        if (size == 0)
            return null;
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void displayQueue(){
        Node<E> current = head;
        for (int i = 0; i < size(); i++){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args){
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(new Person("abdelaziz", "male", 30));
        queue.offer(new Person("Jhon", "male", 66));
        queue.offer(new Person("david", "male", 40));
        queue.offer(new Person("alexandra", "male", 57));
        queue.displayQueue();
        //System.out.println("tail" + queue.tail.data);
        System.out.println();
        queue.poll();
        queue.displayQueue();
        System.out.println();
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());

    }
}
