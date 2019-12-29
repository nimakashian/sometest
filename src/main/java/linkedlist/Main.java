package linkedlist;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> strings=new LinkedList<>();
        strings.push("1");
        strings.push("2");
        strings.push("3");
        strings.push("4");
        strings.push("5");
        strings.push("6");

        System.out.println(strings.element());
        System.out.println(strings.element());

        System.out.println("------------");
        for(String s: strings){
            System.out.println(s);
        }
    }
}
