import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void addParents() {
        Person father = new Person("John", "Doe", "Male",35);
        Person mother = new Person("Jane", "Doe", "Female",36);
        Person child = new Person("Joan", "Doe", "Female",10);

        child.addParents(father, mother);

        assertEquals(father, child.getFather());
        assertEquals(mother, child.getMother());
    }

    @Test
    void addChild() {
        Person parent = new Person("Jane", "Doe", "Female",36);
        Person child = new Person("Joan", "Doe", "Female",10);

        parent.addChild(child);

        assertTrue(parent.getChildren().contains(child));
    }

    @Test
    void addPet() {
        Person owner = new Person("John", "Doe", "Male",35);
        Pet pet = new Pet("Simba", 12, "cat");

        owner.addPet(pet);

        assertTrue(owner.getPets().contains(pet));
    }

    @Test
    void addSibling() {
        Person childOne = new Person("Joan", "Doe", "Female",10);
        Person childTwo = new Person("Jade", "Doe", "Female",5);

        childOne.addSibling(childTwo);

        assertTrue(childOne.getSiblings().contains(childTwo));
    }

    @Test
    void getGrandChildren() {
        Person grandparent = new Person("John Sr.", "Doe", "Male",71);
        Person parent = new Person("John", "Doe", "Male",35);
        Person childOne = new Person("Joan", "Doe", "Female",10);
        Person childTwo = new Person("Jade", "Doe", "Female",5);

        parent.addChild(childOne);
        parent.addChild(childTwo);
        grandparent.addChild(parent);

        assertTrue(grandparent.getGrandChildren().contains(childOne));
        assertTrue(grandparent.getGrandChildren().contains(childTwo));
    }
}