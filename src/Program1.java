// import java.util.ArrayList;  // uncomment this if you want to pass the input in a arraylist
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Program1 {
    public static void main(String[] args) {
        LinkedList<Integer> ls1 = new LinkedList<>();
        LinkedList<Integer> ls2 = new LinkedList<>();
//        ArrayList<Integer> ls1 = new ArrayList<>();
//        ArrayList<Integer> ls2 = new ArrayList<>();
        for(int i=0;i<25;i++)
            ls1.add(i);
        for(int i=1;i<25;i+=2)
            ls2.add(i);
        LinkedList<Integer> intersection = new LinkedList<>();
        LinkedList<Integer> union = new LinkedList<>();
        LinkedList<Integer> setDifference = new LinkedList<>();
        findIntersection(ls1,ls2,intersection);
        findUnion(ls1,ls2,union);
        findSetDifference(ls1,ls2,setDifference);
        System.out.println("Set 1 : "+ls1);
        System.out.println("Set 2 : "+ls2);
        System.out.println("Intersection : "+intersection);
        System.out.println("Union : "+union);
        System.out.println("Set Difference : "+setDifference);
    }

    public static <T extends Comparable<? super T>> void findIntersection(List<T> ls1,List<T> ls2,List<T> intersection){
        ListIterator<T> litr1 = ls1.listIterator();
        ListIterator<T> litr2 = ls2.listIterator();
        T element1=null, element2=null;
        Boolean adv1 = true, adv2 = true;
        while(litr1.hasNext()&&litr2.hasNext()){
            if(adv1 == true)
                element1 = litr1.next();
            if(adv2 == true)
                element2 = litr2.next();
            if(element1.compareTo(element2)==0){
                intersection.add(element1);
                adv1 = true;
                adv2 = true;
            }
            else if(element1.compareTo(element2)<0){
                adv2 = false;           // If the element in one list is smaller
                adv1 = true;
            }
            else{                        // than the element in the other then we will not
                adv1 = false;           // advance the pointer in list that has bigger element
                adv2 = true;
            }
        }
        if(litr1.hasNext()&&adv1==true){
            element1 = litr1.next();
            if(element1.compareTo(element2)==0)
                intersection.add(element1);
        }
        else if(litr2.hasNext()&&adv2==true){
            element2 = litr2.next();
            if(element1.compareTo(element2)==0)
                intersection.add(element1);
        }
    }

    public static <T extends Comparable<? super T>> void findUnion(List<T> ls1,List<T> ls2,List<T> union){
        ListIterator<T> litr1 = ls1.listIterator();
        ListIterator<T> litr2 = ls2.listIterator();
        T element1=null, element2=null;
        Boolean adv1 = true, adv2 = true;
        while(litr1.hasNext()&&litr2.hasNext()){
            if(adv1 == true)
                element1 = litr1.next();
            if(adv2 == true)
                element2 = litr2.next();
            if(element1.compareTo(element2)==0){
                union.add(element1);        // Duplicates are not allowed, So we add only one in that case
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
        while(litr1.hasNext())      // Add the rest of elements from list 1 if any
            union.add(litr1.next());
        while(litr2.hasNext())      // Add the rest of elements from list 2 if any
            union.add(litr2.next());
    }

    public static <T extends Comparable<? super T>> void findSetDifference(List<T> ls1,List<T> ls2,List<T> setDifference){
        ListIterator<T> litr1 = ls1.listIterator();
        ListIterator<T> litr2 = ls2.listIterator();
        T element1 = null, element2 = null;
        Boolean adv1 = true, adv2 = true;
        while(litr1.hasNext()&&litr2.hasNext()){
            if(adv1 == true)
                element1 = litr1.next();
            if(adv2 == true)
                element2 = litr2.next();
            if(element1.compareTo(element2)<0){
                setDifference.add(element1);
                adv1 = true;
                adv2 = false;
            }
            else if(element1.compareTo(element2)>0){
                adv1 = false;
                adv2 = true;
            }
            else{
                adv1 = true;
                adv2 = true;
            }
        }
        while(litr1.hasNext()){      // Add the rest of elements from list 1 if any
            element1 = litr1.next();
            if(element1.compareTo(element2)!=0)
                setDifference.add(element1);
        }
    }
}