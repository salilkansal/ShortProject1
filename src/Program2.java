import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Program2 {
    public static void main(String[] args) {
        LinkedList<Integer> ls1 = new LinkedList<>();
        LinkedList<Integer> ls2 = new LinkedList<>();
        ls1.add(0);
        ls1.add(0);
        ls1.add(1);
        ls2.add(0);
        ls2.add(0);
        ls2.add(1);
        int base = 10;
        LinkedList<Integer> addition = new LinkedList<>();
        LinkedList<Integer> subtraction = new LinkedList<>();
        add(ls1,ls2,addition,base);
        subtract(ls1,ls2,subtraction,base);
        System.out.println("Addition : "+addition);
        System.out.println("Subtraction : "+subtraction);
    }

    public static void add(List<Integer> ls1,List<Integer> ls2,List<Integer> addition,int base){
        int carry = 0;
        ListIterator<Integer> l1 = ls1.listIterator();
        ListIterator<Integer> l2 = ls2.listIterator();
        while(l1.hasNext()&&l2.hasNext()){
            int x = l1.next();
            int y = l2.next();
            addition.add((carry+x+y)%base);
            carry = (carry+x+y)/base;
        }
        while(l1.hasNext()){
            int x = l1.next();
            addition.add((carry+x)%base);
            carry = (carry+x)/base;
        }
        while(l2.hasNext()){
            int y = l2.next();
            addition.add((carry+y)%base);
            carry = (carry+y)/base;
        }
        if(carry!=0)
            addition.add(carry);
    }

    public static void subtract(List<Integer> ls1,List<Integer> ls2,List<Integer> subtraction,int base){
        int borrow = 0;
        ListIterator<Integer> l1 = ls1.listIterator();
        ListIterator<Integer> l2 = ls2.listIterator();
        while(l2.hasNext()){        // Assumed that x>y
            int x = l1.next();
            int y = l2.next();
            if(x!=0){
                x = x - borrow;
                if(x<y)
                    borrow = 1;
                else
                    borrow = 0;
                x = borrow*base + x;
            }
            else{
                if(borrow==1)
                    x = base - 1;
                else{
                    if(y!=0){
                        borrow = 1;
                        x = base;
                    }
                }
            }
            subtraction.add(x-y);
        }
        while(l1.hasNext()){
            int x = l1.next();
            if(x!=0){
                x = x - borrow;
                borrow = 0;
            }
            else{
                if(borrow == 1)
                    x = base - 1;
            }
            if(!l1.hasNext()&&x==0)
                break;
            subtraction.add(x);
        }
    }
}