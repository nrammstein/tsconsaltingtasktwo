package ru.killingmashine.task.two;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Just do it again");
        DataLoaderImpl dataLoader = new DataLoaderImpl();
        List<String> listA;
        List<String> listB;
        listA=dataLoader.dataLoader("C:\\files\\A.txt");
        listB=dataLoader.dataLoader("C:\\files\\B.txt");
        DataHandler dataHandler= new DataHandler(listA, listB);
        dataHandler.joinData();
        dataHandler.printResultHashMap();

    }
}
