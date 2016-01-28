import java.util.Stack;

public class Program6<T> {
    public class Entry<T> {
        T element;
        Entry<T> next;

        Entry(T x, Entry<T> nxt) {
            element = x;
            next = nxt;
        }
    }


    Entry<T> header, tail;
    int size;

    Program6() {
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

    void reverseList() {
        Entry<T> x = header.next;
        if (x != null) {
            Entry<T> y = x, temp = x.next;
            if (x != null) {
                x.next = null;
                while (temp != null) {
                    x = temp;
                    temp = x.next;
                    x.next = y;
                    y = x;
                }
                header.next = x;
            }
        }
    }

    void printReverse() {
        Entry<T> x = header.next;
        if (x != null) {
            Stack<T> stack = new Stack<>();
            while (x != null) {
                stack.add(x.element);
                x = x.next;
            }
            while (!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        }
    }

    void reverse() {
        Entry<T> x = header.next;
        if (x != null) {
            Entry<T> y = x.next;
            reverseRecursive(x, y);
        }
    }

    void reverseRecursive(Entry<T> x, Entry<T> y) {
        if (y == null) {
            header.next = x;
            return;
        }
        reverseRecursive(y, y.next);
        y.next = x;
        x.next = null;
    }

    void printListReverse() {
        Entry<T> x = header.next;
        printReverseRecursive(x);
    }

    void printReverseRecursive(Entry<T> x) {
        if (x == null)
            return;
        printReverseRecursive(x.next);
        System.out.print(x.element + " ");
    }

    public static void main(String[] args) {
        int n = 10;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }
        Program6<Integer> lst = new Program6<>();
        for (int i = 1; i <= n; i++) {
            lst.add(new Integer(i));
        }
        System.out.print("Original List : ");
        lst.printList();
        lst.reverseList();
        System.out.print("Reverse List without recursion : ");
        lst.printList();
        System.out.println();
        lst.reverseList();
        lst.reverse();
        System.out.print("Reverse List using recursion : ");
        lst.printList();
        System.out.println();
        lst.reverse();
        System.out.print("Print the list in reverse order using recursion : ");
        lst.printListReverse();
        System.out.println();
        System.out.println();

        System.out.print("Print the list in reverse order without recursion : ");
        lst.printReverse();
        System.out.println();
    }
}