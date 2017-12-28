package ru.killingmashine.task.two;

public class Data implements Comparable<Data>{
    private int id;
    private String value;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public int compareTo(Data o) {
        return Integer.valueOf(id).compareTo(o.id);
    }
}
