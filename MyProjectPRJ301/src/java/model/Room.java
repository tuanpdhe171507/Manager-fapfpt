/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Room {
    private int id;
    private String name;
    private String buldingName;

    public Room() {
    }

    public Room(int id, String name, String buldingName) {
        this.id = id;
        this.name = name;
        this.buldingName = buldingName;
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

    public String getBuldingName() {
        return buldingName;
    }

    public void setBuldingName(String buldingName) {
        this.buldingName = buldingName;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", buldingName=" + buldingName + '}';
    }

   
}
