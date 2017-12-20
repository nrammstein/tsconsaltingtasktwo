package ru.killingmashine.task.two;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataLoaderImpl implements DataLoader {
    private List<String> listDataFromFile;

    public List<String> dataLoader(String fileName) {
        listDataFromFile=new ArrayList<String>();
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
    }
}
