package com.example.zhaozhiwen.heartbeatapplication.TestModel;

/**
 * Created by zhaozhiwen on 2016/4/21.
 */
public class Companies {
    private String name;
    private int id;
    public Companies(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
