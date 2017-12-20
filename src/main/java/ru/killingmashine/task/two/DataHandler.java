package ru.killingmashine.task.two;

import java.util.*;

public class DataHandler {
    private List<String> listDataA;
    private List<String> listDataB;
    private List<String> resultArrayList = new ArrayList<String>();
    private List<String> resultLinkedList = new LinkedList<String>();
    private Map<Integer,String> resultHashMap = new HashMap<Integer,String>();
    public DataHandler(List<String> listDataA, List<String> listDataB) {
        this.listDataA = listDataA;
        this.listDataB = listDataB;
    }
    public void printResultArrayList(){
        for (String s :
                resultArrayList) {
            System.out.println(s);
        }
    }
    public void printResultLinkedList(){
        for (String s :
                resultLinkedList) {
            System.out.println(s);
        }
    }
    public void printResultHashMap(){
        for (Map.Entry<Integer, String> entry:
        resultHashMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }
    public List<String> getResultArrayList() {
        return resultArrayList;
    }

    public List<String> getResultLinkedList() {
        return resultLinkedList;
    }

    public Map<Integer, String> getResultHashMap() {
        return resultHashMap;
    }

    public void joinData(){
        String lineOne="ID  A.VALUE B.VALUE";
        System.out.println(lineOne);
        for (int i = 0; i < listDataA.size(); i++) {
            for (int j = 0; j < listDataB.size(); j++) {
                if (listDataA.get(i).split(",")[0].equals(listDataB.get(j).split(",")[0])){
                    String line =String.format("%s   %s       %s",listDataA.get(i).split(",")[0],
                            listDataA.get(i).split(",")[1],
                            listDataB.get(j).split(",")[1]);
                    resultArrayList.add(line);
                    resultLinkedList.add(line);
                    Collections.sort(resultLinkedList);
                    resultHashMap.put(resultHashMap.size()+1,line);
                }
            }
        }
    }
}
