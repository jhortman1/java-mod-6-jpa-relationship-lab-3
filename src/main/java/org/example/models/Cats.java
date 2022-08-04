package org.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Cats {
    @Id
    @GeneratedValue
    private int id;
    private  String name;
    private int age;
    private String breed;
    @ManyToMany
    private List<Owners>owners = new ArrayList<>();
    public void addOwner(Owners owner)
    {
        owners.add(owner);
    }
    public List<Owners> getOwners()
    {
        return owners;
    }
}
