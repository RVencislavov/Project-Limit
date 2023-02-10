package com.example.Project.model;
//idPerson - primary key, уникална референция за клиент;
//име – име на клиент;
public class Client {
    private int id ;
    private String personName;

    public Client() {
    }

    public Client(int id, String personName) {
        this.id = id;
        this.personName = personName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + personName + '\'' +
                '}';
    }
}
