package ru.killingmashine.task.two;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Test {


    public static int factorial(int n){
        int result;
        if(n==1) return 1;
        result=factorial(n-1)*n;
        return result;
    }
    public static void main(String[] args) {
        System.out.printf("%tc%n", new Date());
        System.out.println();
        Date date = new Date();
        System.out.printf("%tr %<td %<tB", new Date());


        System.out.println("\n");
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH) + " " +calendar.get(Calendar.MONTH)+ " " + calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE));


        int k = (int)2.2;
        int m = 10;
        int s =  1 >> k++ + ++m - --k - m-- << 1;
        System.out.println("s = " + s);
        System.out.println("k = " + k);
        System.out.println("m = " + m);
        System.out.println();


        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("c");
        System.out.println(list.indexOf("a"));
        System.out.println(list.lastIndexOf("a"));
    }

}
