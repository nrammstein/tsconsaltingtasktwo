package ru.killingmashine.task.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Just do it again");
        DataLoaderImpl dataLoader = new DataLoaderImpl();
        List<Data> listA;
        List<Data> listB;
        ArrayList<String> resultArrayList;
        LinkedList<String> resultLinkedList;
        HashMap<Integer,ArrayList<String>> resultHashMap;
        listA=dataLoader.dataLoader("C:\\files\\A.txt");
        listB=dataLoader.dataLoader("C:\\files\\B.txt");
        DataHandler dataHandler= new DataHandler(listA, listB);
        resultArrayList=dataHandler.joinDataInArrayList();
        System.out.println("Result ArrayList " + resultArrayList);
        resultLinkedList=dataHandler.joinDataInLinkedList();
        System.out.println("Result LinkedList " + resultLinkedList);
        resultHashMap=dataHandler.joinDataInHashMap(dataHandler.joinDataInLinkedList());
        System.out.println("Result HashMap " + resultHashMap);



    }
}
