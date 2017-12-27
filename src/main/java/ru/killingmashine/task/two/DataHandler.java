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
//        цикл по первой коллекции
        while (iteratorA.hasNext()){
//            счетчик шагов, на сколько нужно вернуться
            int count =1;
            Data dataA = iteratorA.next();
            int idA=dataA.getId();
            String valueA=dataA.getValue();
//            шагаем вперед по второй коллекции
            while(iteratorB.hasNext()){
                Data dataB = iteratorB.next();
                int idB=dataB.getId();
                String valueB=dataB.getValue();
//                если ид из 1 меньше, значит ушли слишком далеко
                if(idA<idB) {
//                    тут шагаем назад по второй коллекции, тк могут быть повторные значения в 1,
//                   но не слишком далеко, чтобы не обрабатывать обработанные данные
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
