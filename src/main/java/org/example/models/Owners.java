package org.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Owners {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany (mappedBy = "owners")
    private List<Cats> cats = new ArrayList<>();

    public void addcats(Cats cat)
    {
        cats.add(cat);
    }
    public List<Cats> getCats()
    {
        return cats;
    }
}
