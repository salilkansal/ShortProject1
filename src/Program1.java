
import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        LinkedList<Integer> ls1 = new LinkedList<>();
        LinkedList<Integer> ls2 = new LinkedList<>();

        for (int i = 0; i < 25; i++)  //list of numbers from 0 to 24
            ls1.add(i);
        for (int i = 1; i < 25; i += 2) //list of odd numbers from 0 to 24
            ls2.add(i);
        LinkedList<Integer> intersection = new LinkedList<>();
        LinkedList<Integer> union = new LinkedList<>();
        LinkedList<Integer> setDifference = new LinkedList<>();
        findIntersection(ls1, ls2, intersection);
        findUnion(ls1, ls2, union);
        findSetDifference(ls1, ls2, setDifference);
        System.out.println("Set 1 : " + ls1);
        System.out.println("Set 2 : " + ls2);
        System.out.println("Intersection : " + intersection);
        System.out.println("Union : " + union);
        System.out.println("Set Difference : " + setDifference);
    }


    public static <T extends Comparable<? super T>> void findIntersection(List<T> ls1, List<T> ls2, List<T> intersection) {
        ListIterator<T> lstIter1 = ls1.listIterator();
        ListIterator<T> lstIter2 = ls2.listIterator();
        T element1 = null, element2 = null;
        Boolean advance1 = true, advance2 = true;
        while (lstIter1.hasNext() && lstIter2.hasNext()) {
            if (advance1)
                element1 = lstIter1.next();
            if (advance2)
                element2 = lstIter2.next();
            if (element1.compareTo(element2) == 0) {
                intersection.add(element1);
                advance1 = true;
                advance2 = true;
            } else if (element1.compareTo(element2) < 0) {
                advance2 = false;
                advance1 = true;
            } else {
                advance1 = false;
                advance2 = true;
            }
        }
        if (lstIter1.hasNext() && advance1) {
            element1 = lstIter1.next();
            if (element1.compareTo(element2) == 0)
                intersection.add(element1);
        } else if (lstIter2.hasNext() && advance2) {
            element2 = lstIter2.next();
            if (element1.compareTo(element2) == 0)
                intersection.add(element1);
        }
    }


    public static <T extends Comparable<? super T>> void findUnion(List<T> ls1,List<T> ls2,List<T> union){
        Iterator<T> litr1 = ls1.iterator();
        Iterator<T> litr2 = ls2.iterator();
        T element1=null, element2=null;
        Boolean adv1 = true, adv2 = true;
        while(litr1.hasNext()&&litr2.hasNext()){
            if (adv1)
                element1 = litr1.next();
            if (adv2)
                element2 = litr2.next();
            if(element1.compareTo(element2)==0){
                union.add(element1);
                adv1 = true;
                adv2 = true;
            }
            else if(element1.compareTo(element2)<0){
                union.add(element1);
                adv1 = true;
                adv2 = false;
            }
            else{
                union.add(element2);
                adv2 = true;
                adv1 = false;
            }
        }
        while (litr1.hasNext())
            union.add(litr1.next());
        while (litr2.hasNext())
            union.add(litr2.next());
    }

    public static <T extends Comparable<? super T>> void findSetDifference(List<T> ls1, List<T> ls2, List<T> setDifference) {
        ListIterator<T> litr1 = ls1.listIterator();
        ListIterator<T> litr2 = ls2.listIterator();
        T element1 = null, element2 = null;
        Boolean adv1 = true, adv2 = true;
        while (litr1.hasNext() && litr2.hasNext()) {
            if (adv1)
                element1 = litr1.next();
            if (adv2)
                element2 = litr2.next();
            if (element1.compareTo(element2) < 0) {
                setDifference.add(element1);
                adv1 = true;
                adv2 = false;
            } else if (element1.compareTo(element2) > 0) {
                adv1 = false;
                adv2 = true;
            } else {
                adv1 = true;
                adv2 = true;
            }
        }
        while (litr1.hasNext()) {
            element1 = litr1.next();
            if (element1.compareTo(element2) != 0)
                setDifference.add(element1);
        }
    }
}