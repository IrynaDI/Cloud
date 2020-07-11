package model;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Lob
    @Column(name = "data", columnDefinition = "BLOB")
    private byte[] data;
    private double size;

    public File() {}

    public File(String name,byte[] data){
        this.name = name;
        this.data = data;
        this.size = data.length/1000;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}