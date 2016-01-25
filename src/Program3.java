class SortableList<T extends Comparable<? super T>>{
    private class Entry<T> {
        T element;
        Entry<T> next;
        Entry(T x, Entry<T> nxt) {
            element = x;
            next = nxt;
        }
    }
    Entry<T> header, tail;
    int size;
    SortableList() {
        header = new Entry<>(null, null);
        tail = null;
        size = 0;
    }
    public void add(T x) {
        if(tail == null) {
            header.next = new Entry<>(x, header.next);
            tail = header.next;
        } else {
            tail.next = new Entry<>(x, null);
            tail = tail.next;
        }
        size++;
    }
    public void printList() {
        Entry<T> x = header.next;
        while(x != null) {
            System.out.print(x.element + " ");
            x = x.next;
        }
        System.out.println();
    }
    private Entry<T> merge(Entry<T> list1, Entry<T> list2, int num) {
        System.out.println("Start element of list 1 : "+list1.element);
        System.out.println("Start element of list 2 : "+list2.element);
        int pos1 = 0;
        int pos2 = 0;
        int leftBound = num/2;
        int rightBound = num - (num/2);
        System.out.println("Number of elements in list 1 : "+leftBound);
        System.out.println("Number of elements in list 2 : "+rightBound);
        Entry<T> start = null;
        if(list1.element.compareTo(list2.element)<=0){
            start = list1;
            pos1++;
            list1 = list1.next;
        }
        else{
            start = list2;
            pos2++;
            list2 = list2.next;
        }
        Entry<T> temp = start;
        System.out.println("Starting element of result : "+start.element);
        System.out.println("Position 1 : "+pos1);
        System.out.println("Position 2 : "+pos2);
        System.out.println("Left Bound : "+leftBound);
        System.out.println("Right Bound : "+rightBound);
        while(pos1<leftBound && pos2<rightBound){
            if(list1.element.compareTo(list2.element)<=0){
                temp.next = list1;
                pos1++;
                temp = temp.next;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                pos2++;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        while(pos1<leftBound){
            temp.next = list1;
            pos1++;
            temp = temp.next;
            list1 = list1.next;
        }
        while(pos2<rightBound){
            temp.next = list2;
            pos2++;
            temp = temp.next;
            list2 = list2.next;
        }
        temp.next = null;
        System.out.println();
        return start;
    }
    private Entry<T> mergeSort(Entry<T> start,int num) {
        if(num<2)
            return start;
        Entry<T> ptrMiddle = start;
        int index = 0;
        while(index<num/2){
            ptrMiddle = ptrMiddle.next;
            index++;
        }
        start = mergeSort(start,num/2);
        ptrMiddle = mergeSort(ptrMiddle,num-(num/2));
        return merge(start,ptrMiddle,num);
    }
    public <T extends Comparable<? super T>> void mergeSort() {
        header.next = mergeSort(header.next,size);
    }
}
public class Program3 extends SortableList{
    public static void main(String[] args) {
        SortableList<Integer> lst = new SortableList<>();
        for(int i=10; i>0; i--) {
            lst.add(new Integer(i));
        }
        lst.printList();
        lst.mergeSort();
        lst.printList();
    }
}