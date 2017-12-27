package ru.killingmashine.task.two;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataLoaderImpl implements DataLoader {
    private List<Data> listDataFromFile=null;

    /*@Override
    public List<Data> dataLoader(String fileName) {
        listDataFromFile = new ArrayList<Data>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
                String line;
                while ((line=reader.readLine()) != null){
                    listDataFromFile.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return listDataFromFile;
    }*/

    public List<Data> dataLoader(String fileName) {
        listDataFromFile=new ArrayList<Data>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
                String line;
                while ((line=reader.readLine()) != null){
                    listDataFromFile.add(new Data(Integer.parseInt(line.split(",")[0]),line.split(",")[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return listDataFromFile;
    }
}
