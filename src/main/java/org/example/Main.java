package org.example;

import org.example.models.Cats;
import org.example.models.Owners;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        Owners o1 = new Owners();
        o1.setName("John");

        Owners o2 = new Owners();
        o2.setName("Jacob");

        Owners o3 = new Owners();
        o3.setName("Jingleheimer Schmidt");

        Cats c1 = new Cats();
        c1.setName("Bubbles");
        c1.setBreed("Lion");
        c1.setAge(1);

        Cats c2 = new Cats();
        c2.setName("Peanut");
        c2.setBreed("Cougar");
        c2.setAge(3);

        Cats c3 = new Cats();
        c3.setName("Patrick");
        c3.setBreed("Jaguarundi");
        c3.setAge(3);

        o1.addcats(c1);
        o2.addcats(c2);
        o2.addcats(c3);
        o3.addcats(c3);

        c1.addOwner(o1);
        c2.addOwner(o2);
        c3.addOwner(o3);
        c3.addOwner(o1);

        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(o1);
        entityManager.persist(o2);
        entityManager.persist(o3);
        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(c3);
        transaction.commit();
        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}