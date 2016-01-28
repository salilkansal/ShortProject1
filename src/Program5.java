/**
 * Created by salilkansal on 1/27/16.
 */
class Entry<T> {
    T element;
    Entry<T> next;

    Entry(T x, Entry<T> nxt) {
        element = x;
        next = nxt;
    }
}

class SinglyLinkedList<T> {


    Entry<T> header, tail;
    int size;

    SinglyLinkedList() {
        header = new Entry<>(null, null);
        tail = null;
        size = 0;
    }

    void add(T x) {
        if (tail == null) {
            header.next = new Entry<>(x, header.next);
            tail = header.next;
        } else {
            tail.next = new Entry<>(x, null);
            tail = tail.next;
        }
        size++;
    }

    void printList() {
        Entry<T> x = header.next;
        while (x != null) {
            System.out.print(x.element + " ");
            x = x.next;
        }
        System.out.println();
    }
}

class State<E> {
    SinglyLinkedList<E> list;

    public State() {
        list = new SinglyLinkedList<>();
    }


}

class Unzipper<E> {
    State<E>[] states;

    Unzipper(int k) {
        states = new State[k];
        for (int i = 0; i < states.length; i++) {
            states[i] = new State<>();
        }
    }

    void multiUnzip(SinglyLinkedList<E> originalList) {
        int currState = 0;

        Entry<E> ptr = originalList.header.next;

        while (ptr != null) {
            System.out.println("State:" + currState);
            System.out.println("Ptr.element: " + ptr.element);
            states[currState].list.add(ptr.element);
            if (currState < states.length-1)
                currState++;
            else
                currState = 0;
            ptr = ptr.next;
        }

        for(State<E> myState: states){
            myState.list.printList();
        }
    }


}


public class Program5 {


    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
        Unzipper<Integer> unzip = new Unzipper<>(2);
        unzip.multiUnzip(list);

    }

}
