package ru.killingmashine.task.two;

import java.util.*;

public class DataHandler {
    private List<Data> listDataA;
    private List<Data> listDataB;
    public DataHandler(List<Data> listDataA, List<Data> listDataB) {
        this.listDataA = listDataA;
        this.listDataB = listDataB;
    }

    public ArrayList<String> joinDataInArrayList(){
       ArrayList<String> dataArrayList = new ArrayList<String>();
        for (int i = 0; i < listDataA.size(); i++) {
            Data dataA = listDataA.get(i);
            int idA=dataA.getId();
            String valueA = dataA.getValue();
            for (int j = 0; j < listDataB.size(); j++) {
                Data dataB = listDataB.get(j);
                int idB=dataB.getId();
                String valueB = dataB.getValue();
                if (idA == idB){
                    dataArrayList.add(idA+","+valueA+","+valueB);
                }
            }
        }
        return dataArrayList;
    }

    public LinkedList<String> joinDataInLinkedList(){
        LinkedList<String> linkedList = new LinkedList<String>();
        Collections.sort(listDataA);
        Collections.sort(listDataB);
        Iterator<Data> iteratorA = listDataA.iterator();
        ListIterator<Data> iteratorB=listDataB.listIterator();
//        ���� �� ������ ���������
        while (iteratorA.hasNext()){
//            ������� �����, �� ������� ����� ���������
            int count =1;
            Data dataA = iteratorA.next();
            int idA=dataA.getId();
            String valueA=dataA.getValue();
//            ������ ������ �� ������ ���������
            while(iteratorB.hasNext()){
                Data dataB = iteratorB.next();
                int idB=dataB.getId();
                String valueB=dataB.getValue();
//                ���� �� �� 1 ������, ������ ���� ������� ������
                if(idA<idB) {
//                    ��� ������ ����� �� ������ ���������, �� ����� ���� ��������� �������� � 1,
//                   �� �� ������� ������, ����� �� ������������ ������������ ������
                    for (int i =0;i < count;i++) {
                        iteratorB.previous();
                    }
                    break;
                }
                if (idA == idB) {
                    count++;
                    linkedList.add(idA + "," + valueA + "," + valueB);
                }

            }
        }
        return linkedList;
    }

    public HashMap<Integer,ArrayList<String>> joinDataInHashMap(LinkedList<String> stringLinkedList){
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        Iterator<String> iterator = stringLinkedList.iterator();
        while (iterator.hasNext()){
         String line = iterator.next();
         int id = Integer.parseInt(line.split(",")[0]);
         String valueA = line.split(",")[1];
         String valueB = line.split(",")[2];
         if(map.containsKey(id)){
             ArrayList<String> tmp=map.get(id);
             tmp.add(valueA+","+valueB);
         }else {
             ArrayList<String> tmp = new ArrayList<String>();
             tmp.add(valueA + "," + valueB);
             map.put(id, tmp);
         }
        }
        return map;

    }
}
